package com.yong.jpaoptimization;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.util.stream.IntStream;
import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.House;
import com.yong.jpaoptimization.entity.Job;
import com.yong.jpaoptimization.entity.Person;
import com.yong.jpaoptimization.entity.vo.Address;
import com.yong.jpaoptimization.repository.CarSpringDataRepository;
import com.yong.jpaoptimization.repository.HouseSpringDataRepository;
import com.yong.jpaoptimization.repository.JobSpringDataRepository;
import com.yong.jpaoptimization.repository.PersonSpringDataRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class JpaOptimizationApplication {
    @Autowired
    private InitService initService;

    @PostConstruct
    void init() {
        initService.service();
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaOptimizationApplication.class, args);
    }

    @Service
    @AllArgsConstructor
    static class InitService {
        private final PersonSpringDataRepository personSpringDataRepository;
        private final CarSpringDataRepository carSpringDataRepository;
        private final HouseSpringDataRepository houseSpringDataRepository;
        private final JobSpringDataRepository jobSpringDataRepository;

        @Transactional
        void service() {
            for(int i = 0; i < 30; i++) {
                var p = new Person(null, "person" + i, null, null, null);

                personSpringDataRepository.save(p);

                var job = new Job(null, "developer" + i, p);

                jobSpringDataRepository.save(job);

                for(int k = 0; k < 2; k++) {
                    var h = new House(null, new Address("pangyo" + k, "12345"), p);

                    houseSpringDataRepository.save(h);
                }

                for(int j = 0; j < 10; j++) {
                    var c = new Car(null, "car" + j, p);

                    carSpringDataRepository.save(c);
                }
            }
        }
    }
}

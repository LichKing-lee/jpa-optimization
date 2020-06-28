package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.IntStream;
import com.yong.jpaoptimization.entity.Alone;
import com.yong.jpaoptimization.entity.AloneChild;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AloneSpringDataRepositoryTest {
    @Autowired
    private AloneSpringDataRepository aloneSpringDataRepository;
    @Autowired
    private AloneChildSpringDataRepository aloneChildSpringDataRepository;
    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    @Rollback(false)
    @DisplayName("batch query")
    public void test1() {
        for(int i = 0; i < 10; i++) {
            Alone alone = new Alone(null, "hello");

            aloneSpringDataRepository.save(alone);

            for(int j = 0; j < 10; j++) {
                AloneChild child = new AloneChild(null, alone, "child");

                aloneChildSpringDataRepository.save(child);
            }
        }

//        batchUpdateTest();
    }

    private void batchUpdateTest() {
        List<Alone> alones = aloneSpringDataRepository.findAll();
        for(Alone a : alones) {
            a.setName(a.getName() + "!!");
        }
    }
}
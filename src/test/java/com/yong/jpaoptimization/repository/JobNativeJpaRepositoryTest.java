package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManagerFactory;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Optional;
import com.yong.jpaoptimization.entity.Job;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JobNativeJpaRepositoryTest {
    @Autowired
    private JobNativeJpaRepository jobNativeJpaRepository;

    @Test
    @DisplayName("fetch join")
    public void test1() {
        Job job = jobNativeJpaRepository.findByIdFetchJoin(1L);
    }

    @Test
    @DisplayName("inner join")
    public void test2() {
        Job job = jobNativeJpaRepository.findByIdJoin(1L);
    }

    @Test
    @DisplayName("find by id")
    public void test3() {
        Job job = jobNativeJpaRepository.findById(1L);
    }

    @Test
    @DisplayName("find by id jqpl")
    public void test4() {
        Job job = jobNativeJpaRepository.findByIdJpql(1L);
    }

    @Test
    @DisplayName("예측하지못한 EAGER 쿼리 실행")
    public void test5() {
        List<Job> jobs = jobNativeJpaRepository.findAll();
    }

    @Test
    public void monad() {
        Optional<String> optional1 = Optional.of("nate");
        Optional<String> optional2 = Optional.of("charlie");
        Optional<String> optional3 = Optional.of("cdragon");


        String s1 = optional1.flatMap(o -> optional2.flatMap(i -> optional3)).get();
        String s2 = optional2.flatMap(o -> optional2).flatMap(i -> optional3).get();

        System.out.println("s1 :: " + s1 + " s2 :: " + s2);
    }
}
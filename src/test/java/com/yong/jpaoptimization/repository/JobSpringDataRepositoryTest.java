package com.yong.jpaoptimization.repository;

import java.util.List;
import java.util.Optional;
import com.yong.jpaoptimization.entity.Job;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobSpringDataRepositoryTest {
    @Autowired
    private JobSpringDataRepository jobSpringDataRepository;

    @Test
    @DisplayName("예측하지못한 EAGER 쿼리 실행")
    public void test1() {
        List<Job> jobs = jobSpringDataRepository.findAll();
    }

    @Test
    @DisplayName("spring-data-jpa 에서 fetch join")
    public void test2() {
        List<Job> jobs = jobSpringDataRepository.findAll();
    }

    @Test
    @DisplayName("1건 조회")
    public void test3() {
        Optional<Job> job = jobSpringDataRepository.findById(1L);
    }
}
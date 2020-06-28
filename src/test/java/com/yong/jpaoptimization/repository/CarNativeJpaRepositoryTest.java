package com.yong.jpaoptimization.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarNativeJpaRepositoryTest {
    @Autowired
    private CarNativeJpaRepository carNativeJpaRepository;

    @Test
    void test1() {
        var c = carNativeJpaRepository.findById(1L);
        System.out.println("car :: " + c.getOwner().getId());
    }

    @Test
    void test2() {
        var c = carNativeJpaRepository.findByIdJpql(1L);
        System.out.println("car :: " + c.getOwner().getId());
    }

    @Test
    void test3() {
        var c = carNativeJpaRepository.findAll();
        System.out.println("cars :: " + c.size());
    }
}
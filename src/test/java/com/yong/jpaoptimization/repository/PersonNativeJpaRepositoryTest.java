package com.yong.jpaoptimization.repository;

import com.yong.jpaoptimization.entity.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonNativeJpaRepositoryTest {
    @Autowired
    private PersonNativeJpaRepository personNativeJpaRepository;

    @Test
    @DisplayName("OneToMany EAGER")
    public void test1() {
        Person p = personNativeJpaRepository.findById(1L);
    }

    @Test
    @DisplayName("OneToMany FETCH")
    public void test2() {
        Person p = personNativeJpaRepository.findByIdJqpl(1L);
    }

    @Test
    @DisplayName("OneToMany FETCH + job")
    public void test3() {
        Person p = personNativeJpaRepository.findByIdCarsJob(1L);
    }

    @Test
    @DisplayName("OneToMany FETCH + houses")
    public void test4() {
        Person p = personNativeJpaRepository.findByIdCarsHouses(1L);
    }
}
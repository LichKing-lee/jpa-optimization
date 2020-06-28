package com.yong.jpaoptimization.repository;

import com.yong.jpaoptimization.entity.dto.HouseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HouseNativeJpaRepositoryTest {
    @Autowired
    private HouseNativeJpaRepository houseNativeJpaRepository;

    @Test
    @DisplayName("DTO projection")
    void test1() {
        HouseDto dto = houseNativeJpaRepository.findDtoById(1L);

        System.out.println("DTO :: " + dto);
    }
}
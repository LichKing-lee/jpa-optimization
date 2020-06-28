package com.yong.jpaoptimization.repository;

import com.yong.jpaoptimization.entity.House;
import com.yong.jpaoptimization.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseSpringDataRepository extends JpaRepository<House, Long> {
}

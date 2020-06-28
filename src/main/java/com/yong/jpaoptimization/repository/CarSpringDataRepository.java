package com.yong.jpaoptimization.repository;

import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarSpringDataRepository extends JpaRepository<Car, Long> {
}

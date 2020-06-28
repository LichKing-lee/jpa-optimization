package com.yong.jpaoptimization.repository;

import java.util.List;
import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.Job;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSpringDataRepository extends JpaRepository<Job, Long> {
    @Override
    @EntityGraph(attributePaths = "person")
    List<Job> findAll();
}

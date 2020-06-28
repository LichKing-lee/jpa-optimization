package com.yong.jpaoptimization.repository;

import java.util.List;
import com.yong.jpaoptimization.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDataRepository extends JpaRepository<Person, Long> {
    @Override
    @EntityGraph(attributePaths = {"job"})
    Page<Person> findAll(Pageable p);

    @Override
    @EntityGraph(attributePaths = {"job", "cars"})
    List<Person> findAll();
}

package com.yong.jpaoptimization.repository;

import java.util.List;
import java.util.stream.IntStream;
import com.yong.jpaoptimization.entity.Person;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonSpringDataRepositoryTest {
    @Autowired
    private PersonSpringDataRepository personSpringDataRepository;

    @Test
    @DisplayName("list")
    public void test1() {
        List<Person> people = personSpringDataRepository.findAll();

        assertThat(people).hasSize(30);
    }

    @Test
    @DisplayName("paging")
//    @Transactional
//    @Rollback(false)
    public void test2() {
        PageRequest pageRequest = PageRequest.of(0, 5);

        Page<Person> people = personSpringDataRepository.findAll(pageRequest);

        assertThat(people).hasSize(5);
    }
}
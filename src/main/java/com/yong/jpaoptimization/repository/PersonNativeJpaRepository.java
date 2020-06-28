package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManager;
import com.yong.jpaoptimization.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class PersonNativeJpaRepository {
    private EntityManager entityManager;

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public Person findByIdJqpl(Long id) {
        return entityManager.createQuery("SELECT p FROM Person p JOIN FETCH p.cars WHERE p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Person findByIdCarsJob(Long id) {
        return entityManager.createQuery("SELECT p FROM Person p JOIN FETCH p.cars JOIN FETCH p.job WHERE p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public Person findByIdCarsHouses(Long id) {
        return entityManager.createQuery("SELECT p FROM Person p JOIN FETCH p.cars JOIN FETCH p.houses WHERE p.id = :id", Person.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}

package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManager;
import java.util.List;
import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.Person;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CarNativeJpaRepository {
    private final EntityManager entityManager;

    public Car findById(Long id) {
        return entityManager.find(Car.class, id);
    }

    public Car findByIdJpql(Long id) {
        return entityManager.createQuery(
                "SELECT c FROM Car c WHERE c.id = :id", Car.class
        ).setParameter("id", id).getSingleResult();
    }

    public List<Car> findAll() {
        return entityManager.createQuery("SELECT c FROM Car c", Car.class)
                .getResultList();
    }
}

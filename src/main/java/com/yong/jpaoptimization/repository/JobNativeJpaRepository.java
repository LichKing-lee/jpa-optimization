package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManager;
import java.util.List;
import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.Job;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JobNativeJpaRepository {
    private final EntityManager entityManager;

    public Job findById(Long id) {
        return entityManager.find(Job.class, id);
    }

    public Job findByIdJpql(Long id) {
        return entityManager.createQuery(
                "SELECT j FROM Job j WHERE j.id = :id", Job.class
        ).setParameter("id", id).getSingleResult();
    }

    public Job findByIdFetchJoin(Long id) {
        return entityManager.createQuery(
                "SELECT j FROM Job j JOIN FETCH j.person p WHERE j.id = :id", Job.class
        ).setParameter("id", id).getSingleResult();
    }

    public Job findByIdJoin(Long id) {
        return entityManager.createQuery(
                "SELECT j FROM Job j JOIN Person p ON j.person.id = p.id WHERE j.id = :id", Job.class
        ).setParameter("id", id).getSingleResult();
    }

    public List<Job> findAll() {
        return entityManager.createQuery("SELECT j FROM Job j", Job.class)
                .getResultList();
    }
}

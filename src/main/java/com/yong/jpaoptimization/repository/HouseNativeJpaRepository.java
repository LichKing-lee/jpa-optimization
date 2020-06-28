package com.yong.jpaoptimization.repository;

import javax.persistence.EntityManager;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.yong.jpaoptimization.entity.Car;
import com.yong.jpaoptimization.entity.House;
import com.yong.jpaoptimization.entity.Person;
import com.yong.jpaoptimization.entity.QHouse;
import com.yong.jpaoptimization.entity.dto.HouseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import static com.yong.jpaoptimization.entity.QHouse.house;
import static com.yong.jpaoptimization.entity.QPerson.person;

@Repository
public class HouseNativeJpaRepository {
    private JPAQuery<House> query;

    public HouseNativeJpaRepository(EntityManager entityManager) {
        query = new JPAQuery<>(entityManager);
    }

    public HouseDto findDtoById(Long id) {
        return query.select(Projections.constructor(HouseDto.class, house.id, house.owner.name))
                .from(house)
                .innerJoin(house.owner, person)
                .where(house.id.eq(id))
                .fetchOne();
    }
}

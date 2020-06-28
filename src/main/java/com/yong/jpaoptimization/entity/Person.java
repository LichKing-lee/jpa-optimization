package com.yong.jpaoptimization.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<Car> cars = new ArrayList<>();

    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<House> houses = new ArrayList<>();

    @Transient
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "person")
    private Job job;
}

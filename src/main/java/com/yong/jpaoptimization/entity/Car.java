package com.yong.jpaoptimization.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "car")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "car_name")
    private String name;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person owner;
}

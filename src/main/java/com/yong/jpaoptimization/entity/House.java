package com.yong.jpaoptimization.entity;

import javax.persistence.*;
import com.yong.jpaoptimization.entity.vo.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "house")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class House {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long id;

    @Embedded
    private Address address;

    @ManyToOne(optional = false)
    @JoinColumn(name = "person_id")
    private Person owner;
}

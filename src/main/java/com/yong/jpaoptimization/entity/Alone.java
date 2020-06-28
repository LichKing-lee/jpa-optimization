package com.yong.jpaoptimization.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alone")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Alone {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alone_id")
    private Long id;

    @Column(name = "alone_name")
    private String name;
}

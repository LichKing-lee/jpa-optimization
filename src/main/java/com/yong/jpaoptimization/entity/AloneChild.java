package com.yong.jpaoptimization.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AloneChild {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alone_child_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "alone_id", nullable = false)
    private Alone parent;

    @Column(name = "child_name")
    private String name;
}

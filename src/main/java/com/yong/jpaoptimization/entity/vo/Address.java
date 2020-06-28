package com.yong.jpaoptimization.entity.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;
}

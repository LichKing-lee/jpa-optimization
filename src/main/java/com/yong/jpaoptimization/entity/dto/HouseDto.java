package com.yong.jpaoptimization.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseDto {
    private Long houseId;
    private String ownerName;
}

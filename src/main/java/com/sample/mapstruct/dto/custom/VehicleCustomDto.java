package com.sample.mapstruct.dto.custom;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCustomDto implements Serializable {

    private Long id;

    private String numberPlate;

    private String represented;

}

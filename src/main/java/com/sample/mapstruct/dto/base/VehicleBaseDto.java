package com.sample.mapstruct.dto.base;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleBaseDto implements Serializable {

    private Long id;

    private Long entityVersion;

    private Long userId;

    private String numberPlate;

    private Boolean represented;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

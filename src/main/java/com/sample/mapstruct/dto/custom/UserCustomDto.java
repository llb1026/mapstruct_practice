package com.sample.mapstruct.dto.custom;

import com.sample.mapstruct.dto.unit.AddressDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCustomDto implements Serializable {

    private Long id;

    private String name;

    private String email;

    private AddressDto address;

    private List<VehicleCustomDto> vehicleList;

}

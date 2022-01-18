package com.sample.mapstruct.dto.unit;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto implements Serializable {

    private String zipCode;

    private String roadAddress;

    private String addressDetail;

}

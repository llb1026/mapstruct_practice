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
public class UserBaseDto implements Serializable {

    private Long id;

    private Long entityVersion;

    private String name;

    private String email;

    private String zipCode;

    private String roadAddress;

    private String addressDetail;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}

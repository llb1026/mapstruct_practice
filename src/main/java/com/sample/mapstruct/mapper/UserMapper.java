package com.sample.mapstruct.mapper;

import com.sample.mapstruct.dto.base.UserBaseDto;
import com.sample.mapstruct.dto.base.VehicleBaseDto;
import com.sample.mapstruct.dto.custom.UserCustomDto;
import com.sample.mapstruct.dto.custom.VehicleCustomDto;
import com.sample.mapstruct.dto.unit.AddressDto;
import com.sample.mapstruct.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = { VehicleMapper.class },
        imports = {AddressDto.class, UserCustomDto.class, VehicleCustomDto.class })
public interface UserMapper extends GenericMapper<UserBaseDto, UserEntity> {

    @Override
    UserBaseDto toDto(UserEntity entity);

    @Override
    UserEntity toEntity(UserBaseDto dto);

    @Named("toCustomUserDto")
    @Mapping(target = "address", expression = "java(AddressDto.builder()" +
            ".zipCode(userBaseDto.getZipCode())" +
            ".roadAddress(userBaseDto.getRoadAddress())" +
            ".addressDetail(userBaseDto.getAddressDetail()).build())")
    @Mapping(target = "vehicleList", source = "vehicleBaseDtoList", qualifiedByName = "toCustomVehicleDto")
    UserCustomDto toCustomDto(UserBaseDto userBaseDto, List<VehicleBaseDto> vehicleBaseDtoList);

}

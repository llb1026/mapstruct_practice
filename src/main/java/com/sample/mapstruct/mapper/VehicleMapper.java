package com.sample.mapstruct.mapper;

import com.sample.mapstruct.dto.base.VehicleBaseDto;
import com.sample.mapstruct.dto.custom.VehicleCustomDto;
import com.sample.mapstruct.entity.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        imports = { VehicleCustomDto.class })
public interface VehicleMapper extends GenericMapper<VehicleBaseDto, VehicleEntity> {

    @Override
    VehicleBaseDto toDto(VehicleEntity entity);

    @Override
    VehicleEntity toEntity(VehicleBaseDto dto);

    @Named("toCustomVehicleDto")
    @Mapping(target = "represented", expression = "java(baseDto.getRepresented() ? \"대표차량\" : \"일반차량\")")
    VehicleCustomDto toCustomDto(VehicleBaseDto baseDto);

}

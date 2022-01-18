package com.sample.mapstruct.mapper;

import com.sample.mapstruct.dto.base.VehicleBaseDto;
import com.sample.mapstruct.dto.base.VehicleBaseDto.VehicleBaseDtoBuilder;
import com.sample.mapstruct.dto.custom.VehicleCustomDto;
import com.sample.mapstruct.dto.custom.VehicleCustomDto.VehicleCustomDtoBuilder;
import com.sample.mapstruct.entity.VehicleEntity;
import com.sample.mapstruct.entity.VehicleEntity.VehicleEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T11:40:05+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public void updateFromDto(VehicleBaseDto dto, VehicleEntity entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getEntityVersion() != null ) {
            entity.setEntityVersion( dto.getEntityVersion() );
        }
        if ( dto.getCreatedAt() != null ) {
            entity.setCreatedAt( dto.getCreatedAt() );
        }
        if ( dto.getUpdatedAt() != null ) {
            entity.setUpdatedAt( dto.getUpdatedAt() );
        }
        if ( dto.getUserId() != null ) {
            entity.setUserId( dto.getUserId() );
        }
        if ( dto.getNumberPlate() != null ) {
            entity.setNumberPlate( dto.getNumberPlate() );
        }
        if ( dto.getRepresented() != null ) {
            entity.setRepresented( dto.getRepresented() );
        }
    }

    @Override
    public List<VehicleBaseDto> getDtoList(List<VehicleEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VehicleBaseDto> list = new ArrayList<VehicleBaseDto>( entityList.size() );
        for ( VehicleEntity vehicleEntity : entityList ) {
            list.add( toDto( vehicleEntity ) );
        }

        return list;
    }

    @Override
    public VehicleBaseDto toDto(VehicleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleBaseDtoBuilder vehicleBaseDto = VehicleBaseDto.builder();

        vehicleBaseDto.id( entity.getId() );
        vehicleBaseDto.entityVersion( entity.getEntityVersion() );
        vehicleBaseDto.userId( entity.getUserId() );
        vehicleBaseDto.numberPlate( entity.getNumberPlate() );
        vehicleBaseDto.represented( entity.getRepresented() );
        vehicleBaseDto.createdAt( entity.getCreatedAt() );
        vehicleBaseDto.updatedAt( entity.getUpdatedAt() );

        return vehicleBaseDto.build();
    }

    @Override
    public VehicleEntity toEntity(VehicleBaseDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleEntityBuilder vehicleEntity = VehicleEntity.builder();

        vehicleEntity.userId( dto.getUserId() );
        vehicleEntity.numberPlate( dto.getNumberPlate() );
        vehicleEntity.represented( dto.getRepresented() );

        return vehicleEntity.build();
    }

    @Override
    public VehicleCustomDto toCustomDto(VehicleBaseDto baseDto) {
        if ( baseDto == null ) {
            return null;
        }

        VehicleCustomDtoBuilder vehicleCustomDto = VehicleCustomDto.builder();

        vehicleCustomDto.id( baseDto.getId() );
        vehicleCustomDto.numberPlate( baseDto.getNumberPlate() );

        vehicleCustomDto.represented( baseDto.getRepresented() ? "대표차량" : "일반차량" );

        return vehicleCustomDto.build();
    }
}

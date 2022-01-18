package com.sample.mapstruct.mapper;

import com.sample.mapstruct.dto.base.UserBaseDto;
import com.sample.mapstruct.dto.base.UserBaseDto.UserBaseDtoBuilder;
import com.sample.mapstruct.dto.base.VehicleBaseDto;
import com.sample.mapstruct.dto.custom.UserCustomDto;
import com.sample.mapstruct.dto.custom.UserCustomDto.UserCustomDtoBuilder;
import com.sample.mapstruct.dto.custom.VehicleCustomDto;
import com.sample.mapstruct.dto.unit.AddressDto;
import com.sample.mapstruct.entity.UserEntity;
import com.sample.mapstruct.entity.UserEntity.UserEntityBuilder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-18T11:42:06+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.3.2.jar, environment: Java 16.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public void updateFromDto(UserBaseDto dto, UserEntity entity) {
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
        if ( dto.getName() != null ) {
            entity.setName( dto.getName() );
        }
        if ( dto.getEmail() != null ) {
            entity.setEmail( dto.getEmail() );
        }
        if ( dto.getZipCode() != null ) {
            entity.setZipCode( dto.getZipCode() );
        }
        if ( dto.getRoadAddress() != null ) {
            entity.setRoadAddress( dto.getRoadAddress() );
        }
        if ( dto.getAddressDetail() != null ) {
            entity.setAddressDetail( dto.getAddressDetail() );
        }
    }

    @Override
    public List<UserBaseDto> getDtoList(List<UserEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UserBaseDto> list = new ArrayList<UserBaseDto>( entityList.size() );
        for ( UserEntity userEntity : entityList ) {
            list.add( toDto( userEntity ) );
        }

        return list;
    }

    @Override
    public UserBaseDto toDto(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        UserBaseDtoBuilder userBaseDto = UserBaseDto.builder();

        userBaseDto.id( entity.getId() );
        userBaseDto.entityVersion( entity.getEntityVersion() );
        userBaseDto.name( entity.getName() );
        userBaseDto.email( entity.getEmail() );
        userBaseDto.zipCode( entity.getZipCode() );
        userBaseDto.roadAddress( entity.getRoadAddress() );
        userBaseDto.addressDetail( entity.getAddressDetail() );
        userBaseDto.createdAt( entity.getCreatedAt() );
        userBaseDto.updatedAt( entity.getUpdatedAt() );

        return userBaseDto.build();
    }

    @Override
    public UserEntity toEntity(UserBaseDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserEntityBuilder userEntity = UserEntity.builder();

        userEntity.name( dto.getName() );
        userEntity.email( dto.getEmail() );
        userEntity.zipCode( dto.getZipCode() );
        userEntity.roadAddress( dto.getRoadAddress() );
        userEntity.addressDetail( dto.getAddressDetail() );

        return userEntity.build();
    }

    @Override
    public UserCustomDto toCustomDto(UserBaseDto userBaseDto, List<VehicleBaseDto> vehicleBaseDtoList) {
        if ( userBaseDto == null && vehicleBaseDtoList == null ) {
            return null;
        }

        UserCustomDtoBuilder userCustomDto = UserCustomDto.builder();

        if ( userBaseDto != null ) {
            userCustomDto.id( userBaseDto.getId() );
            userCustomDto.name( userBaseDto.getName() );
            userCustomDto.email( userBaseDto.getEmail() );
        }
        if ( vehicleBaseDtoList != null ) {
            userCustomDto.vehicleList( vehicleBaseDtoListToVehicleCustomDtoList( vehicleBaseDtoList ) );
        }
        userCustomDto.address( AddressDto.builder().zipCode(userBaseDto.getZipCode()).roadAddress(userBaseDto.getRoadAddress()).addressDetail(userBaseDto.getAddressDetail()).build() );

        return userCustomDto.build();
    }

    protected List<VehicleCustomDto> vehicleBaseDtoListToVehicleCustomDtoList(List<VehicleBaseDto> list) {
        if ( list == null ) {
            return null;
        }

        List<VehicleCustomDto> list1 = new ArrayList<VehicleCustomDto>( list.size() );
        for ( VehicleBaseDto vehicleBaseDto : list ) {
            list1.add( vehicleMapper.toCustomDto( vehicleBaseDto ) );
        }

        return list1;
    }
}

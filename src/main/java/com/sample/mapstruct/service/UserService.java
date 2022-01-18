package com.sample.mapstruct.service;

import com.sample.mapstruct.dto.base.UserBaseDto;
import com.sample.mapstruct.dto.base.VehicleBaseDto;
import com.sample.mapstruct.dto.custom.UserCustomDto;
import com.sample.mapstruct.mapper.UserMapper;
import com.sample.mapstruct.mapper.VehicleMapper;
import com.sample.mapstruct.repository.UserRepository;
import com.sample.mapstruct.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private VehicleMapper vehicleMapper;

    public UserCustomDto findUser(Long userId) {
        UserBaseDto user = userMapper.toDto(userRepository.findById(userId).orElse(null));
        List<VehicleBaseDto> vehicleList = vehicleRepository.findAllByUserId(userId)
                .stream().map(vehicle -> vehicleMapper.toDto(vehicle)).collect(Collectors.toList());

        return userMapper.toCustomDto(user, vehicleList);
    }

}

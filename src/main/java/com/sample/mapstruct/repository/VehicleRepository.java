package com.sample.mapstruct.repository;

import com.sample.mapstruct.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> findAllByUserId(Long userId);

}

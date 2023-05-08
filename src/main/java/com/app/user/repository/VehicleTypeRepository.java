package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.VehicleTypeEntity;

public interface VehicleTypeRepository  extends PagingAndSortingRepository<VehicleTypeEntity, Long> {

}

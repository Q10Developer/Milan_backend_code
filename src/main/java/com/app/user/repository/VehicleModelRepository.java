package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.VehicleModelEntity;



public interface VehicleModelRepository extends PagingAndSortingRepository<VehicleModelEntity,Long>{

}

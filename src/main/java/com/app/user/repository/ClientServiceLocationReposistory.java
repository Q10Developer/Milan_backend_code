package com.app.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.ClientServiceLocationEntity;
import com.app.user.entity.VehicleInspectionDetailsEntity;
import com.app.user.entity.VehicleInspectionEntity;



public interface ClientServiceLocationReposistory  extends PagingAndSortingRepository<ClientServiceLocationEntity, Long> {

	List<ClientServiceLocationEntity> findByClientId(Long clientId);
	
	
}

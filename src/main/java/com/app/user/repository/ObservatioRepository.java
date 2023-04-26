package com.app.user.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.ObservationEntity;

public interface ObservatioRepository extends PagingAndSortingRepository < ObservationEntity, Long> {

	
	

	Optional<ObservationEntity> findById(Long observationId);

	
	
	  
	

}

package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.app.user.entity.TireConfigurationEntity;

public interface TireConfigurationRepository extends PagingAndSortingRepository < TireConfigurationEntity, Long> {

}

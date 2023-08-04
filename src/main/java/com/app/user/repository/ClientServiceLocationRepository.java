package com.app.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.ClientServiceLocationEntity;

public interface ClientServiceLocationRepository
		extends PagingAndSortingRepository<ClientServiceLocationEntity, Long> {

	List<ClientServiceLocationEntity> findByClientId(Long clientId);

}

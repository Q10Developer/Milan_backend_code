package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.ClientMasterEntity;

public interface ClientMasterRepository extends PagingAndSortingRepository<ClientMasterEntity, Long> {

}

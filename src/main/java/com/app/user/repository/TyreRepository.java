package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.TyreMasterEntity;

public interface TyreRepository extends PagingAndSortingRepository<TyreMasterEntity, Long> {

}

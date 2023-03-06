package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.app.user.entity.DropDownEntity;

public interface DropDownMasterRepository extends PagingAndSortingRepository<DropDownEntity, Long> {

}

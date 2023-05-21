package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.user.entity.ObservationCategoryEntity;



public interface ObservationCategoryRepository  extends PagingAndSortingRepository <ObservationCategoryEntity , Long> {

}

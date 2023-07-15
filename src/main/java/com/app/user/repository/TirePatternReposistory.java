package com.app.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;


import com.app.user.entity.TirePatternEntity;

public interface TirePatternReposistory extends  PagingAndSortingRepository < TirePatternEntity, Long>

{

}

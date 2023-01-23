package com.app.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.user.entity.ClientMasterEntity;

public interface ClientMasterRepository extends JpaRepository<ClientMasterEntity, Long> {

}

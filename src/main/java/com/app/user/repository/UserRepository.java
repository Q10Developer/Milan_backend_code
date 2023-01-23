package com.app.user.repository;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.user.entity.UserRegistrationEtity;

public interface UserRepository extends JpaRepository<UserRegistrationEtity,Long>{
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.password= ?1 where (u.id= ?2) AND (u.status= true)")
	 Integer updatePasswordById(
			 String  password,	
			 long id				
			);
	
	@Query(value = "SELECT c.id as id  FROM UserRegistrationEtity c WHERE c.password= :password AND (c.emailId= :emailId or c.mobileNumber= :mobileNumber) AND (c.status= true)")
	Map<String,Object> findIdByPasswordAndEmailOrMobile(
			@Param("password") String password,
			@Param("emailId") String emailId,
			@Param("mobileNumber") Long mobileNumber
				
			
			);
	
	
	@Query(value = "SELECT count(*) as count FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId or c.mobileNumber= :mobileNumber) AND (c.status= true)")
	long findCountByEmailOrMobile(
			@Param("emailId") String emailId,
			@Param("mobileNumber") Long mobileNumber
				
			
			);
	
	@Query(value = "SELECT c.password as password,c.id as id FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId) AND (c.status= true)")
	Map<String,Object> findPasswordAndUSerIdByEmail(
			@Param("emailId") String emailId			
			);
	
	@Query(value = "SELECT c.id as id FROM UserRegistrationEtity c WHERE  (c.emailId= :emailId) AND (c.status= true)")
	Map<String,Object> findUserIdByEmail(
			@Param("emailId") String emailId			
			);
	
}
  
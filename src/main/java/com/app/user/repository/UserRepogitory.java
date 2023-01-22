package com.app.user.repository;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.user.entity.UserRegistrationEtity;

public interface UserRepogitory extends JpaRepository<UserRegistrationEtity,Long>{
	//int countByPasswordAndMobileNumberOrDeviceId(String password,Long mobileNumber,String deviceId);
	//String findNameByPasswordAndMobileNumberOrDeviceId(String password,Long mobileNumber,String deviceId);
	  // @Query("select u.user_id,u.user_name,u.user_mobile,u.device_id,u.user_email from user_master u where u.user_mobile (:mobile) and u.password (:password)")
	   //UserRegistrationEtity getUserByMobileAndPassword(@Param("mobile") Long mobile,@Param("password") String password);
	//Object findMpinById(long id);
	
	/*@Query(value = "SELECT c.id as id,c.isFirstLogin as isFirstLogin,c.deviceId as deviceId,c.isLogout as isLogout FROM UserRegistrationEtity c WHERE c.password= :password AND (c.mobileNumber= :mobileNumber) AND (c.status= true)")
	Map<String,Object> findIdAndIsFirstLoginByPasswordAndMobileNumber(
			@Param("password") String password,
			@Param("mobileNumber") Long mobileNumber			
			);
	@Query(value = "SELECT c.mpin as mpin FROM UserRegistrationEtity c WHERE c.id= :id AND (c.status= true)")
	Map<String,Object> findMpinById(
			@Param("id") Long id			
			);
	
	
	@Query(value = "SELECT c.id as id,c.isFirstLogin as isFirstLogin,c.deviceId as deviceId,c.isLogout as isLogout FROM UserRegistrationEtity c WHERE c.password= :password AND (c.mobileNumber= :mobileNumber) AND (c.status= true)")
	Map<String,Object> findIIsFirstLoginByPasswordAndMobileNumber(
			@Param("password") String password,
			@Param("mobileNumber") Long mobileNumber			
			);
	
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.otp= ?1 where (u.id= ?2) AND (u.status= true)")
	 Integer updateOtpByUserId(
			String otp,
			long id	
			);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.mpin= ?1 , u.isFirstLogin=false where (u.id= ?2) AND (u.status= true)")
	 Integer updateMpinByUserId(
			int mpin,
			long id	
			);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.isLogout= ?1 where (u.id= ?2) AND (u.status= true)")
	 Integer updateLogoutStatusByUserId(
			 boolean status,
			long id	
			
			);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.isLogout= ?1,u.deviceId=?2 where (u.id= ?3) AND (u.status= true)")
	Integer updateLogoutStatusAndDiviceIdByUserId(
			 boolean status,
			 String deviceId,
			 long id	
			);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE UserRegistrationEtity u set u.password= ?1,u.isFirstLogin=true,u.isLogout=true where (u.mobileNumber= ?2) AND (u.status= true)")
	 Integer updatePasswordByMobile(
			 String  password,	
			 Long mobileNumber		
			
			);*/
	
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
  
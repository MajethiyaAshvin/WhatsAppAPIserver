package com.api.whatsappserver.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.whatsappserver.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
	
	
	UserEntity findByUsernameAndPassword(String Username,String password);
	UserEntity findByUserId(Long id);
	

}

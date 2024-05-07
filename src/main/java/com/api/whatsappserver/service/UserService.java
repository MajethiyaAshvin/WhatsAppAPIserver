package com.api.whatsappserver.service;

import com.api.whatsappserver.entity.UserEntity;
import com.api.whatsappserver.model.UserRequestModel;

public interface UserService {
	
	public void SaveUser(UserRequestModel entity);
	public UserEntity findyUsernameAndPassword(String Username,String password);
	UserEntity findByUserId(Long id);

}

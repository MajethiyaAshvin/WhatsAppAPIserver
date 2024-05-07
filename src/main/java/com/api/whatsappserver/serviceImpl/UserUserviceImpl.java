package com.api.whatsappserver.serviceImpl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.UserEntity;
import com.api.whatsappserver.model.UserRequestModel;
import com.api.whatsappserver.repository.UserRepository;
import com.api.whatsappserver.service.UserService;

@Service
@Transactional
public class UserUserviceImpl implements UserService {

	@Resource
	UserRepository userrepository;

	@Override
	public void SaveUser(UserRequestModel model) {
		// TODO Auto-generated method stub

		try {
		UserEntity entity = new UserEntity();
		if (model.getEmail() != null) {
			entity.setEmail(model.getEmail());
		}
		if (model.getLastSeen() != null) {
			entity.setLastSeen(model.getLastSeen());
		}
		entity.setPassword(model.getPassword());
		entity.setPhoneNumber(model.getPhoneNumber());
		entity.setUsername(model.getUsername());
	
		userrepository.save(entity);
		}catch (Exception e) {
			System.out.println(" error in Save User "+e.getMessage());
			// TODO: handle exception
		}
	}

	@Override
	public UserEntity findyUsernameAndPassword(String Username, String password) {
		// TODO Auto-generated method stub
		return userrepository.findByUsernameAndPassword(Username, password);
	}

	@Override
	public UserEntity findByUserId(Long id) {
		// TODO Auto-generated method stub
		return userrepository.findByUserId(id);
	}

}

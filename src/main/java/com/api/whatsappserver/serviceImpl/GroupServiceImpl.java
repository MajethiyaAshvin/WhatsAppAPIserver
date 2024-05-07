package com.api.whatsappserver.serviceImpl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.GroupEntity;
import com.api.whatsappserver.repository.GroupRepository;
import com.api.whatsappserver.service.GroupService;

@Service
@Transactional
public class GroupServiceImpl implements GroupService{

	
	@Resource
	GroupRepository groupRepository;
	
	@Override
	public void SaveGroup(GroupEntity entity) {
		// TODO Auto-generated method stub
		groupRepository.save(entity);
	}

}

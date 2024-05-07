package com.api.whatsappserver.serviceImpl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.UserConversationEntity;
import com.api.whatsappserver.repository.UserConversationRepository;
import com.api.whatsappserver.service.UserConversationService;

@Service
@Transactional
public class UserConversationServiceImpl implements UserConversationService{

	@Resource
	UserConversationRepository userConversationRepository;
	
	@Override
	public void SaveUserConversation(UserConversationEntity conversationEntity) {
		// TODO Auto-generated method stub
		userConversationRepository.save(conversationEntity);
	}
}

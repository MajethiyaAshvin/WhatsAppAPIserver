package com.api.whatsappserver.serviceImpl;

import java.sql.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.ConversationEntity;
import com.api.whatsappserver.repository.ConversationRepository;
import com.api.whatsappserver.service.ConversationService;
import com.api.whatsappserver.service.MessageService;

@Service
public class ConversationServiceImpl implements ConversationService{

	@Resource
	ConversationRepository conversationRepository;
	
	@Autowired MessageService mssageservice;
	@Override
	public ConversationEntity SaveConversation(ConversationEntity conversationEntity) {
		// TODO Auto-generated method stub
		
		ConversationEntity conversationEntity2=conversationRepository.save(conversationEntity);
	
		return conversationEntity2;
	}

}

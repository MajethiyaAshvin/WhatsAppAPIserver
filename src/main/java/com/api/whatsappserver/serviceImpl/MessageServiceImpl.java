package com.api.whatsappserver.serviceImpl;

import java.util.Date;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.ConversationEntity;
import com.api.whatsappserver.entity.MessageEntity;
import com.api.whatsappserver.entity.UserEntity;
import com.api.whatsappserver.repository.MessageRepository;
import com.api.whatsappserver.service.MessageService;

@Service
@Transactional
public class MessageServiceImpl implements MessageService{

	@Resource
	MessageRepository messageRepository;


	@Override
	public com.api.whatsappserver.entity.MessageEntity saveMessage(com.api.whatsappserver.entity.MessageEntity entity,
			ConversationEntity conversationEntity, UserEntity userEntity) {
		entity.setContent(conversationEntity.getConversationName());
		entity.setConversation(conversationEntity);
		entity.setSender(userEntity);
		entity.setRead(true);
		entity.setTimestamp(new Date());
		MessageEntity entity2=	messageRepository.save(entity);
		return entity2;
	}

}

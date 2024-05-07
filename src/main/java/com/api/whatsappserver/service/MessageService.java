package com.api.whatsappserver.service;

import com.api.whatsappserver.entity.ConversationEntity;
import com.api.whatsappserver.entity.MessageEntity;
import com.api.whatsappserver.entity.UserEntity;

public interface MessageService {
	
	public MessageEntity saveMessage(MessageEntity entity,ConversationEntity conversationEntity,UserEntity userEntity);

}

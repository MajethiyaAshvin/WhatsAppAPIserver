package com.api.whatsappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.whatsappserver.entity.ConversationEntity;
import com.api.whatsappserver.entity.MessageEntity;
import com.api.whatsappserver.entity.UserConversationEntity;
import com.api.whatsappserver.entity.UserEntity;
import com.api.whatsappserver.service.ConversationService;
import com.api.whatsappserver.service.MessageService;
import com.api.whatsappserver.service.UserConversationService;
import com.api.whatsappserver.service.UserService;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

	@Autowired
	ConversationService conversationService;

	@Autowired
	MessageService messageService;

	@Autowired
	UserService userService;
	
	@Autowired
	UserConversationService userConversationService;

	@PostMapping("/addconversation/{userid}")
	public String save(@RequestBody ConversationEntity requestModel, @PathVariable Long userid) {
		if (requestModel != null) {
			ConversationEntity conversationEntity = conversationService.SaveConversation(requestModel);

			if (conversationEntity != null) {
				MessageEntity entity = new MessageEntity();

				UserEntity userEntity = userService.findByUserId(userid);
				MessageEntity messageEntity= messageService.saveMessage(entity, conversationEntity, userEntity);
			
				
				UserConversationEntity conversationEntity2=new UserConversationEntity();
				conversationEntity2.setConversation(conversationEntity);
				conversationEntity2.setUser(userEntity);
				conversationEntity2.setLastReadMessageId(messageEntity.getMessageId());
				conversationEntity2.setAdmin(userEntity.isAdmin());
				userConversationService.SaveUserConversation(conversationEntity2);

				return "conversation added !";

			} else {
				return "Please Enter Valid Data!";
			}

		}

		return null;
	}
}

package com.api.whatsappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.whatsappserver.entity.UserConversationEntity;

@Repository
public interface UserConversationRepository extends JpaRepository<UserConversationEntity, Long> {

}

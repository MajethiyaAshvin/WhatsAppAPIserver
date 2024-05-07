package com.api.whatsappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.whatsappserver.entity.ConversationEntity;

@Repository
public interface ConversationRepository extends JpaRepository<ConversationEntity, Long> {

}

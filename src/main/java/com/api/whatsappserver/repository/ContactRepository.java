package com.api.whatsappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.whatsappserver.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long>{

	
}

package com.api.whatsappserver.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.whatsappserver.entity.ContactEntity;
import com.api.whatsappserver.repository.ContactRepository;
import com.api.whatsappserver.service.ContactService;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

	@Autowired
	ContactRepository contactRepository;

	@Override
	public void Save(ContactEntity contactEntity) {
		// TODO Auto-generated method stub
		contactRepository.save(contactEntity);
	} 
	
	
}

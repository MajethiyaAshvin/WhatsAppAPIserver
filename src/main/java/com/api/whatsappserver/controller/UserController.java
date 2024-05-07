package com.api.whatsappserver.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.whatsappserver.entity.ContactEntity;
import com.api.whatsappserver.entity.UserEntity;
import com.api.whatsappserver.model.ContactRequest;
import com.api.whatsappserver.model.UserRequestModel;
import com.api.whatsappserver.service.ContactService;
import com.api.whatsappserver.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userservice;
	
	@Autowired
	ContactService contactService;

	@Value("${upload.directory}")
	private String uploadDirectory;

	@PostMapping("/addUser")
	public String save(@RequestBody UserRequestModel requestModel) {
		if (requestModel != null) {
			userservice.SaveUser(requestModel);
			return "User Register Successfully!";
		} else {
			return "Please Enter Valid Data!";
		}

	}
	
	@PostMapping("/addContact")
	public String addContact(@RequestBody ContactRequest requestModel) {
		if (requestModel != null) {
			
			ContactEntity contactEntity=new ContactEntity();
			UserEntity user=userservice.findByUserId(requestModel.getUserid());
			UserEntity contactUser=userservice.findByUserId(requestModel.getContactuserid());
				contactEntity.setContactUser(contactUser);
				contactEntity.setUser(user);
				contactEntity.setFavorite(requestModel.isFavorite);
			contactService.Save(contactEntity);
			return "Added Contact Successfully!";
		} else {
			return "Please Enter Valid Data!";
		}

	}

	@PostMapping("/login")
	public String login(@RequestBody UserRequestModel requestModel) {

		UserEntity entity = userservice.findyUsernameAndPassword(requestModel.getUsername(),
				requestModel.getPassword());
		if (entity != null) {
			return "Login Success";

		} else {
			return "Please Enter Valid Data!";
		}

	}

	@GetMapping("/getMyProfile/{id}")
	public UserEntity getMyProfile(@PathVariable Long id) {

		UserEntity entity = userservice.findByUserId(id);
		if (entity != null) {
			return entity;

		} else {
			return null;
		}

	}

	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
			return "Please select a file to upload.";
		}
		try {
			Path directory = Paths.get(uploadDirectory);
			if (!Files.exists(directory)) {
				Files.createDirectories(directory);
			}
			Path filePath = directory.resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), filePath);
			return "File uploaded successfully: " + file.getOriginalFilename();
		} catch (IOException e) {
			return "Failed to upload file: " + e.getMessage();
		}
	}

}

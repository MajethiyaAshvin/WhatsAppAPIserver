package com.api.whatsappserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.whatsappserver.entity.GroupEntity;
import com.api.whatsappserver.model.GroupRequest;
import com.api.whatsappserver.service.GroupService;
import com.api.whatsappserver.service.UserService;

@RestController
@RequestMapping("/group")
public class GroupController {

	@Autowired
	GroupService groupService;

	@Autowired
	UserService userservice;

	@PostMapping("/addGroup")
	public String save(@RequestBody GroupRequest requestModel) {
		if (requestModel != null) {
			GroupEntity entity = new GroupEntity();
			entity.setGroupname(requestModel.getGroupname());
			/*
			 * List<Long> entities = new ArrayList<Long>(); for (Long id :
			 * requestModel.members) { entities.add(id); } entity.setMember(entities);
			 */
			groupService.SaveGroup(entity);
			return "Group added Successfully!";
		} else {
			return "Please Enter Valid Data!";
		}

	}

}

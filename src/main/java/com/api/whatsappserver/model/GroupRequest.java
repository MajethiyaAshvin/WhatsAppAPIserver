package com.api.whatsappserver.model;

import java.util.ArrayList;
import java.util.List;

public class GroupRequest {
	
	
	public List<Long> members=new ArrayList<Long>();

	public List<Long> getMembers() {
		return members;
	}

	public void setMembers(List<Long> members) {
		this.members = members;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String groupname;
	
	
}

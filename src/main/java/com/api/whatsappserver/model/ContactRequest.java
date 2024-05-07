package com.api.whatsappserver.model;

public class ContactRequest {
	
	public Long userid;
	public Long contactuserid;
	public boolean isFavorite;
	public boolean block;
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getContactuserid() {
		return contactuserid;
	}
	public void setContactuserid(Long contactuserid) {
		this.contactuserid = contactuserid;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	
	
	

}

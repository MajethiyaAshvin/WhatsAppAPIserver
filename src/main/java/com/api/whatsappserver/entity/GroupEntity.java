package com.api.whatsappserver.entity;

import javax.persistence.*;
@Entity
@Table(name = "groups")
public class GroupEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "Id")
	    private Long Id;

	    @Column(name = "groupname")
	    private String groupname;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getGroupname() {
			return groupname;
		}

		public void setGroupname(String groupname) {
			this.groupname = groupname;
		}
	    
	    
}

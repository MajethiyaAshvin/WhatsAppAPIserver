package com.api.whatsappserver.entity;

import javax.persistence.*;

@Entity
@Table(name = "Contact")
public class ContactEntity {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "contact_id")
	    private Long contactId;

	    @ManyToOne
	    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	    private UserEntity user;

	    @ManyToOne
	    @JoinColumn(name = "contact_user_id", referencedColumnName = "user_id")
	    private UserEntity contactUser;

	    @Column(name = "is_favorite")
	    private boolean isFavorite=false;

	    @Column
	    private boolean blocked=false;

		public Long getContactId() {
			return contactId;
		}

		public void setContactId(Long contactId) {
			this.contactId = contactId;
		}

		public UserEntity getUser() {
			return user;
		}

		public void setUser(UserEntity user) {
			this.user = user;
		}

		public UserEntity getContactUser() {
			return contactUser;
		}

		public void setContactUser(UserEntity contactUser) {
			this.contactUser = contactUser;
		}

		public boolean isFavorite() {
			return isFavorite;
		}

		public void setFavorite(boolean isFavorite) {
			this.isFavorite = isFavorite;
		}

		public boolean isBlocked() {
			return blocked;
		}

		public void setBlocked(boolean blocked) {
			this.blocked = blocked;
		}
	    
	    

}

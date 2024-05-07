package com.api.whatsappserver.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserConversation")
public class UserConversationEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_conversation_id")
    private Long userConversationId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    private ConversationEntity conversation;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "last_read_message_id")
    private Long lastReadMessageId;

	public Long getUserConversationId() {
		return userConversationId;
	}

	public void setUserConversationId(Long userConversationId) {
		this.userConversationId = userConversationId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public ConversationEntity getConversation() {
		return conversation;
	}

	public void setConversation(ConversationEntity conversation) {
		this.conversation = conversation;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Long getLastReadMessageId() {
		return lastReadMessageId;
	}

	public void setLastReadMessageId(Long lastReadMessageId) {
		this.lastReadMessageId = lastReadMessageId;
	}
}

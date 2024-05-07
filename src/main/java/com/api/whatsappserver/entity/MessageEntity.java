package com.api.whatsappserver.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Message")
public class MessageEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long messageId;

    @ManyToOne
    @JoinColumn(name = "conversation_id", referencedColumnName = "conversation_id")
    private ConversationEntity conversation;

    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "user_id")
    private UserEntity sender;

    @Column
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;

    @Column(name = "is_read")
    private boolean isRead;

	public Long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public ConversationEntity getConversation() {
		return conversation;
	}

	public void setConversation(ConversationEntity conversation) {
		this.conversation = conversation;
	}

	public UserEntity getSender() {
		return sender;
	}

	public void setSender(UserEntity sender) {
		this.sender = sender;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
    
    

}

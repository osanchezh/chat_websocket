package com.buffer.websocket.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.Objects;


@Document
public class ChatMessage {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
    private String content;
    private Date timestamp;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChatId() {
		return chatId;
	}
	public void setChatId(String chatId) {
		this.chatId = chatId;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getRecipientId() {
		return recipientId;
	}
	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
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
	@Override
	public String toString() {
		return "ChatMessage [id=" + id + ", chatId=" + chatId + ", senderId=" + senderId + ", recipientId="
				+ recipientId + ", content=" + content + ", timestamp=" + timestamp + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(chatId, content, id, recipientId, senderId, timestamp);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatMessage other = (ChatMessage) obj;
		return Objects.equals(chatId, other.chatId) && Objects.equals(content, other.content)
				&& Objects.equals(id, other.id) && Objects.equals(recipientId, other.recipientId)
				&& Objects.equals(senderId, other.senderId) && Objects.equals(timestamp, other.timestamp);
	}
	public ChatMessage(String id, String chatId, String senderId, String recipientId, String content, Date timestamp) {
		super();
		this.id = id;
		this.chatId = chatId;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.content = content;
		this.timestamp = timestamp;
	}
	public ChatMessage() {
		super();
	}
	
}
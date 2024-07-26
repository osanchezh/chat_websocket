package com.buffer.websocket.model;


import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
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
	@Override
	public String toString() {
		return "ChatRoom [id=" + id + ", chatId=" + chatId + ", senderId=" + senderId + ", recipientId=" + recipientId
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(chatId, id, recipientId, senderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatRoom other = (ChatRoom) obj;
		return Objects.equals(chatId, other.chatId) && Objects.equals(id, other.id)
				&& Objects.equals(recipientId, other.recipientId) && Objects.equals(senderId, other.senderId);
	}
	public ChatRoom(String id, String chatId, String senderId, String recipientId) {
		super();
		this.id = id;
		this.chatId = chatId;
		this.senderId = senderId;
		this.recipientId = recipientId;
	}
	public ChatRoom() {
		super();
	}
	
}
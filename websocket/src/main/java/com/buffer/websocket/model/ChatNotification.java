package com.buffer.websocket.model;

import java.util.Objects;

public class ChatNotification {
    private String id;
    private String senderId;
    private String recipientId;
    private String content;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "ChatNotification [id=" + id + ", senderId=" + senderId + ", recipientId=" + recipientId + ", content="
				+ content + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, id, recipientId, senderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChatNotification other = (ChatNotification) obj;
		return Objects.equals(content, other.content) && Objects.equals(id, other.id)
				&& Objects.equals(recipientId, other.recipientId) && Objects.equals(senderId, other.senderId);
	}
	public ChatNotification(String id, String senderId, String recipientId, String content) {
		super();
		this.id = id;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.content = content;
	}
	public ChatNotification() {
		super();
	}
	
}
package com.buffer.chat.model;

import java.util.Objects;

public class ChatMessage {

    public MessageType getType() {
		return type;
	}
	public void setType(MessageType type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	private MessageType type;
    private String content;
    private String sender;
	@Override
	public String toString() {
		return "ChatMessage [type=" + type + ", content=" + content + ", sender=" + sender + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, sender, type);
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
		return Objects.equals(content, other.content) && Objects.equals(sender, other.sender) && type == other.type;
	}
	public ChatMessage(MessageType type, String content, String sender) {
		super();
		this.type = type;
		this.content = content;
		this.sender = sender;
	}
	public ChatMessage() {
		super();
	}
    

}
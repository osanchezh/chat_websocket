package com.buffer.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.buffer.websocket.model.ChatMessage;
import com.buffer.websocket.model.ChatNotification;
import com.buffer.websocket.service.ChatMessageService;

import java.util.List;

@Controller
public class ChatController {

	@Autowired
    private SimpMessagingTemplate messagingTemplate;
	@Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        ChatNotification c = new ChatNotification(
                savedMsg.getId(),
                savedMsg.getSenderId(),
                savedMsg.getRecipientId(),
                savedMsg.getContent());
       // messagingTemplate.convertAndSendToUser(
       //         chatMessage.getRecipientId(), "/queue/messages",c);
        messagingTemplate.convertAndSend("/tem/"+chatMessage.getRecipientId()+ "/queue/messages", c);
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,
                                                 @PathVariable String recipientId) {
        return ResponseEntity
                .ok(chatMessageService.findChatMessages(senderId, recipientId));
    }
}
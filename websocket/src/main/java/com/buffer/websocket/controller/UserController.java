package com.buffer.websocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.buffer.websocket.model.User;
import com.buffer.websocket.service.UserService;

import java.util.List;

@Controller
public class UserController {
	@Autowired
    private UserService userService;

    @MessageMapping("/user.addUser")
    @SendTo("/topic/public")
    public User addUser(
            @Payload User user
    ) {
    	System.out.println("/user/public init");
    	if(user==null) {System.out.println("user is null");}
    	else
    	System.out.println("/user/public user="+user.toString());
        userService.saveUser(user);
        return user;
    }

    @MessageMapping("/user.disconnectUser")
    @SendTo("/topic/public")
    public User disconnectUser(
            @Payload User user
    ) {
        userService.disconnect(user);
        return user;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<User> findUser(@PathVariable String userId) {
        return ResponseEntity.ok(userService.findUser(userId));
    }
}
package com.buffer.websocket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buffer.websocket.model.Status;
import com.buffer.websocket.model.User;
import com.buffer.websocket.model.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
    private UserRepository repository;

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        repository.save(user);
    }

    public void disconnect(User user) {
        var storedUser = repository.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            repository.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return repository.findAllByStatus(Status.ONLINE);
    }

	public User findUser(String userId) {
		// TODO Auto-generated method stub
		Optional<User> p=repository.findById(userId);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
		
	}
}
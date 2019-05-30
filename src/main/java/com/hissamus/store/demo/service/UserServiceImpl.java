package com.hissamus.store.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hissamus.store.demo.model.User;
import com.hissamus.store.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	
	@Override
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
	}

}

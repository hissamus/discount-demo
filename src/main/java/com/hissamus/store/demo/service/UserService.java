package com.hissamus.store.demo.service;

import java.util.List;

import com.hissamus.store.demo.model.User;

public interface UserService {
	
	List<User> getAllUsers();
	User findByUsername(String name);

}

package com.qrsx.day02_springboot.service;

import java.util.List;

import com.qrsx.day02_springboot.pojo.User;

public interface UserService {
	public User getUserById(int id);
	
	public List<User> getAllUsers();
}

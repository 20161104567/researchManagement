package com.imnu.shop.service;

import com.imnu.shop.pojo.User;

public interface UserService {
	public User login(User user);

	public void register(User user);

	public boolean findUserByUserName(String username);

}

package com.qrsx.day02_springboot.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qrsx.day02_springboot.mapper.UserMapper;
import com.qrsx.day02_springboot.pojo.User;
import com.qrsx.day02_springboot.pojo.UserExample;
import com.qrsx.day02_springboot.service.UserService;
@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userMapper.selectByExample(new UserExample());
	}

}

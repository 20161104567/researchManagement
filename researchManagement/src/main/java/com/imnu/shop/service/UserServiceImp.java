package com.imnu.shop.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.shop.mapper.UserMapper;
import com.imnu.shop.pojo.User;
import com.imnu.shop.pojo.UserExample;
@Service
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;
	public User login(User user) {
		UserExample example=new UserExample();
		example.createCriteria().andUsernameEqualTo(user.getUsername()).andPwdEqualTo(user.getPwd());
		List<User> list = userMapper.selectByExample(example);
		return list==null?null:list.get(0);
	}
	public void register(User user) {
		user.setId(UUID.randomUUID().toString());
		userMapper.insert(user);
	}
	public boolean findUserByUserName(String username) {
		UserExample example=new UserExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<User> list = userMapper.selectByExample(example);//[]
		return list.size()==0?false:true;
	}

}

package com.qrsx.day02_springboot;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qrsx.day02_springboot.pojo.User;
import com.qrsx.day02_springboot.service.UserService;

@SpringBootTest
 @RunWith(SpringJUnit4ClassRunner.class) 
public class AppTest {
	@Autowired
	private UserService userService;
	@Test
	public void test1() {
//		User user = userService.getUserById(1);
//		System.out.println(user);
		
		List<User> list = userService.getAllUsers();
		for (User user : list) {
			System.out.println(user);
		}
	}
}

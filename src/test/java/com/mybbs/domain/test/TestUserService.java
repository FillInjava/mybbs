package com.mybbs.domain.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybbs.controller.UserController;
import com.mybbs.domain.User;
import com.mybbs.service.UserService;

public class TestUserService {
	public static void main(String[] args) {
		TestUserService ts =new TestUserService();
		ts.test();
	}
	
	@Test
	public void test(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService controller = ac.getBean(UserService.class);  
        //User user = controller.getById();
        System.out.println(controller);
        User user2 = new User();
        user2.setId(6);
        user2.setName("cc");
        user2.setUsername("cc");
        user2.setEmail("www.cc.com");
        user2.setPassword("cc");
        
        //controller.registe(user2);
        //System.out.println(user);
	}
}

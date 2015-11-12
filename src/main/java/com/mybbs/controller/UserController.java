package com.mybbs.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mybbs.domain.User;
import com.mybbs.service.UserService;

@Controller
public class UserController {
    @Resource(name="userService")
    private UserService userService;  
    
    @RequestMapping(value="/registe", method=RequestMethod.GET)  
    public String registe(User user) {  
        userService.registe(user);  
        return "index";  
    }  
   
    @RequestMapping(value="/getById", method=RequestMethod.GET)  
    public User getById() {  
        Integer id = 1;
        User user =  userService.getUserById(id); 
        return user;
    }
    @RequestMapping({"/","/home"})
    public String showUsers(Map<String,List<User>> model){
		List<User> userList = userService.getAllUsers();
		model.put("users", userList);
		return "home";
    }
}

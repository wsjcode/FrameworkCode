package day14.javapro.beans.controller;

import java.util.List;

import day14.javapro.beans.annotation.Autowired;
import day14.javapro.beans.annotation.Controller;
import day14.javapro.beans.pojo.User;
import day14.javapro.beans.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public User get(Integer id) {
		User user = userService.get(1);
		return user;
	}
	
	public List<User> queryAll(){
		List<User> userList = userService.queryAll();
		return userList;
	}
}

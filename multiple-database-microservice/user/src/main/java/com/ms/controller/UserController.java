package com.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.user.User;
import com.ms.entity.user.UserList;
import com.ms.facade.secvice.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public UserList getAll()
	{
		UserList userList = new UserList(this.userService.userList());
		return userList;
	}
	
	@GetMapping("/id/{id}")
	public User getById(@PathVariable("id")Integer id)
	{
		return this.userService.userById(id);
	}
	
	
	@PostMapping("/save")
	public User saveUser(@RequestBody User user)
	{
		User user1 = this.userService.saveUser(user);

		return user1;
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		User user1 = this.userService.updateUser(user);
		
		return user1;
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteUser(@PathVariable("id")Integer id)
	{
		Boolean status = this.userService.deleteUser(id);
		
		if(status)
			return status;
		
		return status;
	}
}

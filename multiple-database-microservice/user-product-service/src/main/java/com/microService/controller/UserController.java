package com.microService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.entity.User;
import com.microService.entity.UserDetail;
import com.microService.entity.UserList;
import com.microService.facade.UserDetailService;
import com.microService.facade.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/")
	public UserList getAll()
	{
		return this.userService.userList();
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

		if(user1 != null)
		{
			UserDetail userDetail = new UserDetail(user.getId(),user.getFirstName(),user.getLastName());
			UserDetail ud = this.userDetailService.saveUserDetail(userDetail);
			
			if(ud != null)
				return user1;
		}
		
		return user1;
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user)
	{
		User user1 = this.userService.updateUser(user);

		if(user1 != null)
		{
			UserDetail userDetail = new UserDetail(user.getId(),user.getFirstName(),user.getLastName());
			UserDetail ud = this.userDetailService.updateUserDetail(userDetail);
			
			if(ud != null)
				return user1;
		}
		
		return user1;
	}
	
	@DeleteMapping("/delete/{id}")
	public Boolean deleteUser(@PathVariable("id")Integer id)
	{
		User user = this.userService.userById(id);
		UserDetail userDetail = this.userDetailService.userDetailById(id);
		
		Boolean status = false;
		if(user.getId() == userDetail.getId())
		{
			status = this.userService.deleteUser(id);
			
			if(status)
			{
				status = this.userDetailService.deleteUserDetail(id);
			}
		}
		
		return status;
	}
}

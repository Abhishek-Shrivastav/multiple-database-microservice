package com.microService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microService.entity.UserDetail;
import com.microService.facade.UserDetailService;

@RestController
@RequestMapping("/user/detail")
public class UserDetailController {

	@Autowired
	private UserDetailService userDetailService;
	
	@GetMapping("/")
	public List<UserDetail> getAll()
	{
		return this.userDetailService.userDetailList();
	}
	
	@GetMapping("/id/{id}")
	public UserDetail getById(@PathVariable("id")Integer id)
	{
		return this.userDetailService.userDetailById(id);
	}
}

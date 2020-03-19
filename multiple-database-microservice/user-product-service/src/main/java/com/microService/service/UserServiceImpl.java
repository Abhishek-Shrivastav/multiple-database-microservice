package com.microService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microService.entity.User;
import com.microService.entity.UserList;
import com.microService.facade.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private RestTemplate restTemp;
	
	@Override
	public UserList userList() {

		return this.restTemp.getForObject("http://USER/user/all",UserList.class);
	}

	@Override
	public User userById(Integer id) {

		return this.restTemp.getForObject("http://USER/user/id/"+id,User.class);
	}

	@Override
	public User saveUser(User user) {
		
		return this.restTemp.postForObject("http://USER/user/save",user,User.class);
	}

	@Override
	public User updateUser(User user) {
		
		return this.restTemp.postForObject("http://USER/user/update",user,User.class);
	}

	@Override
	public Boolean deleteUser(Integer id) {
		
		return this.restTemp.getForObject("http://USER/user/delete/"+id,Boolean.class);
	}
}

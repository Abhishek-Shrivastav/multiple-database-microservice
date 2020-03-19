package com.ms.impl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.entity.user.User;
import com.ms.facade.secvice.UserService;
import com.ms.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> userList() {

		return this.userRepository.findAll();
	}

	@Override
	public User userById(Integer id) {

		Optional<User> optionals = this.userRepository.findById(id);
		
		User user = null;
		if(optionals.isPresent())
			user = optionals.get();
		
		return user;
	}

	@Override
	public User saveUser(User user) {
		
		return this.userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		return this.userRepository.saveAndFlush(user);
	}

	@Override
	public Boolean deleteUser(Integer id) {
		
		this.userRepository.deleteById(id);
		
		return true;
	}
}

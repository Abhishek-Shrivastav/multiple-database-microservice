package com.microService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microService.entity.UserDetail;
import com.microService.facade.UserDetailService;
import com.microService.repository.UserDetailRepository;

@Service
public class UserDeatilServiceImpl implements UserDetailService {

	@Autowired
	private UserDetailRepository userDetailRepository;
	
	@Override
	public List<UserDetail> userDetailList() {

		return this.userDetailRepository.findAll();
	}

	@Override
	public UserDetail userDetailById(Integer id) {

		Optional<UserDetail> optionals = this.userDetailRepository.findById(id);
		
		UserDetail userDetail = null;
		if(optionals.isPresent())
			userDetail = optionals.get();
		
		return userDetail;
	}

	@Override
	public UserDetail saveUserDetail(UserDetail user) {

		return this.userDetailRepository.save(user);
	}

	@Override
	public UserDetail updateUserDetail(UserDetail user) {

		return this.userDetailRepository.saveAndFlush(user);
	}

	@Override
	public Boolean deleteUserDetail(Integer id) {

		this.userDetailRepository.deleteById(id);
		
		return true;
	}
}

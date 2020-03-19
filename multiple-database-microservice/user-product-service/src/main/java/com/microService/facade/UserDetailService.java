package com.microService.facade;

import java.util.List;

import com.microService.entity.UserDetail;

public interface UserDetailService {

	List<UserDetail> userDetailList();
	UserDetail userDetailById(Integer id);
	UserDetail saveUserDetail(UserDetail user);
	UserDetail updateUserDetail(UserDetail user);
	Boolean deleteUserDetail(Integer id);
}

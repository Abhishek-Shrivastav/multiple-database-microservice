package com.microService.facade;

import com.microService.entity.User;
import com.microService.entity.UserList;

public interface UserService {

	UserList userList();
	User userById(Integer id);
	User saveUser(User user);
	User updateUser(User user);
	Boolean deleteUser(Integer id);
}

package com.ms.facade.secvice;

import java.util.List;

import com.ms.entity.user.User;

public interface UserService {

	List<User> userList();
	User userById(Integer id);
	User saveUser(User user);
	User updateUser(User user);
	Boolean deleteUser(Integer id);
}

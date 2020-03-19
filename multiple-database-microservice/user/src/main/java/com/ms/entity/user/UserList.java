package com.ms.entity.user;

import java.util.List;

public class UserList {

	private List<User> listUser;

	public UserList() {
		super();
	}

	public UserList(List<User> listUser) {
		super();
		this.listUser = listUser;
	}

	public List<User> getListUser() {
		return listUser;
	}
}

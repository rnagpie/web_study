package com.app.service.user;

import java.util.List;

import com.app.dto.user.User;


public interface UserService {

	public int saveUser(User user);

	public int saveAdminUser(User user);
	public int saveCustomerUser(User user);
	public List<User> findUserList();

	public User findUserById(String id);

	public User checkUserLogin(User user);

	int modifyUserPw(User user);
	int modifyUser(User user);
}

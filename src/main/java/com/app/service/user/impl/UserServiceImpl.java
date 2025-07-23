package com.app.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.common.CommonCode;
import com.app.dao.user.UserDAO;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	@Override
	public int saveUser(User user) {

		int result = userDAO.saveUser(user);

		return result;
	}

	@Override
	public int saveAdminUser(User user) {
		//관리자 계정 추가 할때 필요한 체크 로직....

		user.setUserType( CommonCode.USER_USERTYPE_ADMIN);
		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public int saveCustomerUser(User user) {
		//사용자 계정 추가 할때 필요한 체크 로직....

		user.setUserType("CUS");
		int result = userDAO.saveUser(user);

		return result;
	}

	@Override
	public List<User> findUserList() {
		
		List<User> userList = userDAO.findUserList();
		
		return null;
	}
	
	
	@Override
	public User findUserById(String id) {
		
		 User user = userDAO.findUserById(id);
		
		return user;
	}

	@Override
	public User checkUserLogin(User user) {
	
		//id pw 일치하는가?
		
		//사용자 정보를 조회해서, id pw 맞나 확인
		User loginUser = userDAO.findUserById(user.getId());
		
		if(loginUser != null && loginUser.getPw().equals(user.getPw())) {
			return loginUser;
		}
		// checkUserLogin 메소드 호출-> return null id,pw 틀림
		// return user 객체 ? => 맞음
	
		return null;
	
	/*
	  return 의미가 담긴 코드 (SUC, FAL, LCK)
	  int 숫자 return -> 1 성공 2 id 맞으나 비번틀림 3 아이디없음
	  					4 신고로 잠김 5 휴면계정 
	  
	  
	 
	  */
	
	
	
	
	
	
	}
}
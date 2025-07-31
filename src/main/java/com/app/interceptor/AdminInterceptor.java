package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;
import com.app.util.LoginManager;

public class Admininterceptor implements HandlerInterceptor{

	@Autowired
	UserService userService;


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//admin 경로로 시작하는 관리자 페이지에 접속하는 경우


		//로그인O +로그인한 계정이 관리자 계정(ADM1)


		if(LoginManager.isLogin(request)) {

			String userId = LoginManager.getLoginUserId(request);
			User user = userService.findUserById(userId);

			System.out.println("관리자 판단 인터셉터");
			System.out.println(user);

			if(user.getUserType().equals(CommonCode.USER_USERTYPE_ADMIN)) {
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}	else {
				response.sendRedirect("/error/badAceess");
				return false;
			}

			} 	else { //로그인이 안되어있다
				//response.sendRedirect("/admin/login");
				response.sendRedirect("/error/badAccess");
				return false;
		}
	}
}

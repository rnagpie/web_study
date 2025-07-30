package com.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.app.util.LoginManager;

public class LoginInterceptor implements HandlerInterceptor {

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		System.out.println("여기서 인터셉터 preHandle");
		//로그인 안했으면? 진행x ->로그인부터
		if(LoginManager.isLogin(request) == false) {
			response.sendRedirect("/customer/signin");
			return false;
		}
		//로그인 했으면? 그냥 진행
		
		
		return HandlerInterceptor.super.preHandle(request, response, handler);
	
	} 	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
	
		// 
		
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}		
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("여기는 인터셉터 afterCompletion");
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}






}




	

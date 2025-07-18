package com.app.controller.study.practice.practice13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; // HttpServletResponse 임포트 추가

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Practice13Controller {

	@GetMapping("/practice13/hideAd")
	public String hideAd(HttpServletRequest request) {
		String hideAd = MyCookieUtil.getCookie(request,"hideAd"); // 변수 hideAd 선언
		if(hideAd !=null) { // hide 변수명 오타 수정
			request.setAttribute("hide", "hideAd"); // "hiedAd" 오타 수정
		}
		// 'hideAd' 메소드의 닫는 중괄호가 이 return 문 이후에 와야 함
		return "practice/practice13/hideAd"; // 기존 코드에서 이곳에 return이 없었으므로 추가
	} // <-- 닫는 중괄호 위치 수정 (원래 코드에서는 이 위치에 중괄호가 없어서 오류)

	@PostMapping("/practice13/hideAd")
	public String hideAdAction(HttpServletRequest request, HttpServletResponse response) { // HttpServletResponse 추가

		System.out.println(request.getParameter("hideAd"));
		//24시간 보지않기 체크후 요청을 했으면?
		//쿠키에 값 저장 -> 나중에 해당 화면 접근시, 광고 표시 여부로 활용

		if(request.getParameter("hideAd") != null) {
			Cookie ck =MyCookieUtil.createCookie("hideAd", "hideAd", 60 * 60 * 24);
			response.addCookie(ck); // response 오류 해결
		}

		// return 문은 메소드의 마지막에 위치해야 함
		return "redirect:/practice13/hideAd"; 
	}

}
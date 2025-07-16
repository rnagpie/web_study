package com.app.controller.study.practice.practice11;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice11Controller {

	
	
	
	// 
	@GetMapping("/practice11/first")
	public String handleFirst(Model model, HttpSession session) { 
		
		String accessUrlFromSession = (String) session.getAttribute("overrideAccessUrl");

		if (accessUrlFromSession != null) {
			// 
			model.addAttribute("accessUrl", accessUrlFromSession);
			// 
			session.removeAttribute("overrideAccessUrl");
		} else {
			// 
			model.addAttribute("accessUrl", "/first");
		}

		return "practice/practice11/targetPage";
	}
	
	
	/* @GetMapping("/practice11/first")
	public String handleFirst(Model model) {

		model.addAttribute("accessUrl", "/first");

		return "practice/practice11/targetPage"; 
	} */

	@GetMapping("/practice11/firsthide1")
	public String handleFirstHide1(Model model) {

		model.addAttribute("accessUrl", "/firsthide1");


		return "practice/practice11/targetPage";

		//return "forward:/WEB-INF/views/practice/practice11/targetPage.jsp";

	}


	@GetMapping("/practice11/firsthide2")
	public String handleFirstHide2(Model model) {


		return "redirect:/practice11/first"; 
	}

	@GetMapping("/practice11/firsthide3")
	public String handleFirstHide3(HttpSession session) {
		
		session.setAttribute("accessUrl", "/firsthide3");
		return "redirect:/practice11/first";
	}
}

//--------------------------------------------------
//firsthide3

//
/* 
	@GetMapping("/practice11/firsthide3")
	public String handleFirstHide2(Model model) {
///model.
	return "redirect:/practice11/first"; 

} 
	*/
























































/*	
@GetMapping("/practice11/first")
public String handleFirst(Model model, HttpSession session) {

	String accessUrlFromSession = (String) session.getAttribute("overrideAccessUrl");
	if (session.getAttribute("accessUrl")== null) {// 없음 hide3를 들리지않음

	}else { //세션에 "accessUrl" 들어왔다. -> hide3를 들렸다가 건너왔다.
		//model.addAttribute("accessUrl","/firsthide3");		
		model.addAttribute("accessUrl", session.getAttribute("accessUrl"));
		//										/fisrthide3
		//										/fisrthide4 /firsthide5

		//session.removeAttribute("accessUrl");// 특정 키값으로 삭제 -작은거
		session.invalidate();// 세션클리어
	}	
		
		
		return "practice/practice11/targetPage";
*/	
///--------------------------------------------------------		















	// 2) localhost:8080/practice11/first 로 접근했을 때
	// 화면에 ${accessUrl} 은 "/first" 로 표시되고, URL은 /first 유지





	// 3) localhost:8080/practice11/firsthide1 로 접근했을 때
	// 화면에 ${accessUrl} 은 "/firsthide1" 로 표시되고, URL은 /firsthide1 유지
	// 'forward:' 접두사를 사용해도 URL은 변경되지 않습니다.








	// 4) localhost:8080/practice11/firsthide2 로 접근했을 때
	// 화면에 ${accessUrl} 은 "/first" 로 표시되고, URL은 /first 로 변경
	// 'redirect:' 접두사를 사용하여 다른 URL로 클라이언트 재요청 유도
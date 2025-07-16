package com.app.controller.study.practice.practice10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller

public class Practice10Controller {

	@GetMapping("/practice10/A")
	public String showA (Model model) {
		model.addAttribute("message", "FromA");
		return "practice/practice10/display";
	}


	@GetMapping("/practice10/B")
	public String showB (Model model) {
		model.addAttribute("message", "FromB");
		model.addAttribute("messageFromB", "FromB");
		return "practice/practice10/display";
	}

	@GetMapping("/practice10/resetSession")
	public String resetSession (SessionStatus status) {
		status.setComplete();
		return "redirect:/practice10/A";
	}
	


}


/*@Controller

public class Practice10Controller {
	
	
	@GetMapping("/pratice10/A")
	public String a(Model model) {
		model.addAttribute("fromA", "fromA");
		//....
		return"pracice/practice10/a";
	}


	@GetMapping("/pratice10/B")
	public String b(HttpServletRequest session) {
	//public String b(HttpServletRequest request) {
		
		//request / session / application(프로젝트 하나만 왠만해선 사용X)
		
		//requset : 각 요청별 독립
		//session : 브라우저(사용자) 별로 구분 사용
		
		session.setAttribute("FromBMsg", "FromB");
		
		return"pracice/practice10/b";
	}
}*/


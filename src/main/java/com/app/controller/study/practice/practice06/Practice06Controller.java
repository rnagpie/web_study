package com.app.controller.study.practice.practice06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice06Controller {

	/*
   	1. /practice06/ask-bmi 경로로 요청시, 화면에는
	이름 / 키 / 몸무게를 입력하는 항목과 확인하기 버튼이 있습니다.
	버튼 submit 발생
	*/
	@GetMapping("/practice06/ask-bmi")
	public String ask_bmi() {
		
		return "practice/practice06/ask-bmi";
	}

	/*
	2. /practice06/result-bmi 경로로 이동하여
	요청에 따라서 컨트롤러가 비만도를 계산해서 결과를 보여줍니다. 
	*/

}
package com.app.controller.study.jstl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dto.study.Product;


@Controller
@RequestMapping("/jstl")
public class jstl01Controller {
	
	
	@GetMapping("/jstl1")
	public String jstl1(Model model){

		model.addAttribute("msg", "오늘은 무료 커피");
	
		// 단일 Product 객체 생성 및 모델에 추가
		Product product = new Product();
		product.setId("proId");
		product.setName("proName");
		model.addAttribute("product", product);
		
		// Product 리스트 생성 및 데이터 추가
		List<Product> productList = new ArrayList<>();
		
		// Product 객체를 생성하고 값을 설정한 뒤 리스트에 추가합니다.
		productList.add(new Product("id1", "name1", 1));
		productList.add(new Product("id2", "name2", 2));
		productList.add(new Product("id3", "name3", 3));
		productList.add(new Product("id4", "name4", 4));
		productList.add(new Product("id5", "name5", 5));
		
		model.addAttribute("productList", productList); // 이 라인은 한 번만 필요합니다.
		
		//coffee juice water
		model.addAttribute("drinkType", "juice");
		
		//user admin
		model.addAttribute("userType", "user"); // admin 주석 처리 후 user로 설정
		
		model.addAttribute("isLogin", true); // true: 로그인 O false: 로그인 x
		
		
		
		return "jstl/jstl1"; 
	}


	@GetMapping("/jstl2")
	public String jstl12(Model model) {
		
		
		model.addAttribute("msg1","<부등호>");
		model.addAttribute("msg2","&lt;부등호&gt");
		
		
		model.addAttribute("msgXml","<script>alert('경고!')</script>");
		
		return "jstl/jstl2";
	}















}
package com.app.controller.study.practice.practice05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice05") // 모든 요청에 대해 /practice05 경로가 붙음
public class Practice05Controller {

    @GetMapping("/pathA")
    public String showQuizPageA(Model model) {
        model.addAttribute("quizPageId", "A");
        model.addAttribute("productInfo", "상품 정보: 퀴즈 페이지 A에 대한 특별 상품입니다.");
        return "practice05/quizPage"; // 공통 JSP 파일 사용
    }

    @GetMapping("/pathB")
    public String showQuizPageB(Model model) {
        model.addAttribute("quizPageId", "B");
        model.addAttribute("productInfo", "상품 정보: 퀴즈 페이지 B에 대한 베스트셀러 상품입니다.");
        return "practice05/quizPage"; // 공통 JSP 파일 사용
    }

    @GetMapping("/pathCommon/{id}")
    public String showCommonQuizPage(@PathVariable String id, Model model) {
        String productInfo;
        String quizPageId;

        if ("A".equalsIgnoreCase(id)) {
            quizPageId = "A (Common)";
            productInfo = "상품 정보: 공통 경로를 통해 접근한 퀴즈 페이지 A 상품입니다.";
        } else if ("B".equalsIgnoreCase(id)) {
            quizPageId = "B (Common)";
            productInfo = "상품 정보: 공통 경로를 통해 접근한 퀴즈 페이지 B 상품입니다.";
        } else {
            quizPageId = "알 수 없음";
            productInfo = "상품 정보: 요청하신 페이지를 찾을 수 없습니다.";
        }

        model.addAttribute("quizPageId", quizPageId);
        model.addAttribute("productInfo", productInfo);
        return "practice05/quizPage"; // 공통 JSP 파일 사용
    }
}



































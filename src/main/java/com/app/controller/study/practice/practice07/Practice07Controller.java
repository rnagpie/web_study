package com.app.controller.study.practice.practice07; // 패키지 경로는 사용자 프로젝트에 맞게 조정하세요.

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.practice.practice07.Member; // Member DTO 임포트

@Controller
@RequestMapping("/practice07")
public class Practice07Controller {

    @GetMapping("/listTest")
    public String listTest(@RequestParam(name = "type", required = false) String type, Model model) {
        System.out.println("listTest 요청 - type: " + type);
        
        if ("str".equals(type)) {
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                strList.add("스트링 리스트입니다.");
            }
            model.addAttribute("resultList", strList); // "strList" 대신 "resultList"로 통일하여 사용
            model.addAttribute("listType", "string");
        } else if ("member".equals(type)) {
            List<Member> memberList = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                memberList.add(new Member("아이디" + i, "비번" + i, "이름" + i));
            }
            model.addAttribute("resultList", memberList); // "memberList" 대신 "resultList"로 통일하여 사용
            model.addAttribute("listType", "member");
        } else {
            // type 파라미터가 없거나, "str", "member"가 아닌 경우 처리
            model.addAttribute("resultList", new ArrayList<>()); // 빈 리스트 전달
            model.addAttribute("listType", "none");
            model.addAttribute("message", "유효한 'type' 파라미터(str 또는 member)를 입력해주세요.");
        }

        return "practice07/listResult"; // 뷰 이름 지정
    }
}
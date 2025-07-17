package com.app.controller.study.practice.practice12;

import javax.servlet.http.HttpSession; // HttpSession 임포트

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Model 임포트
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // PostMapping 임포트
import org.springframework.web.bind.annotation.RequestParam; // RequestParam 임포트

@Controller
public class Practice12Controllers {

    // 경로 1) /practice12/login (GET방식)
    // ID와 PW를 입력하는 화면이 발생됨
    @GetMapping("/practice12/login")
    public String showLoginForm() {
        return "practice/practice12/login"; // login.jsp 뷰 이름 반환
    }

    // 경로 1) /practice12/login (POST방식)
    // 입력한 ID와 PW를 확인하여 정상인경우로 간주하고,
    // 세션에 해당 ID를 로그인한 아이디로 저장하고 /practice12/count 페이지로 이동시킨다
    @PostMapping("/practice12/login")
    public String handleLogin(@RequestParam String id, // 폼에서 넘어온 id 파라미터 받기
                              @RequestParam String pw, // 폼에서 넘어온 pw 파라미터 받기
                              HttpSession session) {   // HttpSession 주입 받기

        // 실제 애플리케이션에서는 ID와 PW를 확인하는 복잡한 인증 로직이 들어갑니다.
        // 여기서는 ID/PW 무관하게 '항상 정상'으로 간주합니다.
        boolean isAuthenticated = true;

        if (isAuthenticated) {
            session.setAttribute("loggedInId", id); // 세션에 ID 저장
            session.setAttribute("accessCount", 0); // **로그인 시 accessCount를 0으로 초기화**
            System.out.println("로그인 성공: 세션에 ID '" + id + "', Count '0' 저장됨.");
            return "redirect:/practice12/count"; // /practice12/count 페이지로 리다이렉트
        } else {
            // 인증 실패 시 로그인 페이지로 다시 이동 (필요하다면 에러 메시지 전달)
            System.out.println("로그인 실패: ID 또는 PW 불일치.");
            return "redirect:/practice12/login?error=true";
        }
    }

    // 경로 2) /practice12/count
    // 화면에는 어떤 사용자가 로그인한 상태인지 "사용자 아이디"가 표시되며,
    // 해당 사용자가 로그인한 이후, 현재 페이지에 몇 번 접속했는지의 횟수가 함께 화면에 표시됨.
    @GetMapping("/practice12/count")
    public String showCountPage(HttpSession session, Model model) {
        String loggedInId = (String) session.getAttribute("loggedInId");

        if (loggedInId == null) {
            // 세션에 loggedInId가 없으면 로그인되지 않은 상태이므로 로그인 페이지로 리다이렉트
            System.out.println("접근 거부: 로그인되지 않은 사용자. 로그인 페이지로 리다이렉트.");
            return "redirect:/practice12/login";
        } else {
            // 로그인되어 있으면
            Integer accessCount = (Integer) session.getAttribute("accessCount");

            // 세션에 accessCount가 없거나 (예외적인 상황, 혹은 직접 세션 조작 시)
            // 로그인했지만 초기화되지 않은 경우를 대비하여 0으로 설정
            if (accessCount == null) {
                accessCount = 0;
            }

            accessCount++; // **접속 횟수 1 증가**
            session.setAttribute("accessCount", accessCount); // **증가된 횟수를 세션에 다시 저장**

            model.addAttribute("loggedInId", loggedInId);
            model.addAttribute("accessCount", accessCount);
            System.out.println("접근 허용: ID - " + loggedInId + ", Count - " + accessCount);
            return "practice/practice12/count"; // count.jsp 뷰 이름 반환
        }
    }

    // 경로 3) /practice12/logout
    // 위 경로로 접근 시, 세션에 저장되어있는 기록을 삭제하고 로그인한 이력이 없는것으로 만든다.
    // 이후, /practice12/count 페이지로 이동 시킨다.
    @GetMapping("/practice12/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // **세션 전체 무효화 (loggedInId, accessCount 모두 제거)**
        System.out.println("로그아웃 성공: 세션 무효화됨.");
        return "redirect:/practice12/count"; // /practice12/count 페이지로 리다이렉트
                                            // (이후 count 페이지에서 로그인 안 됨 확인 후 login으로 다시 리다이렉트)
    }
}
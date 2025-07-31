package com.app.validator;

import com.app.dto.user.User;
import com.app.dto.user.UserValidError;

public class UserCustomValidator {

//	public static boolean validateAdminUsersAdd(User user, UserValidError userValidError) {

		public static boolean validate(User user, UserValidError userValidError) {


		boolean result = true;

		//유효성 검증 비교 
		if(user.getId() == null || user.getId().trim()== "") {
			userValidError.setId("아이디 입력을 안했습니다");
			result = false;
		}

		if(user.getId().equals("admin")) {
			userValidError.setId("이건 아이디로 사용불가입니다");
		}

		// ID 길이 제한에 대한 에러는 "id" 필드에 rejectValue를 해야 합니다.
		if(user.getId().length() <2 || user.getId().length() > 15) {
			userValidError.setPw("비밀번호는 8~12 글자 제한입니다");

		}
		return result;
	}





} 



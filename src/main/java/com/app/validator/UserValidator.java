package com.app.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.dto.user.User;

public class UserValidator implements Validator  {
	@Override
	public boolean supports (Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		User user = (User)target;

		//유효성 검증 비교 
		if(user.getId() == null || user.getId().trim()== "") {
			errors.rejectValue("id", "EmptyUserId", "아이디 미입력");
		}

		if(user.getId().equals("admin")) {
			errors.rejectValue("id", "InvalidUserId", "사용할 수 없는 아이디입니다."); // 에러 메시지 수정
		}
		
		// ID 길이 제한에 대한 에러는 "id" 필드에 rejectValue를 해야 합니다.
		if(user.getId().length() <2 || user.getId().length() > 15) {
			errors.rejectValue("id", "SizeUserId", "아이디는 2자 이상 15자 이하로 입력해주세요."); // 필드와 메시지 수정
		}
	}
}
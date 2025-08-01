package com.app.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserProfileRequestForm {

	String id;
	String name;
	MultipartFile profileImage;
}

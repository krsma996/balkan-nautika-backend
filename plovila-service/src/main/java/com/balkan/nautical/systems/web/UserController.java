package com.balkan.nautical.systems.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.balkan.nautical.systems.dto.UserDto;
import com.balkan.nautical.systems.service.UserService;
import com.balkan.nautical.systems.web.api.UserApi;

import lombok.RequiredArgsConstructor;





@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
	
	private final UserService userService;
	

	@Override
	public ResponseEntity<UserDto> create(UserDto toCreate) {
		// TODO Auto-generated method stub
		return null;
	}

}

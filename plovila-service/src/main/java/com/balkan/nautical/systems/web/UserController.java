package com.balkan.nautical.systems.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.balkan.nautical.systems.dto.UserDto;
import com.balkan.nautical.systems.web.api.UserApi;





@RestController
public class UserController implements UserApi {

	@Override
	public ResponseEntity<UserDto> create(UserDto toCreate) {
		// TODO Auto-generated method stub
		return null;
	}

}

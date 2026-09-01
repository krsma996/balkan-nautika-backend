package com.balkan.nautical.systems.service.impl;

import org.springframework.stereotype.Service;

import com.balkan.nautical.systems.dao.UserDao;
import com.balkan.nautical.systems.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;





@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
}

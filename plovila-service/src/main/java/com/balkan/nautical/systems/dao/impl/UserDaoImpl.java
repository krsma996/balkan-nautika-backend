package com.balkan.nautical.systems.dao.impl;

import org.springframework.stereotype.Repository;

import com.balkan.nautical.systems.dao.custom.UserDaoCustom;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDaoImpl implements UserDaoCustom {
	 private final EntityManager entityManager;
	 
	 
}

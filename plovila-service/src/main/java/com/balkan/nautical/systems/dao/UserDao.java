package com.balkan.nautical.systems.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.balkan.nautical.systems.dao.custom.UserDaoCustom;
import com.balkan.nautical.systems.model.UserAccount;



/*
 * 
 * @author Nikola Krsmanovic
 *  Basic sql queries
 */


public interface UserDao  extends JpaRepository<UserAccount, Long>,UserDaoCustom{

}

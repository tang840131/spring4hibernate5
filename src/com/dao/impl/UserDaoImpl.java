package com.dao.impl;

import org.springframework.stereotype.Repository;

import com.dao.UserDao;
import com.entity.User;
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, Integer>implements UserDao {

}

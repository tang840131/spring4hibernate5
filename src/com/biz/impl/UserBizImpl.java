package com.biz.impl;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import com.bean.Page;
import com.biz.UserBiz;
import com.dao.UserDao;
import com.entity.User;
@Service
public class UserBizImpl extends BaseBizImpl<User, Integer>implements UserBiz {
	@Resource(type=UserDao.class)
	private UserDao userDao;
	@Resource(type=UserDao.class)
	public void setBaseDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}

	/**
	 * {@inheritDoc}
	 */
	public Page<User> getUserPage(Integer pageSize,Integer nowPage){
		DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
		Page<User> page = new Page<User>();
		page.setOrderBy("id");
		page.setPageSize(pageSize);
		page.setNowPage(nowPage);
		return userDao.getPage(criteria, page);
	} 
}

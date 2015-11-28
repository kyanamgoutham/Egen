package com.egen.test.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.pojo.User_Table;
import com.egen.test.userservice.dao.IUserDAO;

@Component("userService")
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDao;

	@Override
	@Transactional
	public IBackendResponse save(User_Table user) {
		return userDao.save(user);
	}

	@Override
	@Transactional
	public IBackendResponse getUserList() {
		return userDao.getUserList();
	}

	@Override
	@Transactional
	public void delete(User_Table user) {
		userDao.delete(user);
	}

	@Override
	@Transactional
	public IBackendResponse findById(String id) {		
		return userDao.findById(Integer.valueOf(id));
	}
	
}

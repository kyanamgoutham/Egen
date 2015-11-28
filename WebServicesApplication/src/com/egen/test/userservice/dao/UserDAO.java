package com.egen.test.userservice.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.egen.test.framework.backendresponse.BackendResponse;
import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.exception.EgenException;
import com.egen.test.pojo.User_Table;

@Repository("userDao")
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public IBackendResponse getUserList() {
		BackendResponse backendResponse = new BackendResponse();
		try {
			backendResponse
					.setBackendResponse(sessionFactory.getCurrentSession().createQuery("from User_Table").list());
		} catch (Exception e) {
			EgenException egenException = new EgenException();
			egenException.setEgenException(e, "Backend Error", "EGEN_DAO_ERR_1");
			backendResponse.setBackendResponse(egenException);
		}
		return backendResponse;
	}

	@Override
	public IBackendResponse findById(int id) {
		BackendResponse backendResponse = new BackendResponse();
		try {
			backendResponse.setBackendResponse(
					sessionFactory.getCurrentSession().createQuery("from User_Table where id =" + id).list());
		} catch (Exception e) {
			EgenException egenException = new EgenException();
			egenException.setEgenException(e, "Backend Error", "EGEN_DAO_ERR_1");
			backendResponse.setBackendResponse(egenException);
		}
		return backendResponse;
	}

	@Override
	public IBackendResponse save(User_Table user) {
		BackendResponse backendResponse = new BackendResponse();
		try {
			sessionFactory.getCurrentSession().save(user);
			if (Integer.valueOf(user.getId()) == 0) {
				backendResponse.setBackendResponse(false);
			} else {
				backendResponse.setBackendResponse(user);
			}

		} catch (Exception e) {
			EgenException egenException = new EgenException();
			egenException.setEgenException(e, "Backend Error", "EGEN_DAO_ERR_1");
			backendResponse.setBackendResponse(egenException);
		}
		return backendResponse;
	}

	@Override
	public void delete(User_Table user) {
		// TODO Auto-generated method stub

	}

}

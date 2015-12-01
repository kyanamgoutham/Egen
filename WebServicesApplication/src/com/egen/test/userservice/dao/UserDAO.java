package com.egen.test.userservice.dao;

import org.hibernate.Query;
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
	@Transactional
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
	@Transactional
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
	@Transactional
	public IBackendResponse delete(User_Table user) {
		BackendResponse backendResponse = new BackendResponse();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("delete from User_Table where id=:id");
			query.setParameter("id", user.getId());
			if(query.executeUpdate() == 1){
				backendResponse.setBackendResponse("User Deleted");
			}else{
				throw new Exception("SQLException");
			}

		} catch (Exception e) {
			EgenException egenException = new EgenException();
			egenException.setEgenException(e, "Backend Error", "EGEN_DAO_ERR_1");
			backendResponse.setBackendResponse(egenException);
		}
		return backendResponse;

	}

	@Override
	public IBackendResponse insertByID(User_Table retrievedUser) {
		BackendResponse backendResponse = new BackendResponse();
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"update User_Table set fName = :fName,lName = :lName, mName =:mName, age = :age, gender =:gender,phone =:phone, zip =:zip  where id =:id");
			query.setParameter("id", retrievedUser.getId());
			query.setParameter("fName", retrievedUser.getfName());
			query.setParameter("lName", retrievedUser.getlName());
			query.setParameter("mName", retrievedUser.getmName());
			query.setParameter("age", retrievedUser.getAge());
			query.setParameter("phone", retrievedUser.getPhone());
			query.setParameter("gender", retrievedUser.getGender());
			query.setParameter("zip", retrievedUser.getZip());
			if(query.executeUpdate() == 1){
				backendResponse.setBackendResponse(retrievedUser);
			}else{
				throw new Exception("SQLException");
			}			
		} catch (Exception e) {
			EgenException egenException = new EgenException();
			egenException.setEgenException(e, "Backend Error", "EGEN_DAO_ERR_1");
			backendResponse.setBackendResponse(egenException);
		}
		return backendResponse;
	}

}

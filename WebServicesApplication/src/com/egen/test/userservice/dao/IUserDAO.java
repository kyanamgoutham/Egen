package com.egen.test.userservice.dao;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.dao.IDAO;
import com.egen.test.pojo.User_Table;

public interface IUserDAO extends IDAO {
	public IBackendResponse getUserList();

	public IBackendResponse findById(int id);

	public IBackendResponse save(User_Table user);

	public void delete(User_Table user);

}

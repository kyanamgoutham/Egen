package com.egen.test.userservice.service;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.service.IService;
import com.egen.test.pojo.User_Table;

public interface IUserService extends IService{
	public IBackendResponse save(User_Table user);
    public IBackendResponse getUserList();
    public void delete(User_Table user);
    public IBackendResponse findById(String id);
	public IBackendResponse insertByID(User_Table retrievedUser);
}

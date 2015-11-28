package com.egen.test.framework.facade;

import com.egen.test.framework.backendresponse.IBackendResponse;
import com.egen.test.framework.request.IRequest;
import com.egen.test.framework.response.IResponse;
import com.egen.test.framework.service.IService;

public interface IResourceFacade {
	public IResponse initiateService(IRequest request,IResponse response);
	public IBackendResponse processRequest(IRequest request,IService service);
	public IResourceFacade initiate();

}

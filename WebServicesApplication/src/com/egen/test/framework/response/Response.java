package com.egen.test.framework.response;

import com.egen.test.framework.commondata.CommonData;

public class Response implements IResponse {
	private CommonData commonData;

	public CommonData getCommonData() {
		return commonData;
	}

	public void setCommonData(CommonData commonData) {
		this.commonData = commonData;
	}
}

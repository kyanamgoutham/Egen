package com.egen.test.framework.commondata;

import java.sql.Timestamp;

public class CommonData implements ICommonData {

	public String client;
	public String version;
	public Timestamp timeStamp;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Timestamp getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}

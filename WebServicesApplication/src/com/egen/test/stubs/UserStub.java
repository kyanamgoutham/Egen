package com.egen.test.stubs;

import com.egen.test.pojo.User_Table;

public class UserStub {
	
	public static User_Table getUserStub(){
		User_Table user = new User_Table();
		user.setZip(39831);
		user.setGender("M");
		user.setPhone("2456987456");
		user.setmName("Francis");
		user.setAge(10);
		user.setfName("Joseph");
		user.setlName("Herald");
		return user;
	}

}
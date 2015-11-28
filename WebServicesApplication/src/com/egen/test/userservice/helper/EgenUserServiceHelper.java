package com.egen.test.userservice.helper;

import org.apache.commons.lang.StringUtils;

import com.egen.test.pojo.User_Table;

public class EgenUserServiceHelper {

	public static String buildQuery(User_Table user){
		StringBuffer sb = new StringBuffer("from User_Table where");
		if(StringUtils.isNotBlank(user.getId())){
			sb.append("id:");
		}
		
		return null;
	}

}

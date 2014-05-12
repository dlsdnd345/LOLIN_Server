package com.iris.vo;

import java.util.HashMap;
import java.util.Map;

import com.iris.entities.User;

public class UserVO {

	private static final String ID = "id";
	private static final String FACEBOOK_ID = "facebookId";
	private static final String WRITE_TIME = "writeTime";
	
	public Map<String, Object> vo(User user){
		
		Map<String,Object> vo = new HashMap<>();
		
		vo.put(ID, String.valueOf(user.getId()));
		vo.put(FACEBOOK_ID, user.getFacebookId());
		vo.put(WRITE_TIME, user.getWriteTime());
		
		return vo;
	}
	
	
	
}

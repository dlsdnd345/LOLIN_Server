package com.iris.vo;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.iris.entities.User;

public class UserVO {

	private static final String ID = "id";
	private static final String FACEBOOK_ID = "facebookId";
	private static final String WRITE_TIME = "writeTime";
	private static final String SUMMONER_NAME = "summonerName";
	
	public Map<String, Object> vo(User user){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String,Object> vo = new HashMap<>();
		
		vo.put(ID, String.valueOf(user.getId()));
		vo.put(FACEBOOK_ID, user.getFacebookId());
		vo.put(WRITE_TIME, format.format(user.getWriteTime()));
		vo.put(SUMMONER_NAME, user.getSummonerName());
		
		return vo;
	}
	
	
	
}

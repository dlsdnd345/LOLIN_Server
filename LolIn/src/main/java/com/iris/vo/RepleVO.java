package com.iris.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iris.entities.Reple;

public class RepleVO {

	private static final String FACEBOOK_ID 				= "facebookId";
	private static final String REPLE_ID 					= "id";
	private static final String REPLE_CONTENT 			= "repleContent";
	private static final String USER_NAME 				= "userName";
	private static final String WRITE_TIME 				= "writeTime";
	private static final String OS						= "os";
	
public List<Map<String,Object>> vo(List<Reple> repleList){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		List<Map<String,Object>> repleListResult = new ArrayList<Map<String,Object>>();
		
		for (Reple reple : repleList) {
			Map<String,Object> vo = new HashMap<>();
			vo.put(REPLE_ID, reple.getId());
			vo.put(FACEBOOK_ID, reple.getFacebookId());
			vo.put(REPLE_CONTENT, reple.getContent());
			vo.put(USER_NAME, reple.getUserName());
			vo.put(OS, reple.getOs());
			vo.put(WRITE_TIME, format.format(reple.getWriteTime()));
			repleListResult.add(vo);
		}
		return repleListResult;
	}
	
}

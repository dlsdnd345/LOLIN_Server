package com.iris.vo;

import java.util.ArrayList;
import java.util.List;

import com.iris.entities.Reple;

public class RepleVO {

public List<Reple> vo(List<Reple> repleList){
		
		List<Reple> repleListResult = new ArrayList<Reple>();
		
		for (Reple reple : repleList) {
			Reple repleResult = new Reple();
			repleResult.setContent(reple.getContent());
			repleResult.setUserName(reple.getUserName());
			repleResult.setWriteTime(reple.getWriteTime());
			repleListResult.add(repleResult);
		}
		
		return repleListResult;
	}
	
}

package com.iris.service;

import java.util.Map;

import com.iris.entities.User;

public interface UserService {

	public Map<String, Object> findOne(String faceBookId,String hash);
	public String save(String faceBookId, String summonerName,String pushId,String hash);
}

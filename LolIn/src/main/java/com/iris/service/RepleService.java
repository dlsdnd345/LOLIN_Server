package com.iris.service;

import java.util.List;
import java.util.Map;

public interface RepleService {
	public List<Map<String,Object>> findAll();
	public List<Map<String,Object>> findById(int id , String hash);
	public String save(int boardId , String userName , String content , String facebookId,String os ,String hash);
	public String delete(int repleId , String hash);
}

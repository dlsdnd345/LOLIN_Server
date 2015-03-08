package com.iris.service;

import java.util.Map;

public interface BoardService {

	public String delete(int boardId,String hash);
	public Map<String, Object> findOne(int boardId,String hash);
	public Map<String,Object> findMyAll(String faceBookId,String hash);
	public Map<String,Object> findAll(String rank, String position,String playTime, String hash, int page, int pageSize);
	public String save(String boardId ,String faceBookId ,String title,String content,String position,String rank,String playTime,String tea,String os,String hash);

}

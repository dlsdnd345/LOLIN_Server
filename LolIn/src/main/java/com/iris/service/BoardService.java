package com.iris.service;

import java.util.List;
import java.util.Map;

import com.iris.entities.Board;
import com.iris.vo.BoardAndRepleVO;

public interface BoardService {

	public String delete(int boardId,String hash);
	public Map<String, Object> findOne(int boardId,String hash);
	public List<Map<String,Object>> findMyAll(String faceBookId,String hash);
	public List<Map<String,Object>> findAll(String rank,String position,String playTime,String hash);
	public String save(String boardId ,String faceBookId ,String title,String content,String position,String rank,String playTime,String tea,String hash);
}

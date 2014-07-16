package com.iris.service;

import java.util.List;
import java.util.Map;

import com.iris.entities.Board;
import com.iris.vo.BoardAndRepleVO;

public interface BoardService {

	public String delete(int id);
	public Map<String, Object> findOne(int id);
	public List<Map<String,Object>> findMyAll(String faceBookId);
	public List<Map<String,Object>> findAll(String rank,String position,String playTime);
	public String save(int id ,String faceBookId ,String title,String content,String position,String rank,String playTime,String tea);
}

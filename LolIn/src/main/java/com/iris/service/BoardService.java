package com.iris.service;

import java.util.List;
import java.util.Map;

import com.iris.entities.Board;
import com.iris.vo.BoardAndRepleVO;

public interface BoardService {

	public List<Map<String,Object>> findAll(String rank,String position,String playTime);
	public List<Map<String,Object>> findMyAll(String faceBookId);
	public Map<String, Object> findOne(int id);
}

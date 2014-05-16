package com.iris.service;

import java.util.List;
import java.util.Map;

import com.iris.entities.Board;
import com.iris.vo.BoardAndRepleVO;

public interface BoardService {

	public List<Map<String,Object>> findAll();
	public Map<String, Object> findOne(int id);
}

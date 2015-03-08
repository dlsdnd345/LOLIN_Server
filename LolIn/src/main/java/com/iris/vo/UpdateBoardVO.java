package com.iris.vo;

import java.util.HashMap;
import java.util.Map;

import com.iris.entities.UpdateBoard;

public class UpdateBoardVO {

	private static final String ID = "id";
	private static final String MESSAGE = "message";
	private static final String URL = "url";
	private static final String VERSION = "version";
	private static final String OPEN = "open";

	public Map<String, Object> vo(UpdateBoard updateBoard){

		Map<String,Object> vo = new HashMap<>();

		vo.put(ID, String.valueOf(updateBoard.getId()));
		vo.put(MESSAGE, updateBoard.getMessage());
		vo.put(URL, updateBoard.getUrl());
		vo.put(VERSION, updateBoard.getVersion());
		vo.put(OPEN, updateBoard.getOpen());

		return vo;
	}


}

package com.iris.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iris.entities.Board;

public class BoardVO {

	private static final String BOARD_ID = "id";
	private static final String TITLE = "title";
	private static final String CONTENT = "content";
	private static final String PLAY_TIME = "playTime";
	private static final String POSITION = "position";
	private static final String RANK = "rank";
	private static final String WRITE_TIME = "writeTime";
	private static final String SUMMONER_NAME = "summonerName";

	public List<Map<String,Object>> vo(List<Board> boardList){

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Map<String,Object>> boardListResult = new ArrayList<Map<String,Object>>();

		for (Board board : boardList) {
			
			Map<String,Object> vo = new HashMap<>();
			
			vo.put(BOARD_ID, board.getId());
			vo.put(TITLE, board.getTitle());
			vo.put(CONTENT, board.getContent());
			vo.put(PLAY_TIME, board.getPlayTime());
			vo.put(POSITION, board.getPosition());
			vo.put(RANK, board.getRank());
			vo.put(WRITE_TIME, format.format(board.getWriteTime()));
			vo.put(SUMMONER_NAME, board.getSummonerName());
			boardListResult.add(vo);
		}
		return boardListResult;
	}



}

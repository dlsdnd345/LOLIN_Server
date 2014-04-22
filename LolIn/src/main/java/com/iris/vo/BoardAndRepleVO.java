package com.iris.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iris.entities.Board;
import com.iris.entities.Reple;

public class BoardAndRepleVO {
	
	private static final String BOARD_ID = "boardId";
	private static final String TITLE = "title";
	private static final String BOARD_CONTENT = "boardContent";
	private static final String SUMMONER_NAME = "summonerName";
	private static final String POSITION = "position";
	private static final String RANK = "rank";
	private static final String BOARD_WRITE_TIME = "boardWriteTime";
	private static final String BOARD_PLAY_TIME = "boardPlayTime";
	private static final String REPLE_LIST = "repleList";
	private static final String REPLE_ID = "repleId";
	private static final String USER_NAME = "userName";
	private static final String REPLE_CONTENT = "repleContent";
	private static final String WRITE_TIME = "writeTime";
	
	public Map<String,Object> vo (Board board){
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Map<String,Object> vo = new HashMap<>();
		
		vo.put(BOARD_ID, String.valueOf(board.getId()));
		vo.put(RANK, board.getRank());
		vo.put(TITLE, board.getTitle());
		vo.put(BOARD_CONTENT, board.getContent());
		vo.put(POSITION, board.getPosition());
		vo.put(SUMMONER_NAME, board.getSummonerName());
		vo.put(BOARD_PLAY_TIME, format.format(board.getPlayTime()));
		vo.put(BOARD_WRITE_TIME, format.format(board.getWriteTime()));

		Map<String,Object> repleMap = new HashMap<>();
		
		List<Reple> repleList =  board.getAddReple();
		List<Map<String,Object>> repleListResult = new ArrayList<Map<String,Object>>();
		
		for (Reple reple : repleList) {
			
			repleMap.put(REPLE_ID, reple.getId());
			repleMap.put(USER_NAME, reple.getContent());
			repleMap.put(REPLE_CONTENT, reple.getUserName());
			repleMap.put(WRITE_TIME, format.format(reple.getWriteTime()));
			repleListResult.add(repleMap);
		}
		vo.put(REPLE_LIST, repleListResult);
		
		return vo;
	}
	
}

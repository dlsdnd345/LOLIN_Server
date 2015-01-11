package com.iris.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.iris.entities.Board;

public class BoardVO {

	private static final String BOARD_ID 				= "id";
	private static final String USER_ID 				= "userId";
	private static final String TITLE 				= "title";
	private static final String CONTENT 				= "content";
	private static final String PLAY_TIME 			= "playTime";
	private static final String POSITION 				= "position";
	private static final String RANK 					= "rank";
	private static final String WRITE_TIME 			= "writeTime";
	private static final String SUMMONER_NAME 		= "summonerName";
	private static final String REPLE_COUNT	 		= "repleCount";
	private static final String PAGE_TOTAL_COUNT	 	= "pageTotalCount";
	private static final String BOARD_LIST	 		= "boardList";
	private static final String OS					= "os";
	
	public Map<String,Object> vo(List<Board> boardList , int pageCount){

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Map<String,Object> result = new HashMap<String,Object>();
		List<Map<String,Object>> boardListResult = new ArrayList<Map<String,Object>>();

		for (Board board : boardList) {
			
			Map<String,Object> vo = new HashMap<>();
			
			vo.put(BOARD_ID, board.getId());
			vo.put(USER_ID, board.getAddUsers().getId());
			vo.put(TITLE, board.getTitle());
			vo.put(CONTENT, board.getContent());
			vo.put(PLAY_TIME, board.getPlayTime());
			vo.put(POSITION, board.getPosition());
			vo.put(RANK, board.getRank());
			vo.put(WRITE_TIME, format.format(board.getWriteTime()));
			vo.put(SUMMONER_NAME, board.getAddUsers().getSummonerName());
			vo.put(REPLE_COUNT, board.getAddReple().size());
			vo.put(PAGE_TOTAL_COUNT, board.getAddReple().size());
			vo.put(OS, board.getOs());
			boardListResult.add(vo);
		}
		
		result.put(BOARD_LIST,boardListResult);
		result.put(PAGE_TOTAL_COUNT, pageCount);
		
		return result;
	}



}

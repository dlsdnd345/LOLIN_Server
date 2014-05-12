package com.iris.vo;

import java.util.ArrayList;
import java.util.List;

import com.iris.entities.Board;

public class BoardVO {

	public List<Board> vo(List<Board> boardList){
		
		List<Board> boardListResult = new ArrayList<Board>();
		
		for (Board board : boardList) {
			Board boardResult = new Board();
			boardResult.setTitle(board.getTitle());
			boardResult.setContent(board.getContent());
			boardResult.setPlayTime(board.getPlayTime());
			boardResult.setPosition(board.getPosition());
			boardResult.setRank(board.getRank());
			boardResult.setWriteTime(board.getWriteTime());
			boardResult.setSummonerName(board.getSummonerName());
			boardListResult.add(boardResult);
		}
		return boardListResult;
	}
	
	
	
}

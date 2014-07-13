package com.iris.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.BoardDao;
import com.iris.dao.UserDao;
import com.iris.entities.Board;
import com.iris.entities.User;
import com.iris.utils.BoardQueryDsl;
import com.iris.vo.BoardAndRepleVO;
import com.iris.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	private static final String SAVE = "저장이 완료 되었습니다.";
	
	@Autowired
	BoardDao boardDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BoardQueryDsl boardQueryDsl;
	
	@Override
	public List<Map<String,Object>> findAll(String rank,String position,String playTime) {
		List<Board> boardList = boardQueryDsl.findAll(rank,position,playTime);
		BoardVO boardVO = new BoardVO();
		return boardVO.vo(boardList);
	}

	@Override
	public Map<String, Object> findOne(int id) {
		
		Board board = boardDao.findOne(id);
		BoardAndRepleVO boardAndRepleVO = new BoardAndRepleVO();
		return boardAndRepleVO.vo(board);
	}

	@Override
	public List<Map<String, Object>> findMyAll(String faceBookId) {
		
		User user = userDao.findByFacebookId(faceBookId);
		List<Board> boardList = boardDao.findByAddUsers(user);
		BoardVO boardVO = new BoardVO();
		return boardVO.vo(boardList);
		
	}

	@Override
	public String save(int id,String faceBookId ,String title, String content, String position,String rank, String playTime , String tea) {
		
		User user = userDao.findByFacebookId(faceBookId);
		Board board = null;
		
		if(id  == -1){
			board = new Board();
		}else{
			board = boardDao.findOne(id);
		}
		
		board.setTitle(title);
		board.setContent(content);
		board.setPosition(position);
		board.setRank(rank);
		board.setPlayTime(playTime);
		board.setWriteTime(new Date());
		board.setAddUsers(user);
		board.setTea(tea);
		
		boardDao.save(board);
		
		return SAVE;
	}
	
	

}

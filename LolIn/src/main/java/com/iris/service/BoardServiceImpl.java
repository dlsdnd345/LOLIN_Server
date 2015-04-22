package com.iris.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.config.Config;
import com.iris.dao.BoardDao;
import com.iris.dao.UserDao;
import com.iris.entities.Board;
import com.iris.entities.User;
import com.iris.libs.TrippleDes;
import com.iris.utils.BoardQueryDsl;
import com.iris.utils.SignatureUtil;
import com.iris.vo.BoardAndRepleVO;
import com.iris.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	private static final String SAVE = "저장이 완료 되었습니다.";
	private static final String DELETE = "삭제가 완료 되었습니다.";
	
	@Autowired
	BoardDao boardDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BoardQueryDsl boardQueryDsl;
	
	TrippleDes trippleDes;
	
	@Override
	public Map<String,Object> findAll(String rank,String position,String playTime,String hash , int page , int pageSize) {
		
		if(!SignatureUtil.compareHash(rank+position+playTime+Config.KEY.SECRET, hash)){
			return null;
		}
		
		int pageTotalCount = boardQueryDsl.findAll(rank,position,playTime).size();
		List<Board> boardList = boardQueryDsl.findAll(rank,position,playTime,page ,pageSize);
		BoardVO boardVO = new BoardVO();
		return boardVO.vo(boardList,pageTotalCount);
	}

	@Override
	public Map<String, Object> findOne(int boardId ,String hash) {
		
		if(!SignatureUtil.compareHash(boardId+Config.KEY.SECRET, hash)){
			return null;
		}
		
		Board board = boardDao.findOne(boardId);
		BoardAndRepleVO boardAndRepleVO = new BoardAndRepleVO();
		return boardAndRepleVO.vo(board);
	}

	@Override
	public Map<String,Object> findMyAll(String facebookId,String hash) {
		
		if(!SignatureUtil.compareHash(facebookId+Config.KEY.SECRET, hash)){
			return null;
		}
		
		try {
			trippleDes = new TrippleDes();
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		User user = userDao.findByFacebookId(facebookId);
		List<Board> boardList = boardDao.findByAddUsersOrderByIdDesc(user);
		BoardVO boardVO = new BoardVO();
		return boardVO.vo(boardList,0);
		
	}

	@Override
	public String save
	(String boardId,String facebookId ,String title, String content, String position,
			String rank, String playTime , String tea,String os, String hash) {
		if(!SignatureUtil.compareHash(boardId+facebookId+title+content+position+rank+playTime+tea+os+Config.KEY.SECRET, hash)){
			return null;
		}
		
		
		try {
			trippleDes = new TrippleDes();
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		User user = userDao.findByFacebookId(facebookId);
		Board board = null;
		
		
		
		if(boardId  == ""){
			board = new Board();
		}else{
			board = boardDao.findOne(Integer.parseInt(boardId));
		}
		
		board.setTitle(title);
		board.setContent(content);
		board.setPosition(position);
		board.setRank(rank);
		board.setPlayTime(playTime);
		board.setWriteTime(new Date());
		board.setAddUsers(user);
		board.setTea(tea);
		board.setOs(os);
		
		if(user != null && user.getId() != 0){
			boardDao.save(board);
		}
		return SAVE;
	}

	@Override
	public String delete(int boardId ,String hash) {
		
		if(!SignatureUtil.compareHash(boardId+Config.KEY.SECRET, hash)){
			return null;
		}
		
		Board board = new Board();
		board.setId(boardId);
		boardDao.delete(board);
		
		return DELETE;
	}
	
	

}

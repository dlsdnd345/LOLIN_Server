package com.iris.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.RepleDao;
import com.iris.entities.Board;
import com.iris.entities.Reple;
import com.iris.utils.RepleQueryDsl;
import com.iris.vo.RepleVO;

@Service
@Transactional
public class RepleServiceImpl implements RepleService {

	private static final String SAVE = "저장이 완료 되었습니다.";
	private static final String DELETE = "삭제가 완료 되었습니다.";
	
	@Autowired
	RepleDao repleDao;
	@Autowired
	RepleQueryDsl repleQueryDsl;
	
	/**
	 * 모든 댓글 조회
	 */
	@Override
	public List<Map<String,Object>> findAll() {
		List<Reple> repleList = repleDao.findAll();
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

	/**
	 * 댓글 저장
	 */
	@Override
	public String save(int boardId , String userName ,String content , String facebookId) {
		
		Reple reple = new Reple();
		Board board = new Board();
		
		board.setId(boardId);
		reple.setAddBoards(board);
		reple.setContent(content);
		reple.setUserName(userName);
		reple.setFacebookId(facebookId);
		
		repleDao.save(reple);
		
		return SAVE;
	}

	/**
	 * 게시판의 댓글 조회
	 */
	@Override
	public List<Map<String,Object>> findById(int boardId) {
		
		List<Reple> repleList = repleQueryDsl.findById(boardId);
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public String delete(int repleId) {
		repleDao.delete(repleId);
		return DELETE;
	}

}

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
	
	@Autowired
	RepleDao repleDao;
	@Autowired
	RepleQueryDsl repleQueryDsl;
	
	@Override
	public List<Map<String,Object>> findAll() {
		List<Reple> repleList = repleDao.findAll();
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

	@Override
	public String save(int boardId , String userName ,String content) {
		
		Reple reple = new Reple();
		Board board = new Board();
		board.setId(boardId);
		reple.setAddBoards(board);
		reple.setContent(content);
		reple.setUserName(userName);
		
		repleDao.save(reple);
		
		return SAVE;
	}

	@Override
	public List<Map<String,Object>> findById(int boardId) {
		
		List<Reple> repleList = repleQueryDsl.findById(boardId);
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

}

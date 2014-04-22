package com.iris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.BoardDao;
import com.iris.entities.Board;
import com.iris.vo.BoardVO;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<Board> findAll() {
		List<Board> boardList = boardDao.findAll();
		BoardVO boardVO = new BoardVO();
		return boardVO.vo(boardList);
	}

}

package com.iris.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.config.Config;
import com.iris.dao.RepleDao;
import com.iris.entities.Board;
import com.iris.entities.Reple;
import com.iris.libs.TrippleDes;
import com.iris.utils.RepleQueryDsl;
import com.iris.utils.SignatureUtil;
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
	
	TrippleDes trippleDes;
	
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
	public String save(int boardId , String userName ,String content , String facebookId ,String hash) {
		
		if(!SignatureUtil.compareHash(boardId+ userName + content + facebookId + Config.KEY.SECRET, hash)){
			return null;
		}
		
		Reple reple = new Reple();
		Board board = new Board();
		
		try {
			trippleDes = new TrippleDes();
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
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
	public List<Map<String,Object>> findById(int boardId , String hash) {
		
		if(!SignatureUtil.compareHash(boardId + Config.KEY.SECRET, hash)){
			return null;
		}
		
		List<Reple> repleList = repleQueryDsl.findById(boardId);
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

	/**
	 * 댓글 삭제
	 */
	@Override
	public String delete(int repleId , String hash) {
		
		if(!SignatureUtil.compareHash(repleId + Config.KEY.SECRET, hash)){
			return null;
		}
		
		repleDao.delete(repleId);
		return DELETE;
	}

}

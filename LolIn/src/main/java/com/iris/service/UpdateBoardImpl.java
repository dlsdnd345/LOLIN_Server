package com.iris.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.config.Config;
import com.iris.dao.UpdateBoardDao;
import com.iris.dao.UserDao;
import com.iris.entities.UpdateBoard;
import com.iris.libs.TrippleDes;
import com.iris.utils.SignatureUtil;
import com.iris.vo.UpdateBoardVO;

@Service
@Transactional
public class UpdateBoardImpl implements UpdateBoardService {

	@Autowired
	UpdateBoardDao updateBoardDao;
	
	TrippleDes trippleDes;
	
	@Override
	public Map<String, Object> findByVersion(String version , String hash) {
		
		if(!SignatureUtil.compareHash(version+Config.KEY.SECRET, hash)){
			return null;
		}
		
		UpdateBoard updateBoard = updateBoardDao.findByVersion(version);
		UpdateBoardVO updateBoardVO = new UpdateBoardVO();
		return updateBoardVO.vo(updateBoard);
	}

}

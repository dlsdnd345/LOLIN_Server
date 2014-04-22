package com.iris.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.RepleDao;
import com.iris.entities.Reple;
import com.iris.vo.RepleVO;

@Service
@Transactional
public class RepleServiceImpl implements RepleService {

	@Autowired
	RepleDao repleDao;
	
	@Override
	public List<Reple> findAll() {
		List<Reple> repleList = repleDao.findAll();
		RepleVO repleVO = new RepleVO();
		return repleVO.vo(repleList);
	}

}

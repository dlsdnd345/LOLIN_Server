package com.iris.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.config.Config;
import com.iris.dao.AdminDao;
import com.iris.dao.BoardDao;
import com.iris.dao.UserDao;
import com.iris.entities.Admin;
import com.iris.entities.Board;
import com.iris.entities.User;
import com.iris.libs.TrippleDes;
import com.iris.utils.BoardQueryDsl;
import com.iris.utils.SignatureUtil;
import com.iris.vo.BoardAndRepleVO;
import com.iris.vo.BoardVO;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	AdminDao adminDao;
	
	@Override
	public boolean login(String userId , String password) {
		
		
		List<Admin> adminList = adminDao.findByUserIdAndPassword(userId, password);
		
		if(adminList.size() != 0){
			return true;	
		}else{
			return false;
		}
		
	}	

}

package com.iris.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.dao.UserDao;
import com.iris.entities.User;
import com.iris.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	

	@Override
	public Map<String, Object> findOne(String facebookId) {
		
		User user = userDao.findByFacebookId(facebookId);
		UserVO userVO = new UserVO();
		return userVO.vo(user);
	}


	@Override
	public String save(String facebookId,String summonerName) {
		User user = userDao.findByFacebookId(facebookId);
		if(user == null){
			user = new User();
		}
		
		user.setSummonerName(summonerName);
		user.setFacebookId(facebookId);
		user.setWriteTime(new Date());
		
		userDao.save(user);
		return "저장이 완료되었습니다.";
	}

}

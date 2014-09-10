package com.iris.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iris.config.Config;
import com.iris.dao.UserDao;
import com.iris.entities.User;
import com.iris.libs.TrippleDes;
import com.iris.utils.SignatureUtil;
import com.iris.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	TrippleDes trippleDes;
	

	@Override
	public Map<String, Object> findOne(String facebookId,String hash) {
		
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
		UserVO userVO = new UserVO();
		return userVO.vo(user);
	}


	@Override
	public String save(String facebookId,String summonerName,String pushId,String hash) {
		
		if(!SignatureUtil.compareHash(facebookId+summonerName+pushId+Config.KEY.SECRET, hash)){
			return "";
		}
		
		try {
			trippleDes = new TrippleDes();
			pushId = trippleDes.decrypt(pushId);
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		User user = userDao.findByFacebookId(facebookId);
		if(user == null){
			user = new User();
		}
		
		user.setSummonerName(summonerName);
		user.setFacebookId(facebookId);
		user.setWriteTime(new Date());
		user.setPushId(pushId);
		
		userDao.save(user);
		return "저장이 완료되었습니다.";
	}

}

package com.iris.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.iris.config.Config;
import com.iris.dao.BoardDao;
import com.iris.dao.RepleDao;
import com.iris.dao.UserDao;
import com.iris.entities.Board;
import com.iris.entities.Reple;
import com.iris.entities.User;
import com.iris.libs.TrippleDes;
import com.iris.utils.SignatureUtil;

@Service
@Transactional
public class GcmServiceImpl implements GcmService {

	private static final String API_KEY = "AIzaSyCJoQvjxlp_LQ3H0M5WtF96V4g2LkGm6dQ"; 
	private static final String PUSH_SUCESS_MESSAGE = "푸시 전송에 성공 하였습니다.";


	@Autowired
	BoardDao boardDao;
	@Autowired
	RepleDao repleDao;
	@Autowired
	UserDao userDao;
	
	TrippleDes trippleDes;

	@Override
	public String sendPush(String boardId, String summernerName,String facebookId, String reple, String hash) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		if(!SignatureUtil.compareHash(boardId + summernerName + facebookId + reple + Config.KEY.SECRET, hash)){
			return null;
		}

		try {
			trippleDes = new TrippleDes();
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Board board = boardDao.findOne(Integer.parseInt(boardId));
		List<Reple> repleList = board.getAddReple();


		if(board.getOs().equals("android")){ // Android

			Sender sender = new Sender(API_KEY);				//푸시 보내는 객체 생성
			Message.Builder builder = new Message.Builder();	//푸시 메시지 만드는 객체
			builder.collapseKey(String.valueOf(Math.random() % 100 + 1));
			builder.addData("message", reple);
			builder.addData("summernerName", summernerName);
			builder.addData("boardId", boardId);
			builder.addData("writeTime", format.format(repleList.get(repleList.size()-1).getWriteTime()));
			builder.addData("repleId", String.valueOf(repleList.get(repleList.size()-1).getId()));
			builder.addData("facebookId", facebookId);
			builder.delayWhileIdle(true);
			builder.timeToLive(3);
			Message msg = builder.build();

			Result result = null;
			try {
				result = sender.send(msg, board.getAddUsers().getPushId(), 5);			//푸시 전송

				if (result.getMessageId() != null) {
					System.out.println("Send success");
				} else {
					String error = result.getErrorCodeName();
					System.out.println("Send fail : " + error);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

		}else{// IOS

		}

		return PUSH_SUCESS_MESSAGE;
	}


	@Override
	public String notMeAllSendPush(String boardId, String summernerName,String facebookId, String reple, String hash) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		if(!SignatureUtil.compareHash(boardId + summernerName + facebookId + reple + Config.KEY.SECRET, hash)){
			return null;
		}

		try {
			trippleDes = new TrippleDes();
			facebookId = trippleDes.decrypt(facebookId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		Board board = boardDao.findOne(Integer.parseInt(boardId));
		List<Reple> repleList = board.getAddReple();
		List<Reple> meNotRepleList = new ArrayList<Reple>();
		List<String> rejectFacebookIdList = new ArrayList<String>();

		for(int i=0; i<repleList.size(); i++){
			if(!repleList.get(i).getFacebookId().equals(facebookId)){
				meNotRepleList.add(repleList.get(i));				
			}
		}

		for(int j=0; j<meNotRepleList.size(); j++){

			if (!rejectFacebookIdList.contains(meNotRepleList.get(j).getFacebookId())) {
				rejectFacebookIdList.add(meNotRepleList.get(j).getFacebookId());

				if(meNotRepleList.get(j).getOs().equals("android")){ // Android

					Sender sender = new Sender(API_KEY);				//푸시 보내는 객체 생성
					Message.Builder builder = new Message.Builder();	//푸시 메시지 만드는 객체
					builder.collapseKey(String.valueOf(Math.random() % 100 + 1));
					builder.addData("message", reple);
					builder.addData("summernerName", summernerName);
					builder.addData("boardId", boardId);
					builder.addData("writeTime", format.format(repleList.get(repleList.size()-1).getWriteTime()));
					builder.addData("repleId", String.valueOf(repleList.get(repleList.size()-1).getId()));
					builder.addData("facebookId",facebookId);
					
					builder.delayWhileIdle(true);
					builder.timeToLive(3);
					
					Message msg = builder.build();

					User user = userDao.findByFacebookId(meNotRepleList.get(j).getFacebookId());
					
					Result result = null;
					try {
						result = sender.send(msg, user.getPushId(), 5);			//푸시 전송

						if (result.getMessageId() != null) {
							System.out.println("Send success");
						} else {
							String error = result.getErrorCodeName();
							System.out.println("Send fail : " + error);
						}

					} catch (IOException e) {
						e.printStackTrace();
					}

				}else{// IOS

				}
			}

		}
		return PUSH_SUCESS_MESSAGE;
	}


	@Override
	public String sendAllPush(String message) {
		
		
		List<User> userList = userDao.findAll();

		for (int i = 0; i < userList.size(); i++) {
			
			Sender sender = new Sender(API_KEY);				//푸시 보내는 객체 생성
			Message.Builder builder = new Message.Builder();	//푸시 메시지 만드는 객체
			builder.collapseKey(String.valueOf(Math.random() % 100 + 1));
			builder.addData("message", message);
			builder.delayWhileIdle(true);
			builder.timeToLive(3);
			Message msg = builder.build();

			Result result = null;
			try {
				result = sender.send(msg,  userList.get(i).getPushId(), 5);			//푸시 전송

				if (result.getMessageId() != null) {
					System.out.println("Send success");
				} else {
					String error = result.getErrorCodeName();
					System.out.println("Send fail : " + error);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		return PUSH_SUCESS_MESSAGE;
	}

}

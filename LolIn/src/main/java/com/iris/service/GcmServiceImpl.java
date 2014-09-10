package com.iris.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.iris.config.Config;
import com.iris.dao.BoardDao;
import com.iris.dao.RepleDao;
import com.iris.entities.Board;
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

	@Override
	public String sendPush(String os, String boardId, String summernerName,String facebookId, String reple, String hash) {

		if(!SignatureUtil.compareHash(os+ boardId + summernerName + facebookId + reple + Config.KEY.SECRET, hash)){
			return null;
		}

		Board board = boardDao.findOne(Integer.parseInt(boardId));

		if(os.equals("android")){ // Android

			Sender sender = new Sender(API_KEY);				//푸시 보내는 객체 생성
			Message.Builder builder = new Message.Builder();	//푸시 메시지 만드는 객체
			builder.collapseKey(String.valueOf(Math.random() % 100 + 1));
			builder.addData("message", reple);
			builder.addData("summernerName", summernerName);
			builder.addData("boardId", boardId);
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

}

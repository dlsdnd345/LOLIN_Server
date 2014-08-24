package com.iris.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.iris.dao.BoardDao;
import com.iris.dao.RepleDao;
import com.iris.entities.Board;

@Controller
public class GCMController {

	private static final String API_KEY = "AIzaSyCJoQvjxlp_LQ3H0M5WtF96V4g2LkGm6dQ"; 
	private static final String PUSH_SUCESS_MESSAGE = "푸시 전송에 성공 하였습니다.";
	
	@Autowired
	BoardDao boardDao;
	@Autowired
	RepleDao repleDao;
	
    @RequestMapping(value = "/gcm/sendReple", method = RequestMethod.GET)
    @ResponseBody
    public Object sendPush(@RequestParam(value = "os") String os,
    						@RequestParam(value = "boardId") String boardId,
    						@RequestParam(value = "summernerName") String summernerName,
    						@RequestParam(value = "facebookId") String facebookId,
    						@RequestParam(value = "reple") String message) throws ParseException {
    	
    	Board board = boardDao.findOne(Integer.parseInt(boardId));
    	
    	if(os.equals("android")){ // Android
    		
        	Sender sender = new Sender(API_KEY);				//푸시 보내는 객체 생성
    		Message.Builder builder = new Message.Builder();	//푸시 메시지 만드는 객체
    		builder.collapseKey(String.valueOf(Math.random() % 100 + 1));
    		builder.addData("message", message);
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

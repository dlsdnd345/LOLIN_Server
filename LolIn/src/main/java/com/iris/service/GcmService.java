package com.iris.service;

public interface GcmService {
	public String sendPush(String boardId,String summernerName,String facebookId,String reple,String hash);
	public String notMeAllSendPush(String boardId,String summernerName,String facebookId,String reple,String hash);
	public String sendAllPush(String message);
	
}

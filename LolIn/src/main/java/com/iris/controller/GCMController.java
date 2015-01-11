package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.service.GcmService;

@Controller
public class GCMController {

	@Autowired
	GcmService gcmService;
	
    @RequestMapping(value = "/gcm/sendReple", method = RequestMethod.GET)
    @ResponseBody
    public Object sendPush(@RequestParam(value = "boardId") String boardId,
    						@RequestParam(value = "summernerName") String summernerName,
    						@RequestParam(value = "facebookId") String facebookId,
    						@RequestParam(value = "reple") String reple,
    						@RequestParam(value = "hash") String hash) throws ParseException {
    	
    	return gcmService.sendPush(boardId, summernerName, facebookId, reple, hash);
    }
    
    @RequestMapping(value = "/gcm/sendMeReple", method = RequestMethod.GET)
    @ResponseBody
    public Object sendMePush(@RequestParam(value = "boardId") String boardId,
    						@RequestParam(value = "summernerName") String summernerName,
    						@RequestParam(value = "facebookId") String facebookId,
    						@RequestParam(value = "reple") String reple,
    						@RequestParam(value = "hash") String hash) throws ParseException {
    	
    	return gcmService.notMeAllSendPush(boardId, summernerName, facebookId, reple, hash);
    }
    
}

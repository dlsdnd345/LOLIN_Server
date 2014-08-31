package com.iris.controller;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.dao.BoardDao;
import com.iris.entities.User;
import com.iris.service.BoardService;
import com.iris.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/findOne", method = RequestMethod.GET)
    @ResponseBody
    public Object findOne(@RequestParam(value = "faceBookId") String facebookId) throws ParseException {
        return userService.findOne(facebookId);
    }
    
    @RequestMapping(value = "/user/save", method = RequestMethod.GET)
    @ResponseBody
    public Object save(@RequestParam(value = "faceBookId") String faceBookId ,
    					@RequestParam(value = "summonerName") String summonerName,
    					@RequestParam(value = "pushId") String pushId) throws ParseException {
    	
        return userService.save(faceBookId,summonerName,pushId);
    }
    
    @RequestMapping(value = "/user/saveDefault", method = RequestMethod.GET)
    @ResponseBody
    public Object save(@RequestParam(value = "faceBookId") String faceBookId ,
    					@RequestParam(value = "summonerName") String summonerName) throws ParseException {
    	
        return userService.save(faceBookId,summonerName);
    }

}

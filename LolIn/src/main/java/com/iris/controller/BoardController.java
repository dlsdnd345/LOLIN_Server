package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.dao.BoardDao;
import com.iris.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/findAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findAll(@RequestParam(value = "rank",defaultValue="") String rank,
    						@RequestParam(value = "position",defaultValue="") String position,
    						@RequestParam(value = "playTime",defaultValue="") String playTime,
    						@RequestParam(value = "hash") String hash) throws ParseException {
    	
        return boardService.findAll(rank,position,playTime,hash);
    }
    
    @RequestMapping(value = "/board/findMyAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findMyAll(@RequestParam(value = "faceBookId") String faceBookId,
    						  @RequestParam(value = "hash") String hash) throws ParseException {
        return boardService.findMyAll(faceBookId,hash);
    }
    
    @RequestMapping(value = "/board/findOne", method = RequestMethod.GET)
    @ResponseBody
    public Object findOne(@RequestParam(value = "boardId") int boardId,
    						@RequestParam(value = "hash") String hash) throws ParseException {
        return boardService.findOne(boardId,hash);
    }

}

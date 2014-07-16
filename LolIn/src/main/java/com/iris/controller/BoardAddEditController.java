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
public class BoardAddEditController {

    @Autowired
    BoardService boardService;
    
    @RequestMapping(value = "/board/save", method = RequestMethod.GET)
    @ResponseBody
    public Object findOne(@RequestParam(value = "id") int id,
    						@RequestParam(value = "facebookId") String faceBookId,
    						@RequestParam(value = "title") String title,
    						@RequestParam(value = "content") String content,
    						@RequestParam(value = "position") String position,
    						@RequestParam(value = "rank") String rank,
    						@RequestParam(value = "playTime") String playTime,
    						@RequestParam(value = "tea") String tea) throws ParseException {
    	
    	return boardService.save(id,faceBookId,title, content, position, rank, playTime,tea);
    }

    @RequestMapping(value = "/board/delete", method = RequestMethod.GET)
    @ResponseBody
    public Object delete(@RequestParam(value = "id") int id) throws ParseException {
        return boardService.delete(id);
    }
    
}

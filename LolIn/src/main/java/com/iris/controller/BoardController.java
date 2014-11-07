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

	private static final String DEFAULT_PAGE = "1";
	private static final String DEFAULT_PAGE_SIZE = "3";
	
    @Autowired
    BoardService boardService;

    /**
     * 메인 게시판 전체 검색 
     * @param rank
     * @param position
     * @param playTime
     * @param page
     * @param pageSize
     * @param hash
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/board/findAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findAll(@RequestParam(value = "rank",defaultValue="") String rank,
    						@RequestParam(value = "position",defaultValue="") String position,
    						@RequestParam(value = "playTime",defaultValue="") String playTime,
    						@RequestParam(value = "page",defaultValue=DEFAULT_PAGE) int page,
    						@RequestParam(value = "pageSize",defaultValue=DEFAULT_PAGE_SIZE) int pageSize,
    						@RequestParam(value = "hash") String hash) throws ParseException {
    	
        return boardService.findAll(rank,position,playTime,hash,page,pageSize);
    }
    
    /**
     * 내 게시판 검색 
     * @param faceBookId
     * @param hash
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/board/findMyAll", method = RequestMethod.GET)
    @ResponseBody
    public Object findMyAll(@RequestParam(value = "faceBookId") String faceBookId,
    						  @RequestParam(value = "hash") String hash) throws ParseException {
        return boardService.findMyAll(faceBookId,hash);
    }
    
    /**
     * 게시판 한개 검색
     * @param boardId
     * @param hash
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/board/findOne", method = RequestMethod.GET)
    @ResponseBody
    public Object findOne(@RequestParam(value = "boardId") int boardId,
    						@RequestParam(value = "hash") String hash) throws ParseException {
        return boardService.findOne(boardId,hash);
    }

}

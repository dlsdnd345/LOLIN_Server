package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.dao.BoardDao;
import com.iris.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public Object selectAll() throws ParseException {
        return boardService.findAll();

    }

}

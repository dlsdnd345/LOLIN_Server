package com.iris.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iris.service.UpdateBoardService;

@Controller
public class UpdateBoardController {

	@Autowired
    UpdateBoardService updateBoardService;

    @RequestMapping(value = "/updateBorad/findOne", method = RequestMethod.GET)
    @ResponseBody
    public Object findOne(@RequestParam(value = "versionName") String versionName,
    						@RequestParam(value = "hash") String hash) throws ParseException {
    	
    	return updateBoardService.findByVersion(versionName, hash);
    }
}

package com.fei.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fei.app.model.MyException;
import com.fei.app.model.User;
import com.fei.app.model.WordUtil;
import com.fei.app.service.IUserService;
import com.fei.app.service.IWordService;

@Controller
@RequestMapping("/word")
public class WordController {
	
	@Resource
	private IWordService wordService;
	
	@ResponseBody
	@RequestMapping("/query")
	public List<String> query() throws MyException{
		
		List<String> name = new ArrayList(); 
		name = wordService.Query();
		return name;
	}

}

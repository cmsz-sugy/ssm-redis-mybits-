package com.fei.app.service;

import java.util.List;

import com.fei.app.model.MyException;
import com.fei.app.model.User;
import com.fei.app.model.WordUtil;

public interface IWordService {
	
	public List<String>Query() throws MyException;
	

}

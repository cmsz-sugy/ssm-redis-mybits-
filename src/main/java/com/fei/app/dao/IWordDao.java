package com.fei.app.dao;

import java.util.List;

import com.fei.app.model.MyException;
import com.fei.app.model.User;
import com.fei.app.model.WordUtil;

public interface IWordDao {
	
	public List<String> Query() throws MyException; 

}

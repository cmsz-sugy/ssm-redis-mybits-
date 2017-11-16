package com.fei.app.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fei.app.dao.IUserDao;
import com.fei.app.dao.IWordDao;
import com.fei.app.model.MyException;
import com.fei.app.model.User;
import com.fei.app.model.WordUtil;
import com.fei.app.service.IWordService;

@Service
public class WordServiceImpl implements IWordService {
	
    @Resource
    private IWordDao wordDao;
	 
    @Override
    public List<String>Query() throws MyException{
    	
    	return wordDao.Query();
    	
    }
}

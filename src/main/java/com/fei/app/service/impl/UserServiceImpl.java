package com.fei.app.service.impl;

import com.fei.app.dao.IUserDao;
import com.fei.app.model.User;
import com.fei.app.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

/**
 * Created by fei on 2015/9/17.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private IUserDao userDao;

    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
    
    @Override
    public List<User> getUser(int id){
    	
    	return userDao.getUser(id);
    	
    }
    
    @Override
    public void insert(User user) {
    	
    	userDao.insertInfo(user);
    	
    	
    }
}

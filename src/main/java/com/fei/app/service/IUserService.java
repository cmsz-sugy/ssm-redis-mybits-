package com.fei.app.service;

import java.util.List;

import com.fei.app.model.User;

/**
 * Created by fei on 2015/9/17.
 */
public interface IUserService {
    User findUserById(Integer id);
    List<User>getUser(int id);
    public void insert(User user);
}

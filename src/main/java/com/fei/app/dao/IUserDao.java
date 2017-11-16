package com.fei.app.dao;

        import java.util.List;

import org.springframework.stereotype.Repository;

import com.fei.app.model.User;

/**
 * Created by fei on 2015/9/17.
 */
@Repository
public interface IUserDao {
    User findUserById(Integer id);
    List<User> getUser(int id);
    void insertInfo(User user);
}

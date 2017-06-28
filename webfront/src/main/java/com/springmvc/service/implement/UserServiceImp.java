package com.springmvc.service.implement;

import com.springmvc.dao.UserMapper;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huanghaojian on 17/6/24.
 */
@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;
    public User login(User user){
        String userAccount=user.getUserAccount();
        String password=user.getPassword();
        return userMapper.login(userAccount,password);
    }

    public int register(User user){
        return userMapper.register(user);
    }

    public int duplicateAccountChecking(String userAccount){
        return userMapper.duplicateAccountChecking(userAccount);
    }

    public int modifyPassword(User user){
        return userMapper.modifyPassword(user);
    }

    public int modifyPersonalInfo(User user){
        return userMapper.modifyPersonalInfo(user);
    }

    public int upgrade(User user){
        return userMapper.upgrade(user);
    }

    public int getExperience(User user){
        return userMapper.getExperience(user);
    }

    public int modifyState(User user){
        return userMapper.modifyState(user);
    }

    public User selectByPrimaryKey(String userAccount){
        return userMapper.selectByPrimaryKey(userAccount);
    }
}

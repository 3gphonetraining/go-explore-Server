package com.springmvc.service;

import com.springmvc.model.User;

/**
 * Created by huanghaojian on 17/6/24.
 */
public interface UserService {
    public User login(User user);

    public int register(User user);

    public int duplicateAccountChecking(String userAccount);

    public int modifyPassword(User user);

    public int modifyPersonalInfo(User user);

    public int upgrade(User user);

    public int getExperience(User user);

    public int modifyState(User user);

    public User selectByPrimaryKey(String userAccount);
}

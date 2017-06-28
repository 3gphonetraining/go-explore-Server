package com.springmvc.dao;

import com.springmvc.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(String userAccount);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User login(@Param("userAccount") String userName, @Param("password") String password);

    int register(User user);

    int duplicateAccountChecking(String userAccount);

    int modifyPassword(User user);

    int modifyPersonalInfo(User user);

    int upgrade(User user);

    int getExperience(User user);

    int modifyState(User user);
}
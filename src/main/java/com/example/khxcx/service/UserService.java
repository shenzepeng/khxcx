package com.example.khxcx.service;

import com.example.khxcx.pojo.User;

import java.util.List;


public interface UserService {

    void insertUser(User user);

    void deleteUserById(long id);

    void updateUserById(User user);

    void updateUserMoney(long id,double money);


    User findUserById(long id);

    List<User> findUserByNickName(String nickname);

    List<User> findAllUser();

    List<User> findUserByOpenId(String openId);

    User findUserByCreateTime(String createTime);
}

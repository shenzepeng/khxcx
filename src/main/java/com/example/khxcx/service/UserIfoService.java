package com.example.khxcx.service;

import com.example.khxcx.pojo.UserIfo;

import java.util.List;



//userifo
public interface UserIfoService {

    void insertUserIfo(UserIfo userIfo);

    void deleteUserIfoById(long id);

    void updateUserIfoById(UserIfo userIfo);

    UserIfo findUserIfoById(long id);

    List<UserIfo> findUserIfoByUserId(long userId);

    List<UserIfo> findUserIfoByGivenName(String giveName);

    List<UserIfo> findAllUserIfo();

    List<UserIfo> findByZiDuan(String string);
}

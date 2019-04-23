package com.example.khxcx.service;

import com.example.khxcx.pojo.Likes;

import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 07:51
 * @Description: SualLabel, Write down some description!!!
 */


public interface LikesService {

    void insertLikes(Likes likes);

    void deleteLikesById(long id);

    void updateLikesById(Likes likes);

    Likes findLikesById(long id);

    List<Likes> findLikesBy(long userId,long dianzanId);

    int getCountsByUserId(long userId);

}

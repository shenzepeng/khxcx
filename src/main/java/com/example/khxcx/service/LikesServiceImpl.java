package com.example.khxcx.service;

import com.example.khxcx.mapper.LikesMapper;
import com.example.khxcx.pojo.Likes;
import com.example.khxcx.pojo.LikesExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 08:09
 * @Description: SualLabel, Write down some description!!!
 */
@Service
public class LikesServiceImpl implements LikesService {
    @Autowired
    private LikesMapper likesMapper;
    @Override
    public void insertLikes(Likes likes) {
        likesMapper.insert(likes);
    }

    @Override
    public void deleteLikesById(long id) {
        likesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateLikesById(Likes likes) {
        likesMapper.updateByPrimaryKeySelective(likes);
    }

    @Override
    public Likes findLikesById(long id) {
        Likes likes = likesMapper.selectByPrimaryKey(id);
        return likes;
    }

    @Override
    public List<Likes> findLikesBy(long userId, long dianzanId) {
        LikesExample likesExample=new LikesExample();
        likesExample.createCriteria()
                .andUserIdEqualTo(userId)
                .andDianzanIdEqualTo(dianzanId);
        List<Likes> likes = likesMapper.selectByExample(likesExample);
        return likes;
    }

    @Override
    public int getCountsByUserId(long userId) {
        LikesExample likesExample=new LikesExample();
        likesExample.createCriteria()
                .andUserIdEqualTo(userId);
        int i = likesMapper.countByExample(likesExample);
        return i;
    }
}

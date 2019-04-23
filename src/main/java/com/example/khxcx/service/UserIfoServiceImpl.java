package com.example.khxcx.service;

import com.example.khxcx.mapper.UserIfoMapper;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.UserIfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 08:10
 * @Description: SualLabel, Write down some description!!!
 */
@Service
public class UserIfoServiceImpl implements UserIfoService {
    @Autowired
    private UserIfoMapper userIfoMapper;
    @Override
    public void insertUserIfo(UserIfo userIfo) {
        userIfoMapper.insert(userIfo);
    }

    @Override
    public void deleteUserIfoById(long id) {
        userIfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserIfoById(UserIfo userIfo) {
        userIfoMapper.updateByPrimaryKeySelective(userIfo);
    }

    @Override
    public UserIfo findUserIfoById(long id) {
        UserIfo userIfo = userIfoMapper.selectByPrimaryKey(id);
        return userIfo;
    }

    @Override
    public List<UserIfo> findUserIfoByUserId(long userId) {
        UserIfoExample userIfoExample=new UserIfoExample();
        userIfoExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<UserIfo> userIfos = userIfoMapper.selectByExample(userIfoExample);
        return userIfos;
    }

    @Override
    public List<UserIfo> findUserIfoByGivenName(String giveName) {
        UserIfoExample userIfoExample=new UserIfoExample();
        userIfoExample.createCriteria()
                .andGivenNameEqualTo(giveName);
        List<UserIfo> userIfos = userIfoMapper.selectByExample(userIfoExample);
        return userIfos;
    }

    @Override
    public List<UserIfo> findAllUserIfo() {
        UserIfoExample userIfoExample=new UserIfoExample();
        userIfoExample.createCriteria()
                .getAllCriteria();
        List<UserIfo> userIfos = userIfoMapper.selectByExample(userIfoExample);
        return userIfos;
    }

    @Override
    public List<UserIfo> findByZiDuan(String string) {
        UserIfoExample userIfoExample=new UserIfoExample();
        //通过introduce查询
        userIfoExample.createCriteria()
                .andIntroduceLike(string);
        List<UserIfo> userIfos = userIfoMapper.selectByExample(userIfoExample);
        UserIfoExample userIfoExample1=new UserIfoExample();
        //通过真实姓名查询
        userIfoExample1.createCriteria()
                .andGivenNameLike(string);
        List<UserIfo> userIfos1 = userIfoMapper.selectByExample(userIfoExample1);
        //通过性别
        UserIfoExample userIfoExample2=new UserIfoExample();
        userIfoExample2.createCriteria()
                .andSexEqualTo(string);
        //通过年龄查询
        List<UserIfo> userIfos2 = userIfoMapper.selectByExample(userIfoExample2);
        ArrayList<UserIfo> arrayList=new ArrayList<>();
        if (userIfos.size()!=0&&userIfos!=null) {
            for (int i = 0; i < userIfos.size(); i++) {

                arrayList.add(userIfos.get(i));
            }
        }
        if (userIfos1.size()!=0&&userIfos1!=null) {
            for (int i = 0; i < userIfos1.size(); i++) {

                arrayList.add(userIfos1.get(i));
            }
        }
        if (userIfos2.size()!=0&&userIfos2!=null) {
            for (int i = 0; i < userIfos2.size(); i++) {

                arrayList.add(userIfos2.get(i));
            }
        }
        return arrayList;
    }
}

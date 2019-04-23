package com.example.khxcx.service;

import com.example.khxcx.mapper.UserMapper;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public void insertUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void deleteUserById(long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateUserById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updateUserMoney(long id, double money) {
        User user=new User();
        user.setId(id);
        user.setMoney(money);
        userMapper.updateByPrimaryKey(user);
    }


    @Override
    public User findUserById(long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public List<User> findUserByNickName(String nickname) {
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .andNickNameEqualTo(nickname);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> findAllUser() {
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .getAllCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public List<User> findUserByOpenId(String openId) {
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .andOpenIdEqualTo(openId);
        List<User> users = userMapper.selectByExample(userExample);
        return users;
    }

    @Override
    public User findUserByCreateTime(String createTime) {
        UserExample userExample=new UserExample();
        userExample.createCriteria()
                .andBlankSpaceTwoEqualTo(createTime);
        List<User> users = userMapper.selectByExample(userExample);
        return users.get(0);
    }
}

package com.example.khxcx.service;

import com.example.khxcx.mapper.SuperUserMapper;
import com.example.khxcx.pojo.SuperUser;
import com.example.khxcx.pojo.SuperUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperUserServiceImpl implements SuperUserService {
    @Autowired
    private SuperUserMapper superUserMapper;
    @Override
    public SuperUser login(String username, String password) {
        SuperUserExample superUserExample=new SuperUserExample();
        superUserExample.createCriteria()
                .andUsernameEqualTo(username)
                .andPasswordEqualTo(password);
        List<SuperUser> superUsers = superUserMapper.selectByExample(superUserExample);
        return superUsers.get(0);
    }
}

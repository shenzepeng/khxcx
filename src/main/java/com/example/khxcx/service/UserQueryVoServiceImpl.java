package com.example.khxcx.service;

import com.example.khxcx.mapper.UserQueryVoMapper;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserQueryVoServiceImpl implements UserQueryVoService{
    @Autowired
    private UserQueryVoMapper userQueryVoMapper;


    @Override
    public List<UserQueryVo> findUserAllQueryVo() {
        List<UserQueryVo> allUserQueryVo = userQueryVoMapper.findAllUserQueryVo();
        return allUserQueryVo;
    }
}

package com.example.khxcx.mapper;

import com.example.khxcx.pojo.quvo.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserQueryVoMapper {
    public List<UserQueryVo> findAllUserQueryVo();
}

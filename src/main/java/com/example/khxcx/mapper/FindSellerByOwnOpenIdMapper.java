package com.example.khxcx.mapper;

import com.example.khxcx.pojo.quvo.UserQueryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface FindSellerByOwnOpenIdMapper {
    List<UserQueryVo> findSellerByOwnOpenIdMapper(int id);
    //public List<UserQueryVo> findAllUserQueryVo();
}

package com.example.khxcx.mapper;

import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.pojo.UserIfoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserIfoMapper {
    int countByExample(UserIfoExample example);

    int deleteByExample(UserIfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserIfo record);

    int insertSelective(UserIfo record);

    List<UserIfo> selectByExample(UserIfoExample example);

    UserIfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserIfo record, @Param("example") UserIfoExample example);

    int updateByExample(@Param("record") UserIfo record, @Param("example") UserIfoExample example);

    int updateByPrimaryKeySelective(UserIfo record);

    int updateByPrimaryKey(UserIfo record);
}
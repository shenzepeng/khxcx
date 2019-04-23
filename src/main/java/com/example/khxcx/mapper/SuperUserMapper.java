package com.example.khxcx.mapper;

import com.example.khxcx.pojo.SuperUser;
import com.example.khxcx.pojo.SuperUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SuperUserMapper {
    int countByExample(SuperUserExample example);

    int deleteByExample(SuperUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SuperUser record);

    int insertSelective(SuperUser record);

    List<SuperUser> selectByExample(SuperUserExample example);

    SuperUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SuperUser record, @Param("example") SuperUserExample example);

    int updateByExample(@Param("record") SuperUser record, @Param("example") SuperUserExample example);

    int updateByPrimaryKeySelective(SuperUser record);

    int updateByPrimaryKey(SuperUser record);
}
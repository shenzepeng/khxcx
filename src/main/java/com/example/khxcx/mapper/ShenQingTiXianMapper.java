package com.example.khxcx.mapper;

import com.example.khxcx.pojo.ShenQingTiXian;
import com.example.khxcx.pojo.ShenQingTiXianExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ShenQingTiXianMapper {
    int countByExample(ShenQingTiXianExample example);

    int deleteByExample(ShenQingTiXianExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShenQingTiXian record);

    int insertSelective(ShenQingTiXian record);

    List<ShenQingTiXian> selectByExample(ShenQingTiXianExample example);

    ShenQingTiXian selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShenQingTiXian record, @Param("example") ShenQingTiXianExample example);

    int updateByExample(@Param("record") ShenQingTiXian record, @Param("example") ShenQingTiXianExample example);

    int updateByPrimaryKeySelective(ShenQingTiXian record);

    int updateByPrimaryKey(ShenQingTiXian record);
}
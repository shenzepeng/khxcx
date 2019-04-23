package com.example.khxcx.mapper;

import com.example.khxcx.pojo.MakeSurePayIdOk;
import com.example.khxcx.pojo.MakeSurePayIdOkExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface MakeSurePayIdOkMapper {
    int countByExample(MakeSurePayIdOkExample example);

    int deleteByExample(MakeSurePayIdOkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MakeSurePayIdOk record);

    int insertSelective(MakeSurePayIdOk record);

    List<MakeSurePayIdOk> selectByExample(MakeSurePayIdOkExample example);

    MakeSurePayIdOk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MakeSurePayIdOk record, @Param("example") MakeSurePayIdOkExample example);

    int updateByExample(@Param("record") MakeSurePayIdOk record, @Param("example") MakeSurePayIdOkExample example);

    int updateByPrimaryKeySelective(MakeSurePayIdOk record);

    int updateByPrimaryKey(MakeSurePayIdOk record);
}
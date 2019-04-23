package com.example.khxcx.mapper;

import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.InvestmentStatementExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface InvestmentStatementMapper {
    int countByExample(InvestmentStatementExample example);

    int deleteByExample(InvestmentStatementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InvestmentStatement record);

    int insertSelective(InvestmentStatement record);

    List<InvestmentStatement> selectByExample(InvestmentStatementExample example);

    InvestmentStatement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InvestmentStatement record, @Param("example") InvestmentStatementExample example);

    int updateByExample(@Param("record") InvestmentStatement record, @Param("example") InvestmentStatementExample example);

    int updateByPrimaryKeySelective(InvestmentStatement record);

    int updateByPrimaryKey(InvestmentStatement record);
}
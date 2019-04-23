package com.example.khxcx.mapper;

import com.example.khxcx.pojo.PurchaseRecord;
import com.example.khxcx.pojo.PurchaseRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PurchaseRecordMapper {
    int countByExample(PurchaseRecordExample example);

    int deleteByExample(PurchaseRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseRecord record);

    int insertSelective(PurchaseRecord record);

    List<PurchaseRecord> selectByExample(PurchaseRecordExample example);

    PurchaseRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByExample(@Param("record") PurchaseRecord record, @Param("example") PurchaseRecordExample example);

    int updateByPrimaryKeySelective(PurchaseRecord record);

    int updateByPrimaryKey(PurchaseRecord record);
}
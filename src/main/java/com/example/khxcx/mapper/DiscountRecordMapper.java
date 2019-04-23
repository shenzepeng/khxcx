package com.example.khxcx.mapper;

import com.example.khxcx.pojo.DiscountRecord;
import com.example.khxcx.pojo.DiscountRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DiscountRecordMapper {
    int countByExample(DiscountRecordExample example);

    int deleteByExample(DiscountRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DiscountRecord record);

    int insertSelective(DiscountRecord record);

    List<DiscountRecord> selectByExample(DiscountRecordExample example);

    DiscountRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DiscountRecord record, @Param("example") DiscountRecordExample example);

    int updateByExample(@Param("record") DiscountRecord record, @Param("example") DiscountRecordExample example);

    int updateByPrimaryKeySelective(DiscountRecord record);

    int updateByPrimaryKey(DiscountRecord record);
}
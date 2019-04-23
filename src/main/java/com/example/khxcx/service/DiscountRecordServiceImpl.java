package com.example.khxcx.service;


import com.example.khxcx.mapper.DiscountRecordMapper;
import com.example.khxcx.pojo.DiscountRecord;
import com.example.khxcx.pojo.DiscountRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 08:09
 * @Description: SualLabel, Write down some description!!!
 */
@Service
public class DiscountRecordServiceImpl implements DiscountRecordService {
    @Autowired
    private DiscountRecordMapper discountRecordMapper;

    @Override
    public void insertDiscountRecord(DiscountRecord discountRecord) {
        discountRecordMapper.insert(discountRecord);
    }

    @Override
    public void deleteDiscountRecordById(long id) {
        discountRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateDiscountRecordById(DiscountRecord discountRecord) {
        discountRecordMapper.updateByPrimaryKeySelective(discountRecord);
    }

    @Override
    public DiscountRecord findDiscountRecordById(long id) {
        DiscountRecord discountRecord = discountRecordMapper.selectByPrimaryKey(id);
        return discountRecord;
    }

    @Override
    public List<DiscountRecord> findDiscountRecordByUserId(long userId) {
        DiscountRecordExample discountRecordExample=new DiscountRecordExample();
        discountRecordExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<DiscountRecord> discountRecords = discountRecordMapper.selectByExample(discountRecordExample);
        return discountRecords;
    }
}

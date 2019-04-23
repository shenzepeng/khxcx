package com.example.khxcx.service;

import com.example.khxcx.pojo.DiscountRecord;

import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 08:03
 * @Description: SualLabel, Write down some description!!!
 */

public interface DiscountRecordService {

    void insertDiscountRecord(DiscountRecord discountRecord);

    void deleteDiscountRecordById(long id);

    void updateDiscountRecordById(DiscountRecord discountRecord);

    DiscountRecord findDiscountRecordById(long id);

    List<DiscountRecord> findDiscountRecordByUserId(long userId);
}

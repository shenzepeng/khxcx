package com.example.khxcx.service;

import com.example.khxcx.pojo.PurchaseRecord;

import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 07:44
 * @Description: SualLabel, Write down some description!!!
 */

public interface PurchaseRecordService {
    //增加
    void insertPurchaseRecord(PurchaseRecord purchaseRecord);
    //删除
    void deletePurchaseRecordById(long id);
    //更新
    void updatePurcahseRecordById(PurchaseRecord purchaseRecord);

    PurchaseRecord findPurchaseRecordById(long id);

    List<PurchaseRecord> findPurchaseRecordByBuyId(long buyerId);

    List<PurchaseRecord> findPurchaseRecordBySellerId(long sellerId);

}

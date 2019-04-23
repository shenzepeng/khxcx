package com.example.khxcx.service;

import com.example.khxcx.mapper.PurchaseRecordMapper;
import com.example.khxcx.pojo.PurchaseRecord;
import com.example.khxcx.pojo.PurchaseRecordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 08:09
 * @Description: SualLabel, Write down some description!!!
 */
@Service
public class PurchaseRecordServiceImpl implements PurchaseRecordService{
    @Autowired
    private PurchaseRecordMapper purchaseRecordMapper;
    @Override
    public void insertPurchaseRecord(PurchaseRecord purchaseRecord) {
        purchaseRecordMapper.insert(purchaseRecord);
    }

    @Override
    public void deletePurchaseRecordById(long id) {
        purchaseRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updatePurcahseRecordById(PurchaseRecord purchaseRecord) {
        purchaseRecordMapper.updateByPrimaryKeySelective(purchaseRecord);
    }

    @Override
    public PurchaseRecord findPurchaseRecordById(long id) {
        PurchaseRecord purchaseRecord = purchaseRecordMapper.selectByPrimaryKey(id);
        return purchaseRecord;
    }

    @Override
    public List<PurchaseRecord> findPurchaseRecordByBuyId(long buyerId) {
        PurchaseRecordExample purchaseRecordExample=new PurchaseRecordExample();
        purchaseRecordExample.createCriteria()
                .andBuyerIdEqualTo(buyerId);
        List<PurchaseRecord> purchaseRecords = purchaseRecordMapper.selectByExample(purchaseRecordExample);
        return purchaseRecords;
    }

    @Override
    public List<PurchaseRecord> findPurchaseRecordBySellerId(long sellerId) {
        PurchaseRecordExample purchaseRecordExample=new PurchaseRecordExample();
        purchaseRecordExample.createCriteria()
                .andSellerIdEqualTo(sellerId);
        List<PurchaseRecord> purchaseRecords = purchaseRecordMapper.selectByExample(purchaseRecordExample);
        return purchaseRecords;
    }
}

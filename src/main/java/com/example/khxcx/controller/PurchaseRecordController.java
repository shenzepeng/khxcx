package com.example.khxcx.controller;

import com.example.khxcx.pojo.PurchaseRecord;
import com.example.khxcx.service.PurchaseRecordService;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:19
 * @Description: SualLabel, Write down some description!!!
 */

@Api(value = "PurchaseRecordController")
@RestController
public class PurchaseRecordController {
    @Autowired
    private PurchaseRecordService purchaseRecordService;

    @DeleteMapping("/deletePurchaseRecordById.action")
    public SzpJsonResult deletePurchaseRecordById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        purchaseRecordService.deletePurchaseRecordById(id);
        return SzpJsonResult.ok();
    }
   @PostMapping("/updatePurcahseRecordById.action")
    public SzpJsonResult updatePurcahseRecordById(PurchaseRecord purchaseRecord, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        purchaseRecordService.updatePurcahseRecordById(purchaseRecord);
        return SzpJsonResult.ok();
    }
    @GetMapping("/findPurchaseRecordById.action")
    public SzpJsonResult findPurchaseRecordById(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        PurchaseRecord purchaseRecordById = purchaseRecordService.findPurchaseRecordById(id);
        return SzpJsonResult.ok(purchaseRecordById);
    }
    @GetMapping("/findPurchaseRecordByBuyId.action")
    public SzpJsonResult findPurchaseRecordByBuyId(long buyerId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<PurchaseRecord> purchaseRecordByBuyId = purchaseRecordService.findPurchaseRecordByBuyId(buyerId);
        return SzpJsonResult.ok(purchaseRecordByBuyId);
    }
   @GetMapping("/findPurchaseRecordBySellerId")
    public SzpJsonResult findPurchaseRecordBySellerId(long sellerId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<PurchaseRecord> purchaseRecordBySellerId = purchaseRecordService.findPurchaseRecordBySellerId(sellerId);
        return SzpJsonResult.ok(purchaseRecordBySellerId);
    }

}

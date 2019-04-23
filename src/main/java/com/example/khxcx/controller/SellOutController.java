package com.example.khxcx.controller;

import com.example.khxcx.mapper.InvestmentStatementMapper;
import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.InvestmentStatementService;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class SellOutController {
    @Autowired
    private InvestmentStatementService investmentStatementService;
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private InvestmentStatementMapper mapper;
    @GetMapping("/sellOutEnd.action")
    public SzpJsonResult sellOutEnd(
                                    double purchaseVolume,

                                    double purchasePriceTotal,

                                    long investmentStatementId,
            HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        InvestmentStatement investmentStatementById =
                investmentStatementService.findInvestmentStatementById(investmentStatementId);

        Long sellerId = investmentStatementById.getSellerId();

        Long buyerId = investmentStatementById.getBuyerId();


        UserIfo userIfo1 = userIfoService.findUserIfoByUserId(sellerId).get(0);
        Double shengyugoumailaing = userIfo1.getShengyugoumailaing();
        userIfo1.setShengyugoumailaing(shengyugoumailaing+purchaseVolume);
        userIfoService.updateUserIfoById(userIfo1);

        UserIfo userIfo2 = userIfoService.findUserIfoByUserId(buyerId).get(0);
        Long userId = userIfo2.getUserId();
        User userById = userService.findUserById(userId);
        Double money = userById.getMoney();
        userById.setMoney(purchasePriceTotal+money);
        userService.updateUserById(userById);



        investmentStatementById.setBlankSpaceOne("");
        investmentStatementById.setSellerId(investmentStatementById.getSellerId());
        investmentStatementById.setBuyerId(investmentStatementById.getBuyerId());
        investmentStatementById.setPurchaseVolume(investmentStatementById.getPurchaseVolume());
        investmentStatementById.setPurchasePrice(investmentStatementById.getPurchasePrice());
    //mapper.updateByPrimaryKeySelective(investmentStatementById);
        investmentStatementService.updateInvestmentStatementById(investmentStatementById);
        return SzpJsonResult.ok();
    }
}

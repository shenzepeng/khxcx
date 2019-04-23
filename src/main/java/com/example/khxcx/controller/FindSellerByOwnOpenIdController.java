package com.example.khxcx.controller;

import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import com.example.khxcx.service.FindSellerByOwnOpenIdService;
import com.example.khxcx.service.InvestmentStatementService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@RestController
public class FindSellerByOwnOpenIdController {
    @Autowired
    private FindSellerByOwnOpenIdService findSellerByOwnOpenIdService;
    @Autowired
    private UserService userService;
    @Autowired
    private InvestmentStatementService investmentStatementService;
    @GetMapping("/findSellerByOwnOpenIdServiceByO.action")
    public SzpJsonResult findSellerByOwnOpenIdServiceByO(String openId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        //通过openId找到User
        List<User> userByOpenId = userService.findUserByOpenId(openId);

        List<InvestmentStatement> investmentStatementByBuyerId = investmentStatementService.findInvestmentStatementByBuyerId(userByOpenId.get(0).getId());
        System.out.println(investmentStatementByBuyerId.size());
        ArrayList<HashMap<String,Object>> arrayList=new ArrayList<>();
       // HashSet<HashMap<String,Object>> hashMaps=new HashSet<>();
        for (InvestmentStatement i:
                investmentStatementByBuyerId) {

            Long sellerId = i.getSellerId();
            UserQueryVo userQueryVo = findSellerByOwnOpenIdService.findSellerByOwnOpenIdMapper(sellerId.intValue()).get(0);
            long userId = userQueryVo.getUserId();
            InvestmentStatement investmentStatement = investmentStatementService.findInvestmentStatementBySellerId(userId).get(0);
            String blankSpaceOne = investmentStatement.getBlankSpaceOne();
            HashMap<String,Object> hashMap1=new HashMap<>();
            hashMap1.put("investmentStatementId",i.getId());
            hashMap1.put("userQueryVo",userQueryVo);
            InvestmentStatement investmentStatementById = investmentStatementService.findInvestmentStatementById(i.getId());
            hashMap1.put("blankSpaceOne",investmentStatementById.getBlankSpaceOne());
            arrayList.add(hashMap1);
        }
        System.out.println(arrayList);
        return SzpJsonResult.ok(arrayList);
    }
}

package com.example.khxcx.service;

import com.example.khxcx.pojo.InvestmentStatement;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;



public interface InvestmentStatementService {

    void insertInvestmentStatement(InvestmentStatement investmentStatement);

    void deleteInvestmentStatementById(long id);

    void updateInvestmentStatementById(InvestmentStatement investmentStatement);

    InvestmentStatement findInvestmentStatementById(long id);

    List<InvestmentStatement> findInvestmentStatementByBuyerId(long buyId);

    List<InvestmentStatement> findInvestmentStatementBySellerId(long sellerId);
}

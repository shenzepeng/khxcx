package com.example.khxcx.service;

import com.example.khxcx.mapper.InvestmentStatementMapper;
import com.example.khxcx.pojo.InvestmentStatement;
import com.example.khxcx.pojo.InvestmentStatementExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InvestmentStatementServiceImpl implements InvestmentStatementService {
    @Autowired
    private InvestmentStatementMapper investmentStatementMapper;
    @Override
    public void insertInvestmentStatement(InvestmentStatement investmentStatement) {
        investmentStatementMapper.insert(investmentStatement);
    }

    @Override
    public void deleteInvestmentStatementById(long id) {
        investmentStatementMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateInvestmentStatementById(InvestmentStatement investmentStatement) {
        investmentStatementMapper.updateByPrimaryKeySelective(investmentStatement);
    }

    @Override
    public InvestmentStatement findInvestmentStatementById(long id) {
        InvestmentStatement investmentStatement = investmentStatementMapper.selectByPrimaryKey(id);
        return investmentStatement;
    }

    @Override
    public List<InvestmentStatement> findInvestmentStatementByBuyerId(long buyId) {
        InvestmentStatementExample investmentStatementExample=new InvestmentStatementExample();
        investmentStatementExample.createCriteria()
                .andBuyerIdEqualTo(buyId);
        List<InvestmentStatement> investmentStatements = investmentStatementMapper.selectByExample(investmentStatementExample);
        return investmentStatements;
    }

    @Override
    public List<InvestmentStatement> findInvestmentStatementBySellerId(long sellerId) {
        InvestmentStatementExample investmentStatementExample=new InvestmentStatementExample();
        investmentStatementExample.createCriteria()
                .andSellerIdEqualTo(sellerId);
        List<InvestmentStatement> investmentStatements = investmentStatementMapper.selectByExample(investmentStatementExample);
        return investmentStatements;
    }
}

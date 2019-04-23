package com.example.khxcx.service;

import com.example.khxcx.mapper.MakeSurePayIdOkMapper;
import com.example.khxcx.pojo.MakeSurePayIdOk;
import com.example.khxcx.pojo.MakeSurePayIdOkExample;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MakeSurePayIdOkServiceImpl implements MakeSurePayIdOkService{
    @Autowired
    private MakeSurePayIdOkMapper makeSurePayIdOkMapper;
    @Override
    public void insertMakeSurePayIdOk(MakeSurePayIdOk makeSurePayIdOk) {
        makeSurePayIdOkMapper.insert(makeSurePayIdOk);
    }

    @Override
    public MakeSurePayIdOk findMakeSurePayIdOkById(long id) {
        MakeSurePayIdOk makeSurePayIdOk = makeSurePayIdOkMapper.selectByPrimaryKey(id);
        return makeSurePayIdOk;
    }

    @Override
    public MakeSurePayIdOk findMakeSurePayIdOkByOrderId(String orderId) {
        MakeSurePayIdOkExample makeSurePayIdOkExample=new MakeSurePayIdOkExample();
        makeSurePayIdOkExample.createCriteria()
                .andOrderIdEqualTo(orderId);
        List<MakeSurePayIdOk> makeSurePayIdOks = makeSurePayIdOkMapper.selectByExample(makeSurePayIdOkExample);
        return makeSurePayIdOks.get(0);
    }

    @Override
    public List<MakeSurePayIdOk> findMakeMakeSurePayIdOkByOpenId(String openId) {
        MakeSurePayIdOkExample makeSurePayIdOkExample=new MakeSurePayIdOkExample();
        makeSurePayIdOkExample.createCriteria()
                .andOpendIdEqualTo(openId);
        List<MakeSurePayIdOk> makeSurePayIdOks = makeSurePayIdOkMapper.selectByExample(makeSurePayIdOkExample);
        return makeSurePayIdOks;
    }

    @Override
    public void updataMakeSurePayIdOkById(MakeSurePayIdOk makeSurePayIdOk) {
        makeSurePayIdOkMapper.updateByPrimaryKeySelective(makeSurePayIdOk);
    }
}

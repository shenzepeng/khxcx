package com.example.khxcx.service;

import com.example.khxcx.mapper.ShenQingTiXianMapper;
import com.example.khxcx.pojo.ShenQingTiXian;
import com.example.khxcx.pojo.ShenQingTiXianExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShenQingTiXianServiceImpl implements ShenQingTiXianService {
    @Autowired
    private ShenQingTiXianMapper shenQingTiXianMapper;
    @Override
    public List<ShenQingTiXian> getShenQinTiXianShowAll() {
        ShenQingTiXianExample shenQingTiXianExample=new ShenQingTiXianExample();
        shenQingTiXianExample.createCriteria()
                .getAllCriteria();
        List<ShenQingTiXian> shenQingTiXians = shenQingTiXianMapper.selectByExample(shenQingTiXianExample);
        return shenQingTiXians;
    }

    @Override
    public List<ShenQingTiXian> getShenQinTiXianByStatus(String status) {
        ShenQingTiXianExample shenQingTiXianExample=new ShenQingTiXianExample();
        shenQingTiXianExample.createCriteria()
                .andStatusEqualTo(status);
        List<ShenQingTiXian> list=shenQingTiXianMapper.selectByExample(shenQingTiXianExample);
        return null;
    }

    @Override
    public void chageShenQinTiXianStatus(long id) {

        ShenQingTiXian shenQingTiXian = shenQingTiXianMapper.selectByPrimaryKey(id);
        shenQingTiXian.setStatus("");
        shenQingTiXianMapper.updateByPrimaryKeySelective(shenQingTiXian);
    }

    @Override
    public void insertShenQingTiXian(ShenQingTiXian shenQingTiXian) {
        shenQingTiXianMapper.insert(shenQingTiXian);
    }
}

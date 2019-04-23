package com.example.khxcx.service;

import com.example.khxcx.pojo.ShenQingTiXian;

import java.util.List;


public interface ShenQingTiXianService {
    List<ShenQingTiXian> getShenQinTiXianShowAll();
    List<ShenQingTiXian> getShenQinTiXianByStatus(String status);
    void chageShenQinTiXianStatus(long id);
    void insertShenQingTiXian(ShenQingTiXian shenQingTiXian);
}

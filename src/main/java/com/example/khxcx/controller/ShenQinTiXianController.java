package com.example.khxcx.controller;

import com.example.khxcx.pojo.ShenQingTiXian;
import com.example.khxcx.service.ShenQingTiXianService;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ShenQinTiXianController {
    @Autowired
    private ShenQingTiXianService shenQingTiXianService;
   @GetMapping("/getShenQinTiXianShowAll.action")
    public SzpJsonResult getShenQinTiXianShowAll(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<ShenQingTiXian> shenQinTiXianShowAll = shenQingTiXianService.getShenQinTiXianShowAll();
        return SzpJsonResult.ok(shenQinTiXianShowAll);
    }
   @GetMapping("/getShenQinTiXianByStatus.action")
    public SzpJsonResult getShenQinTiXianByStatus(String status, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<ShenQingTiXian> shenQinTiXianByStatus = shenQingTiXianService.getShenQinTiXianByStatus(status);
        return SzpJsonResult.ok(shenQinTiXianByStatus);
    }
    @PutMapping("/chageShenQinTiXianStatus.action")
    public SzpJsonResult chageShenQinTiXianStatus(long id, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        shenQingTiXianService.chageShenQinTiXianStatus(id);
        return SzpJsonResult.ok();
    }
}

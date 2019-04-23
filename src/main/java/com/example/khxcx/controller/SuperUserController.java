package com.example.khxcx.controller;

import com.example.khxcx.pojo.SuperUser;
import com.example.khxcx.service.SuperUserService;
import com.example.khxcx.utils.SzpJsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


@RestController
public class SuperUserController {
    @Autowired
    private SuperUserService superUserService;
    @GetMapping("/login.action")
    public SzpJsonResult login(String username,String password, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        SuperUser login = superUserService.login(username, password);
        return SzpJsonResult.ok(login);
    }
}

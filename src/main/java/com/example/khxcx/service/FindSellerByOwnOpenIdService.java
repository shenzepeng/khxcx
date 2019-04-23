package com.example.khxcx.service;

import com.example.khxcx.pojo.quvo.UserQueryVo;

import java.util.List;


public interface FindSellerByOwnOpenIdService {
    List<UserQueryVo> findSellerByOwnOpenIdMapper(int id);
}

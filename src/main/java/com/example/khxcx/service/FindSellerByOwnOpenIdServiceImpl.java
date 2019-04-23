package com.example.khxcx.service;

import com.example.khxcx.mapper.FindSellerByOwnOpenIdMapper;
import com.example.khxcx.pojo.quvo.UserQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FindSellerByOwnOpenIdServiceImpl implements FindSellerByOwnOpenIdService {
    @Autowired
    private FindSellerByOwnOpenIdMapper findSellerByOwnOpenIdMapper;
    @Override
    public List<UserQueryVo> findSellerByOwnOpenIdMapper(int id) {
        List<UserQueryVo> sellerByOwnOpenIdMapper = findSellerByOwnOpenIdMapper.findSellerByOwnOpenIdMapper(id);
        return sellerByOwnOpenIdMapper;
    }
}

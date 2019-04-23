package com.example.khxcx.controller;

import com.example.khxcx.pojo.Likes;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.LikesService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: SualLabel
 * @Date: 2019-03-12 20:11
 * @Description: SualLabel, Write down some description!!!
 */

@Api(value = "LikesController")
@RestController
public class LikesController {
    @Autowired
    private LikesService likesService;
    @Autowired
    private UserService userService;
    @GetMapping("/getDianZanConntsByUserId.action")
    public SzpJsonResult getDianZanConntsByUserId(long userId,
                                                  HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        int countsByUserId = likesService.getCountsByUserId(userId);
        return SzpJsonResult.ok(countsByUserId);
    }
   @GetMapping("/insertLikesByThisWay.action")
    public SzpJsonResult insertLikesByThisWay(
                                                long userId,

                                              String openId,
                                                HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        Long id = userByOpenId.get(0).getId();
        List<Likes> likesBy = likesService.findLikesBy(userId, id);
        if (likesBy.size() != 0 && likesBy != null) {
            return SzpJsonResult.ok("");
        } else {

            Likes likes = new Likes();
            //点赞人
            likes.setDianzanId(id);
            //被点赞
            likes.setUserId(userId);
            likesService.insertLikes(likes);
            return SzpJsonResult.ok();
        }
    }
    @GetMapping("/insertLikes.action")
    public SzpJsonResult insertLikes(
            HttpServletRequest request,
            HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String beiDianZanOpenId = request.getParameter("beiDianZanOpenId");
        String dianZanOpenId = request.getParameter("dianZanOpenId");

        List<User> beiDianZanOpenIdUser = userService.findUserByOpenId(beiDianZanOpenId);
        List<User> dianZanOpenIdUser = userService.findUserByOpenId(dianZanOpenId);
        Long beiDianZanOpen = beiDianZanOpenIdUser.get(0).getId();
        Long dianZanOpen = dianZanOpenIdUser.get(0).getId();

        List<Likes> likesBy = likesService.findLikesBy(beiDianZanOpen, dianZanOpen);
        if (likesBy.size() != 0 && likesBy != null) {
            return SzpJsonResult.ok("");
        } else {

            Likes likes = new Likes();
            likes.setDianzanId(dianZanOpen);
            likes.setUserId(beiDianZanOpen);
            likesService.insertLikes(likes);
            return SzpJsonResult.ok();
        }
    }


    @ApiOperation("")
    @DeleteMapping("/deleteLikesById.action")
    public SzpJsonResult deleteLikesById(long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        likesService.deleteLikesById(id);
        return SzpJsonResult.ok();
    }

   @PostMapping("/updateLikesById.action")
    public SzpJsonResult updateLikesById(Likes likes, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        likesService.updateLikesById(likes);
        return SzpJsonResult.ok();
    }

    @GetMapping("/findLikesById.action")
    public SzpJsonResult findLikesById(long id, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Likes likesById = likesService.findLikesById(id);
        return SzpJsonResult.ok(likesById);
    }


    @GetMapping("/getCountsByUserId.action")
    public SzpJsonResult getCountsByUserId(String openId, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<User> userByOpenId = userService.findUserByOpenId(openId);
        long userId = userByOpenId.get(0).getId();
        int countsByUserId = likesService.getCountsByUserId(userId);
        return SzpJsonResult.ok(countsByUserId);
    }
}

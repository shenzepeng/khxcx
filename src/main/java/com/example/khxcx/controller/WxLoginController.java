package com.example.khxcx.controller;

import com.example.khxcx.model.WXSessionModel;
import com.example.khxcx.pojo.User;
import com.example.khxcx.pojo.UserIfo;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import com.example.khxcx.utils.HttpClientUtil;
import com.example.khxcx.utils.JsonUtils;
import com.example.khxcx.utils.SzpJsonResult;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小程序微信登录
 */
@Slf4j
@RestController
public class WxLoginController {

	
	@Autowired
	private UserService userService;

	@Autowired
	private UserIfoService userIfoService;
	@ApiOperation("微信登录接口")
	@PostMapping("/wxLogin")
	public SzpJsonResult wxLogin(String code) {
		System.out.println("wxlogin - code: " + code);
		log.debug("code",new Date()+"--codel->"+code);

		String url = "https://api.weixin.qq.com/sns/jscode2session";
		Map<String, String> param = new HashMap<>();
		//小程序id
		param.put("appid", "wxe5e476c440a56df3");
		//微信秘钥
		param.put("secret", "c21f05d89c84af53d1fc8675467b1bf7");
		param.put("js_code", code);
		//写死
		param.put("grant_type", "authorization_code");
		
		String wxResult = HttpClientUtil.doGet(url, param);
		System.out.println(wxResult);

		WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);
		String openid = model.getOpenid();
		log.debug("openid",new Date()+"--openid->"+openid);

		List<User> userByOpenId = 	userService.findUserByOpenId(openid);
		if (userByOpenId!=null&&userByOpenId.size()!=0){
			Map map=new HashMap();
			map.put("end","登录成功");
			map.put("openid",openid);
            return SzpJsonResult.ok(map);
		}else {
		    //没有该用户时直接在后台生成新的用户
			User user=new User();
			user.setOpenId(openid);
			//添加新用户
			userService.insertUser(user);
            List<User> userByOpenId1 = userService.findUserByOpenId(openid);
            User user1 = userByOpenId1.get(0);
            UserIfo userIfo=new UserIfo();
            userIfo.setShengyugoumailaing((double)100);
            userIfo.setUserId(user1.getId());
			//添加新的用户信息
            userIfoService.insertUserIfo(userIfo);
			Map map=new HashMap();
			map.put("end","登录成功,欢迎新用户");
			map.put("openid",openid);
			return SzpJsonResult.ok(map);
		}

	}
	
}

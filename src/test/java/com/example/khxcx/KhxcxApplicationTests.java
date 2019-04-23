package com.example.khxcx;

import com.example.khxcx.mapper.FindSellerByOwnOpenIdMapper;
import com.example.khxcx.mapper.InvestmentStatementMapper;
import com.example.khxcx.mapper.UserQueryVoMapper;
import com.example.khxcx.service.PayServiceImpl;
import com.example.khxcx.service.UserIfoService;
import com.example.khxcx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KhxcxApplicationTests {
    @Autowired
    private UserIfoService userIfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private PayServiceImpl pay;
    @Autowired
    private InvestmentStatementMapper mapper;
    @Test
    public void create() {
//        String s= KeyUtil.genUniqueKey();
//        PayResponse asdasd = pay.create("ogUmH5PUmBsw7k3FBWEPunbqBBvw", 0.1, s);
//        System.out.println(asdasd);
    }

    @Test
    public void refind() {
//        String s= KeyUtil.genUniqueKey();
//        RefundResponse refund = pay.refund(s, 0.1);
//        System.out.println(refund);
    }

    @Test
    public void wxLogin(){
//        String openid="ogUmH5AbHhTMKMCOou6YVhWx2a0w";
//        //没有该用户时直接在后台生成新的用户
//        User user=new User();
//        user.setOpenId(openid);
//        //添加新用户
//        userService.insertUser(user);
//        List<User> userByOpenId1 = userService.findUserByOpenId(openid);
//        User user1 = userByOpenId1.get(0);
//        UserIfo userIfo=new UserIfo();
//        userIfo.setUserId(user1.getId());
//        //添加新的用户信息
//        userIfoService.insertUserIfo(userIfo);
    }

//    @Test
//    public void setUserIfoService(){
//        List<UserIfo> userIfoByUserId = userIfoService.findUserIfoByUserId(10);
//        System.out.println(userIfoByUserId.get(0));
//    }
//    @Test
//    public void find(){
//        List<UserIfo> byZiDuan = userIfoService.findByZiDuan("葛明杰");
//        System.out.println(byZiDuan);
//    }
//    @Test
//    public void test1(){
//        InvestmentStatement investmentStatement=new InvestmentStatement();
//        investmentStatement.setId((long)10);
//        investmentStatement.setBlankSpaceOne("已卖出");
//        mapper.updateByPrimaryKeySelective(investmentStatement);
//    }
//    @Autowired
//    private UserQueryVoMapper userQueryVoMapper;
//    @Autowired
//    private FindShuiJunMapper findShuiJunMapper;
    @Autowired
    private UserQueryVoMapper userQueryVoMapper;
//    @Test
//    public void findAll(){
//////        List<UserQueryVo> allUserQueryVo = userQueryVoMapper.findAllUserQueryVo();
//////        System.out.println(allUserQueryVo);
////        List<ShunJunQuVo> allUserQueryVo = findShuiJunMapper.findAllUserQueryVo();
////        System.out.println(allUserQueryVo);
//        List<UserQueryVo> allUserQueryVo = userQueryVoMapper.findAllUserQueryVo();
//        for (UserQueryVo u:allUserQueryVo){
//            if (userService.findUserById(u.getUserId()).getBlankSpaceOne()!=null){
//                if (userService.findUserById(u.getUserId()).getBlankSpaceOne().equals("水军")){
//                    System.out.println(u);
//                }
//            }
//
//
//        }
//        System.out.println(allUserQueryVo);
//    }
    @Autowired
    private FindSellerByOwnOpenIdMapper findSellerByOwnOpenIdMapper;
    @Test
    public void findAll(){
//        List<UserQueryVo> sellerByOwnOpenIdMapper = findSellerByOwnOpenIdMapper.findSellerByOwnOpenIdMapper(10);
//        System.out.println(sellerByOwnOpenIdMapper);
    }
}

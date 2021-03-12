package com.study.studyplatform.controller;

import com.study.studyplatform.dao.SelectUserMapper;
import com.study.studyplatform.dao.UpdateUserMapper;
import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.pojo.User;
import com.study.studyplatform.service.UserService;
import com.study.studyplatform.utils.UuidCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//跨域问题解决方法
@CrossOrigin(origins = {"http://cccccjy.top","null", "http://localhost:8080", "null"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SelectUserMapper selectUserMapper;

    @Autowired
    private UserService userServiceImpl;

    /**
     * 注册接口
     * @param user
     * @return result
     */
    @GetMapping(value = "/regist")
    public Result regist(User user){
        user.setStatus(0);
        String code = UuidCode.getUUID()+UuidCode.getUUID();
        user.setCode(code);
        return userService.regist(user);
    }

    /**
     *校验邮箱中的code激活账户
     * 首先根据激活码code查询用户，之后再把状态修改为"1"
     */
    @GetMapping(value = "/checkCode")
    public String checkCode(String code){
        String sentence=null;
        User user = userService.checkCode(code);
        //如果用户不等于null，把用户状态修改status=1
        if (user !=null){
            user.setStatus(1);
            //把code验证码清空，已经不需要了
            //user.setCode("");
            userService.updateUserStatus(user);
            sentence="状态已激活！";
        }else{
            sentence="不存在该激活码的用户！";
        }
        return sentence;
    }

    /**
     *检查邮箱激活状态
     * @param userid
     * @return
     */
    @GetMapping(value = "/checkState")
    public Result checkStatus(String userid){
        Result result=new Result();
        int status=selectUserMapper.selectStatusById(userid);
        if(status==1){
            result.setSuccess(true);
            result.setMsg("状态已激活！");
        }else{
            result.setSuccess(false);
            result.setMsg("不存在该邮箱的用户！");
        }
        return result;
    }

    /**
     * 登录接口
     * @param user
     * @return
     */
    @GetMapping(value = "/login")
    public Result login(User user){
        return userService.login(user);
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @GetMapping(value = "/updateuserinfo")
    public Result updateUserInfo(User user){
        return userServiceImpl.updateUserInfo(user);
    }
}

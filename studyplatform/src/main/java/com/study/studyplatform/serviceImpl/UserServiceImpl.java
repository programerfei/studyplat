package com.study.studyplatform.serviceImpl;

import com.study.studyplatform.dao.InsertUserMapper;
import com.study.studyplatform.dao.SelectUserMapper;
import com.study.studyplatform.dao.UpdateUserMapper;
import com.study.studyplatform.pojo.Result;
import com.study.studyplatform.pojo.User;
import com.study.studyplatform.service.MailService;
import com.study.studyplatform.service.UserService;
import com.study.studyplatform.utils.UuidCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private InsertUserMapper insertMapper;
    @Autowired
    private SelectUserMapper selectMapper;
    @Autowired
    private UpdateUserMapper updateMapper;
    @Autowired
    private MailService mailService;


    /**
     * 用户注册，同时发送一封激活邮件
     * @param user
     * @return result,返回数据
     */
    @Override
    public Result regist(User user) {
        Result result=new Result();
        result.setSuccess(false);
        result.setMsg(null);
        result.setDetail(null);

        //生成用户id
        String userID= UuidCode.shortUuid();
        user.setUserid(userID);

        //注册之前判断是否存在邮箱，若存在邮箱号，判断改邮箱是否被激活
        User mailUser=selectMapper.selectUserByMail(user.getUsermail());
        if(mailUser!=null){
            //邮箱存在且没有激活，更新已有的用户信息 根据用户邮箱进行更新
            if(selectMapper.selectStatusById(mailUser.getUserid())==0){
                updateMapper.updateUserByMail(mailUser);
            }else{
                result.setMsg("该邮箱已经被注册，请使用其他邮箱进行注册！");
            }
        }else{
            insertMapper.insertRegist(user);
        }



        //获取激活码
        String code=user.getCode();
        //发送邮件主题
        String subject="来自学习平台网站的激活邮件";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
        String context = "<a href=\"http://127.0.0.1:8080/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendHtmlMail (user.getUsermail(),subject,context);
        result.setSuccess(true);
        result.setMsg("激活码已发送!");
        result.setDetail(user);
        return result;
    }



    /**
     * 根据激活码code进行查询用户，之后再进行修改状态
     * @param code
     * @return
     */
    @Override
    public User checkCode(String code) {
        return selectMapper.checkCode(code);
    }

    /**
     * 激活账户，修改用户状态
     * @param user
     */
    @Override
    public void updateUserStatus(User user) {
        updateMapper.updateUserStatus(user);
    }

    /**
     * 登录功能
     * @param user
     * @return result
     */
    @Override
    public Result login(User user) {
        Result result=new Result();
        result.setSuccess(false);
        result.setMsg(null);
        result.setDetail(null);

        //登录的时候必须status为1，且用户id（用户邮箱），用户密码正确
        String str=null;
        User tempUser=null;
        if(user.getUserid()==null){
            str=user.getUsermail();
            tempUser=selectMapper.selectUserByMail(str);
        }else{
            str=user.getUserid();
            tempUser=selectMapper.selectUserById(str);
        }
        //根据前端发送的数据，使用邮箱或用户id进行用户查询。
        if(tempUser==null){
            result.setMsg("该用户不存在，请检查用户id或邮箱！");
        }else{
            //判断密码
            //result.setDetail(tempUser);
            String pwd=selectMapper.selectPwdByUserid(tempUser.getUserid());
            if(!pwd.equals(user.getPassword())){
                result.setMsg("密码错误！");
            }else{
                //进一步判断用户邮箱是否为激活状态
                if(tempUser.getStatus()==1){
                    result.setMsg("登录成功！");
                    result.setDetail(tempUser);
                    result.setSuccess(true);
                }else {
                    result.setMsg("该用户的邮箱未激活，无法登录！");
                }
            }
        }
        return result;
    }

    /**
     * 修改用户信息
     * @param user 用户
     */
    @Override
    public Result updateUserInfo(User user) {
        Result result=new Result();
        updateMapper.updateUser(user);
        User tempUser=selectMapper.selectUserById(user.getUserid());
        result.setMsg("信息修改成功！");
        result.setSuccess(true);
        result.setDetail(tempUser);
        return result;
    }
}

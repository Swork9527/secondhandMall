package com.hzf.service.impl;

import com.hzf.entity.ResultInfo;
import com.hzf.entity.User;
import com.hzf.repository.UserDao;
import com.hzf.service.UserService;
import com.hzf.util.MailUtils;
import com.hzf.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public boolean registe(User user) {
        user.setStatus("N");
        user.setCode(UuidUtil.getUuid());
        userDao.register(user);
        String content="<a href='http://localhost:9090/user/active?code="+
                user.getCode()+"'>佛大二手交易网站</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean checkCode(String checkCode, User user) {
       if (checkCode!=null){
           if (checkCode.equalsIgnoreCase(user.getCheck())){
               return true;
           }else{
               return false;
           }
       }
       return false;
    }

    @Override
    public boolean findUsername(User user) {
        User username = userDao.findUsername(user.getUsername());
        if (username!=null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean active(String code) {
        User code1 = userDao.findCode(code);
        String status="Y";
        if (code!=null){
            userDao.active(status,code);
            return true;
        }else{
            return false;
        }
    }


    @Override
    public ResultInfo login(User user) {
        ResultInfo resultInfo=new ResultInfo();
        User loginUser = userDao.login(user);
        if (loginUser!=null){
            if ("Y".equals(loginUser.getStatus())){
                resultInfo.setData(loginUser);
                resultInfo.setFlag(true);
            }else{
                resultInfo.setErrorMsg("未激活");
            }
        }else{
            resultInfo.setErrorMsg("密码错误");
        }
        return resultInfo;
    }

    @Override
    public User findUserById(Integer uid) {
        User user = userDao.findUserById(uid);
        return user;
    }
}

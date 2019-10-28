package com.hzf.service;


import com.hzf.entity.ResultInfo;
import com.hzf.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    boolean registe(User user);
    boolean checkCode(String checkCode,User user);
    boolean findUsername(User user);
    boolean active(String code);
    ResultInfo login(User user);
    User findUserById(Integer uid);
}

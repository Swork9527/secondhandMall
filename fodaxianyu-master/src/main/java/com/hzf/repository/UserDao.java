package com.hzf.repository;

import com.hzf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public void register(User user);
    public User findUsername(String username);
    public void active(String status,String code);
    public User findCode(String code);
    public User login(User user);
    public User findUserById(Integer uid);
}

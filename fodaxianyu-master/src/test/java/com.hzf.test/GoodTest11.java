package com.hzf.test;

import com.hzf.Application;
import com.hzf.entity.Good;
import com.hzf.entity.GoodExample;
import com.hzf.repository.GoodMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class GoodTest11 {
    @Autowired
    private GoodMapper goodMapper;

    @Test
    public void findAll(){
        System.out.println("11111");
    }
}

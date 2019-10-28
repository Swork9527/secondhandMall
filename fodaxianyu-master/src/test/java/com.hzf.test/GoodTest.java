package com.hzf.test;

import com.hzf.entity.Good;
import com.hzf.entity.GoodExample;
import com.hzf.repository.GoodMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.List;



public class GoodTest {
    private InputStream in;
    private SqlSession sqlSession;
    private GoodMapper goodMapper;

    @Before//用于在测试方法执行之前执行
    public void init()throws Exception{
        //1.读取配置文件，生成字节输入流
        in = Resources.getResourceAsStream("application.yml");
        //2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.获取SqlSession对象
        sqlSession = factory.openSession(true);
        //4.获取dao的代理对象
        goodMapper = sqlSession.getMapper(GoodMapper.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy()throws Exception{
        //提交事务
        // sqlSession.commit();
        //6.释放资源
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll(){
        GoodExample example = new GoodExample();
        //example的内部类：criteria
        GoodExample.Criteria criteria = example.createCriteria();
//        按照id降序，就相当于优先显示最先发布的商品
        example.setOrderByClause("goodid desc");
        List<Good> list = goodMapper.selectByExample(example) ;
        Good good = null;
        for (int i=0;i<list.size();i++){
            System.out.println("-----------------");
            System.out.println(list.get(i));
        }
    }
}

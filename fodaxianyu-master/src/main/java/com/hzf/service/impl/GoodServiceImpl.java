package com.hzf.service.impl;

import com.hzf.entity.*;
import com.hzf.repository.GoodMapper;
import com.hzf.repository.GoodPictureMapper;
import com.hzf.repository.PicturesMapper;
import com.hzf.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService{
    @Autowired
    private GoodMapper goodMapper;
    @Autowired
    private PicturesMapper picturesMapper;
    @Autowired
    private GoodPictureMapper goodPictureMapper;

    @Override
    public List<Good> findAll(){
        GoodExample example = new GoodExample();
        //example的内部类：criteria
        GoodExample.Criteria criteria = example.createCriteria();
//        按照id降序，就相当于优先显示最先发布的商品
       // example.setOrderByClause("goodid desc");
//        只获取状态为0，即还在售的商品
      //  criteria.andStatusEqualTo(0);
        List<Good> list = goodMapper.selectByExample(example) ;
       // List<Good> list12=goodMapper.selectByExample();
         return list;
    }

    @Override
    public List<GoodPicture> findAllGoodPicture() {
        List<GoodPicture> list = goodPictureMapper.findAllGoodPicture();
        return list;
    }

    @Override
    public Good findGoodById(Integer goodid) {
        Good good =goodMapper.selectByPrimaryKey(goodid);
        return good;
    }

    @Override
    public List<Pictures> findPictureById(Integer goodid) {
        PicturesExample example = new PicturesExample();
        PicturesExample.Criteria criteria = example.createCriteria();
        criteria.andGoodidEqualTo(goodid);
        List<Pictures> list = picturesMapper.selectByExample(example);
        return list;
    }

    @Override
    public void saveGood(Good good) {
        goodMapper.insert(good);
    }

    @Override
    public void savePic(Pictures pictures) {
        picturesMapper.insert(pictures);
    }

    @Override
    public Integer findLastGood() {
        GoodExample example = new GoodExample();
        GoodExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("goodid desc");
        List<Good> list = goodMapper.selectByExample(example) ;

        return list.get(0).getGoodid();
    }


}

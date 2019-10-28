package com.hzf.service;

import com.hzf.entity.Good;
import com.hzf.entity.GoodPicture;
import com.hzf.entity.Pictures;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodService {
    List<Good> findAll();
    List<GoodPicture> findAllGoodPicture();
    Good findGoodById(Integer goodid);
    List<Pictures> findPictureById(Integer goodid);
    void saveGood(Good good);
    void savePic(Pictures pictures);
    Integer findLastGood();

}

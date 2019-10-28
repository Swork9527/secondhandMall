package com.hzf.repository;

import com.hzf.entity.GoodPicture;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodPictureMapper {
//    查找所有的商品以及图片信息
    List<GoodPicture> findAllGoodPicture();
}

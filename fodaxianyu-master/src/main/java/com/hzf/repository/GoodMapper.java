package com.hzf.repository;

import com.hzf.entity.Good;
import com.hzf.entity.GoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodMapper {
    int countByExample(GoodExample example);

    int deleteByExample(GoodExample example);

    int deleteByPrimaryKey(Integer goodid);

    int insert(Good record);

    int insertSelective(Good record);

    List<Good> selectByExample(GoodExample example);

    Good selectByPrimaryKey(Integer goodid);

    int updateByExampleSelective(@Param("record") Good record, @Param("example") GoodExample example);

    int updateByExample(@Param("record") Good record, @Param("example") GoodExample example);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}
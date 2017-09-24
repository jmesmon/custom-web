package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogNewsVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/25.
 */
@Mapper
@Repository
public interface IDogNewsDao {
    List<DogNewsVO> getList(@Param("vo") DogNewsVO dogWorkVO, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogNewsVO vo);

    void add(@Param("vo") DogNewsVO vo);
    void update(@Param("vo") DogNewsVO vo);
    void del(List<DogNewsVO> list);
}

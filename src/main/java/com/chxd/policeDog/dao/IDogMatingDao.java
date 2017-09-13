package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogMatingVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/13.
 */
@Mapper
@Repository
public interface IDogMatingDao {
    List<DogMatingVO> getList(@Param("vo") DogMatingVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogMatingVO vo);

    void add(List<DogMatingVO> list);
    void update(@Param("vo") DogMatingVO vo);
    void del(List<DogMatingVO> list);
}

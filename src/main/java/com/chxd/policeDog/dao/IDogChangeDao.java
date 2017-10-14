package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogChangeVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/10/14.
 */
@Mapper
@Repository
public interface IDogChangeDao {
    List<DogChangeVO> getList(@Param("vo") DogChangeVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogChangeVO vo);

    void add(List<DogChangeVO> list);
    void update(@Param("vo") DogChangeVO vo);
    void del(List<DogChangeVO> list);
}

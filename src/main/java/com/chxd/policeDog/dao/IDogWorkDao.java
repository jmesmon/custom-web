package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogWorkVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/15.
 */
@Mapper
@Repository
public interface IDogWorkDao {
    List<DogWorkVO> getList(@Param("vo") DogWorkVO dogWorkVO, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogWorkVO vo);

    void add(List<DogWorkVO> list);
    void update(@Param("vo") DogWorkVO vo);
    void del(List<DogWorkVO> list);
}

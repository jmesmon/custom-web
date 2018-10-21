package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogAllotListVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IDogAllotListDao {
    List<DogAllotListVO> getList(@Param("vo") DogAllotListVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogAllotListVO vo);

    void add(@Param("item")DogAllotListVO dogAllotListVO);
    void update(@Param("vo") DogAllotListVO vo);
    void del(List<DogAllotListVO> list);
}

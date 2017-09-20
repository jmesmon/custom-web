package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogProVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/3.
 */
@Mapper
@Repository
public interface IProfessionDao {
    List<DogProVO> getList(@Param("vo") DogProVO dogProVO, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogProVO dogProVO);

    void add(List<DogProVO> list);
    void update(@Param("vo") DogProVO vo);
    void del(List<DogProVO> list);
}

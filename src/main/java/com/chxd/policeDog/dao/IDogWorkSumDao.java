package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogWorkSumVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/9/13.
 */
@Mapper
@Repository
public interface IDogWorkSumDao {
    List<DogWorkSumVO> getList(@Param("vo") DogWorkSumVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogWorkSumVO vo);

    void add(List<DogWorkSumVO> list);
    void update(@Param("vo") DogWorkSumVO vo);
    void del(List<DogWorkSumVO> list);

    List<Map> getWorkSumAnlysis(@Param("vo") DogWorkSumVO vo);
}

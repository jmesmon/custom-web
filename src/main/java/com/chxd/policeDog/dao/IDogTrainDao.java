package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogTrainVO;
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
public interface IDogTrainDao {
    List<DogTrainVO> getList(@Param("vo") DogTrainVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") DogTrainVO vo);

    void add(List<DogTrainVO> list);
    void update(@Param("vo") DogTrainVO vo);
    void del(List<DogTrainVO> list);
}

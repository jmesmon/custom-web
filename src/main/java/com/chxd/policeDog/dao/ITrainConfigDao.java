package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.TrainConfigVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/3.
 */
@Mapper
@Repository
public interface ITrainConfigDao {
    List<TrainConfigVO> getList(@Param("vo") TrainConfigVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") TrainConfigVO vo);

    void add(List<TrainConfigVO> list);
    void update(@Param("vo") TrainConfigVO vo);
    void del(List<TrainConfigVO> list);
}

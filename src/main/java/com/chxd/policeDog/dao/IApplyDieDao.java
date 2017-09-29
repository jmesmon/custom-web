package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.ApplyDieVO;
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
public interface IApplyDieDao {
    List<ApplyDieVO> getList(@Param("vo") ApplyDieVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") ApplyDieVO vo);

    void add(List<ApplyDieVO> list);
    void update(@Param("vo") ApplyDieVO vo);
    void del(List<ApplyDieVO> list);
}

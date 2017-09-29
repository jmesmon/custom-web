package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.ApplyTickoutVO;
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
public interface IApplyTickoutDao {
    List<ApplyTickoutVO> getList(@Param("vo") ApplyTickoutVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") ApplyTickoutVO vo);

    void add(List<ApplyTickoutVO> list);
    void update(@Param("vo") ApplyTickoutVO vo);
    void del(List<ApplyTickoutVO> list);
}

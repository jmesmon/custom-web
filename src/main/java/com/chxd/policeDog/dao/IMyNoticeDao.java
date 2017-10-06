package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.MyNoticeVO;
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
public interface IMyNoticeDao {
    List<MyNoticeVO> getList(@Param("vo") MyNoticeVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") MyNoticeVO vo);

    void add(List<MyNoticeVO> list);
    void update(@Param("vo") MyNoticeVO vo);
    void del(List<MyNoticeVO> list);
}

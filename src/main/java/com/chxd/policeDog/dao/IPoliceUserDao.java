package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.PoliceUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/25.
 */
@Mapper
@Repository
public interface IPoliceUserDao {
    List<PoliceUserVO> getList(@Param("vo") PoliceUserVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") PoliceUserVO vo);

    void add(@Param("vo") PoliceUserVO list);
    void update(@Param("vo") PoliceUserVO vo);
    void del(List<PoliceUserVO> list);
    int isExist(@Param("userName") String userName);
}

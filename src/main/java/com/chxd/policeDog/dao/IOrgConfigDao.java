package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.OrgConfigVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/10/3.
 */
@Mapper
@Repository
public interface IOrgConfigDao {
    List<OrgConfigVO> getList(@Param("vo") OrgConfigVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") OrgConfigVO vo);

    void add(List<OrgConfigVO> list);
    void update(@Param("vo") OrgConfigVO vo);
    void del(List<OrgConfigVO> list);
}

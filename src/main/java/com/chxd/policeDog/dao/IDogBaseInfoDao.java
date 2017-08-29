package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogBaseInfoVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/8/27.
 */
@Mapper
@Repository
public interface IDogBaseInfoDao {
    public List<DogBaseInfoVO> selectAll(@Param("dogInfo") DogBaseInfoVO dogInfo, @Param("page") PageVO page);

    public Integer selectAllCount();
}

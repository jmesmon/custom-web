package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogBaseInfoVO;
import com.chxd.policeDog.vo.DogImmueVO;
import com.chxd.policeDog.vo.DogWormVO;
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

    public Integer selectAllCount(@Param("dogInfo") DogBaseInfoVO dogInfo);

    public void add(List<DogBaseInfoVO> list);

    public void addWorm(List<DogWormVO> list);
    public void addImmue(List<DogImmueVO> list);

    public void tickOut(@Param("list") List<DogBaseInfoVO> list, @Param("belong") String belong);
    public void died(List<DogBaseInfoVO> list);

    List<DogBaseInfoVO> search(String chipNo);

    List<DogBaseInfoVO> getListByWorkUnit(@Param("workUnit") String workUnit);
}

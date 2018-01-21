package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/8/27.
 */
@Mapper
@Repository
public interface IDogBaseInfoDao {
    public List<DogBaseInfoVO> selectAll(@Param("dogInfo") DogBaseInfoVO dogInfo, @Param("page") PageVO page);


    public List<DogBaseInfoVO> getTrainList(@Param("dogInfo") DogBaseInfoVO dogInfo, @Param("page") PageVO page);

    public Integer selectAllCount(@Param("dogInfo") DogBaseInfoVO dogInfo);

    public void add(List<DogBaseInfoVO> list);

    public void addWorm(List<DogWormVO> list);
    public void addImmue(List<DogImmueVO> list);

    public void tickOut(@Param("list") List<DogBaseInfoVO> list, @Param("belong") String belong);
    public void died(List<DogBaseInfoVO> list);

    List<DogBaseInfoVO> search(String chipNo);

    List<DogBaseInfoVO> getListByWorkUnit(@Param("workUnit") String workUnit);

    void update(@Param("dogInfo") DogBaseInfoVO dogInfo);

    void allot(@Param("list") List<DogBaseInfoVO> list, @Param("workUnit") String workUnit);

    List<Map> getAnalysisData(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("workUnit") String workUnit);

    List<Map> getWorkData(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("workUnit") String workUnit, @Param("workState") String workState);

    List<Map> getOrgCount(@Param("lastMonth") String lastMonth, @Param("nowMonth") String nowMonth);

    List<Map> getDogPro(@Param("list") List<DogBaseInfoVO> list);

    void changePoliceUser(@Param("dogInfo") DogBaseInfoVO dogInfo);

    List<PoliceUserVO> getAdminByTrainId(@Param("trainId") int trainId);

    List<Map> getWorkData4Export(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("workUnit") String workUnit);
}

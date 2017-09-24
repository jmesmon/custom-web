package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.ApplyDogVO;
import com.chxd.policeDog.vo.PageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/9/24.
 */
@Mapper
@Repository
public interface IApplyDogDao {
    List<ApplyDogVO> getList(@Param("vo") ApplyDogVO vo, @Param("page") PageVO page);
    Integer getListCount(@Param("vo") ApplyDogVO vo);

    void add(@Param("item") ApplyDogVO vo);
    void update(@Param("vo") ApplyDogVO vo);
    void del(List<ApplyDogVO> list);
}

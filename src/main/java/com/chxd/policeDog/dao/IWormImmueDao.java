package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.WormImmueCfgVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by cheng on 2017/8/30.
 */
@Mapper
@Repository
public interface IWormImmueDao {
    List<WormImmueCfgVO> getWormImmueCfgVO(@Param("vo") WormImmueCfgVO vo);
}

package com.chxd.policeDog.dao;

import com.chxd.policeDog.vo.DogImmueVO;
import com.chxd.policeDog.vo.DogWormVO;
import com.chxd.policeDog.vo.PageVO;
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

    void finishWorm(DogWormVO vo);
    void finishImmue(DogImmueVO vo);

    void addWorm(DogWormVO vo);
    void addImmue(DogImmueVO vo);

    void delWorm(List<DogWormVO> list);
    void delImmue(List<DogImmueVO> list);

    List<DogWormVO> getWormList(@Param("wormVO")DogWormVO wormVO, @Param("page")PageVO page);
    Integer getWormCount(@Param("wormVO")DogWormVO wormVO);

    List<DogImmueVO> getImmueList(@Param("immueVO")DogImmueVO immueVO, @Param("page")PageVO page);
    Integer getImmueCount(@Param("immueVO")DogImmueVO immueVO);

    void updateImmueState(@Param("immueVO")DogImmueVO dogImmueVO);
    void updateWormState(@Param("wormVO")DogWormVO dogWormVO);
}

package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IWormImmueDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Lists;
import com.xjj.util.XDateUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by cheng on 2017/8/27.
 */
@RestController
@RequestMapping("/dogBaseInfo")
public class DogBaseInfoController {
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;
    @Autowired
    private IWormImmueDao wormImmueDao;

    @RequestMapping("/getAll/{pageSize}/{curPage}")
    public PageResultVO getAll(@RequestBody DogBaseInfoVO dogBaseInfoVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, pageVO);
        Integer integer = dogBaseInfoDao.selectAllCount(dogBaseInfoVO);

        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        try {
//            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("/get")
    public ResultVO getDog(@RequestBody DogBaseInfoVO dogBaseInfoVO) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, new PageVO());
            resultVO.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @RequestMapping("/addDog")
    public ResultVO addDogs(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        dogBaseInfoDao.add(dogList);
        return resultVO;
    }

    @RequestMapping("/initWormInfo/{nestNo}")
    public ResultVO initWormInfo(@PathVariable("nestNo") String nestNo) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            if (Strings.isEmpty(nestNo)) {
                resultVO.setSuccess(false);
                return resultVO;
            }
            DogBaseInfoVO dogQuery = new DogBaseInfoVO();
            dogQuery.setNestNo(nestNo);
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogQuery, PageVO.getInstance().setPageSze(1000));

            List<DogWormVO> data = Lists.newArrayList();

            List<WormImmueCfgVO> wormList = wormImmueDao.getWormImmueCfgVO(WormImmueCfgVO.getInstance().setPeriodType(WormImmueCfgVO.WORM_PERIOD));

            for (int i = 0; i < list.size(); i++) {
                DogBaseInfoVO dog = list.get(i);
                for (int j = 0; j < wormList.size(); j++) {
                    DogWormVO worm = new DogWormVO();
                    WormImmueCfgVO cfg = wormList.get(j);

                    LocalDate localDate = XDateUtils.dateToLocalDate(dog.getBirthday());
                    localDate = localDate.plusDays(cfg.getPeriod());

                    worm.setNestNo(nestNo);
                    worm.setDogId(dog.getId());
                    worm.setWormState(1);
                    worm.setWormDesc(cfg.getDescription());
                    worm.setWormDate(XDateUtils.localDateToDate(localDate));
                    data.add(worm);
                }
            }

            dogBaseInfoDao.addWorm(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }

    @RequestMapping("/initImmueInfo/{nestNo}")
    public ResultVO initImmueInfo(@PathVariable("nestNo") String nestNo) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            if (Strings.isEmpty(nestNo)) {
                resultVO.setSuccess(false);
                return resultVO;
            }
            DogBaseInfoVO dogQuery = new DogBaseInfoVO();
            dogQuery.setNestNo(nestNo);
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogQuery, PageVO.getInstance().setPageSze(1000));

            List<DogImmueVO> data = Lists.newArrayList();

            List<WormImmueCfgVO> wormList = wormImmueDao.getWormImmueCfgVO(WormImmueCfgVO.getInstance().setPeriodType(WormImmueCfgVO.IMMUE_PERIOD));

            for (int i = 0; i < list.size(); i++) {
                DogBaseInfoVO dog = list.get(i);
                for (int j = 0; j < wormList.size(); j++) {
                    DogImmueVO vo = new DogImmueVO();
                    WormImmueCfgVO cfg = wormList.get(j);

                    LocalDate localDate = XDateUtils.dateToLocalDate(dog.getBirthday());
                    localDate = localDate.plusDays(cfg.getPeriod());

                    vo.setNestNo(nestNo);
                    vo.setDogId(dog.getId());
                    vo.setImmueState(1);
                    vo.setImmueDate(XDateUtils.localDateToDate(localDate));
                    vo.setImmueName(cfg.getDescription());
                    data.add(vo);
                }
            }

            dogBaseInfoDao.addImmue(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }

    @RequestMapping("/tickout")
    public ResultVO doTickOut(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            dogBaseInfoDao.tickOut(dogList, dogList.get(0).getBelonging());
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/died")
    public ResultVO doDied(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            dogBaseInfoDao.died(dogList);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
}

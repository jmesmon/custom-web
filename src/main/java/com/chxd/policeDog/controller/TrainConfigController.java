package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.ITrainConfigDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by cheng on 2017/9/3.
 */
@RestController
@RequestMapping("/train/setting")
public class TrainConfigController {
    @Autowired
    private ITrainConfigDao trainConfigDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody TrainConfigVO dogTrainVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<TrainConfigVO> list = trainConfigDao.getList(dogTrainVO, pageVO);
        Integer integer = trainConfigDao.getListCount(dogTrainVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody TrainConfigVO trainConfigVO){
        ResultVO resultVO = ResultVO.getInstance();
        List<TrainConfigVO> list = Lists.newArrayList();
        list.add(trainConfigVO);
        trainConfigDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<TrainConfigVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        trainConfigDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody TrainConfigVO dogTrainVO){
        ResultVO resultVO = ResultVO.getInstance();
        trainConfigDao.update(dogTrainVO);
        return resultVO;
    }
}

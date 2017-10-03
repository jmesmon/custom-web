package com.chxd.policeDog.controller;

import com.alibaba.fastjson.JSON;
import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogWorkDao;
import com.chxd.policeDog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by cheng on 2017/9/16.
 */
@RestController
@RequestMapping("/work")
public class DogWorkController {
    @Autowired
    private IDogWorkDao dogWorkDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogWorkVO dogWorkVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogWorkVO> list = dogWorkDao.getList(dogWorkVO, pageVO);
        Integer integer = dogWorkDao.getListCount(dogWorkVO);
        for(int i = 0; i< list.size(); i++){
            DogWorkVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setChipNo(dp.getDogChipNo());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }


    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<DogWorkVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        System.out.println(JSON.toJSONString(list));
        dogWorkDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogWorkVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogWorkDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogWorkVO dogWorkVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogWorkDao.update(dogWorkVO);
        return resultVO;
    }
}

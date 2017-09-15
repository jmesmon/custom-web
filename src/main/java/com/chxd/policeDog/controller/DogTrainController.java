package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogTrainDao;
import com.chxd.policeDog.vo.*;
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
@RequestMapping("/train")
public class DogTrainController {
    @Autowired
    private IDogTrainDao dogTrainDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getById/{id}")
    public ResultVO getById(@PathParam("id") int id){
        ResultVO resultVO = ResultVO.getInstance();
        DogTrainVO vo = new DogTrainVO();
        vo.setId(id);
        List<DogTrainVO> list = dogTrainDao.getList(vo, PageVO.getInstance().setPageSze(1));
        if(list.size() > 0){
            resultVO.setResult(list.get(0));
        }else{
            resultVO.fail("没有找到");
        }
        return resultVO;
    }

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogTrainVO dogTrainVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogTrainVO> list = dogTrainDao.getList(dogTrainVO, pageVO);
        Integer integer = dogTrainDao.getListCount(dogTrainVO);
        for(int i = 0; i< list.size(); i++){
            DogTrainVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
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
    public ResultVO add(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogTrainDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogTrainDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogTrainVO dogTrainVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogTrainDao.update(dogTrainVO);
        return resultVO;
    }
}
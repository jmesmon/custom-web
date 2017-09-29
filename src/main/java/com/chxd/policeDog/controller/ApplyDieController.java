package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IApplyDieDao;
import com.chxd.policeDog.dao.IDogBaseInfoDao;
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
@RequestMapping("/apply/die")
public class ApplyDieController {
    @Autowired
    private IApplyDieDao applyDieDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody ApplyDieVO applyDieVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<ApplyDieVO> list = applyDieDao.getList(applyDieVO, pageVO);
        for(int i = 0; i< list.size(); i++){
            ApplyDieVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        Integer integer = applyDieDao.getListCount(applyDieVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<ApplyDieVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        applyDieDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<ApplyDieVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        applyDieDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody List<ApplyDieVO> list){
        ResultVO resultVO = ResultVO.getInstance();

        List<DogBaseInfoVO> dogList = Lists.newArrayList();
        for(int i = 0; i<list.size(); i++){
            ApplyDieVO vo = list.get(i);
            applyDieDao.update(list.get(i));
            if( vo.getApplyState() == 2){
                //审批通过，修改警犬基本信息
                DogBaseInfoVO dog = new DogBaseInfoVO();
                if(vo.getId() == null) continue;;
                dog.setId(vo.getDogId());
                dog.setWorkStage(4);
                dogList.add(dog);
            }
        }
        if(dogList.size() > 0){
            dogBaseInfoDao.died(dogList);
        }
        return resultVO;
    }
}

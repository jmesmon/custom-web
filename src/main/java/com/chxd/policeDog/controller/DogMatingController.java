package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogMatingDao;
import com.chxd.policeDog.vo.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by cheng on 2017/9/13.
 */
@RestController
@RequestMapping("/dogMating")
public class DogMatingController {
    @Autowired
    private IDogMatingDao dogMatingDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogMatingVO dogMatingVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogMatingVO> list = dogMatingDao.getList(dogMatingVO, pageVO);
        Integer integer = dogMatingDao.getListCount(dogMatingVO);
        for(int i = 0; i< list.size(); i++){
            DogMatingVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            if(Strings.isNotBlank(dp.getFatherDogChipNo())) {
                dogInfo.setChipNo(dp.getFatherDogChipNo());
                List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
                if (dog.size() > 0) {
                    dp.setFatherDogInfo(dog.get(0));
                }
            }else{
                dp.setFatherDogInfo(new DogBaseInfoVO());
            }

            if(Strings.isNotBlank(dp.getMotherDogChipNo())) {
                dogInfo.setChipNo(dp.getMotherDogChipNo());
                List<DogBaseInfoVO> dog2 = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
                if (dog2.size() > 0) {
                    dp.setMotherDogInfo(dog2.get(0));
                }
            }else{
                dp.setMotherDogInfo(new DogBaseInfoVO());
            }
        }
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<DogMatingVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogMatingDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogMatingVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogMatingDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogMatingVO dogMatingVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogMatingDao.update(dogMatingVO);
        return resultVO;
    }
}

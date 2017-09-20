package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IProfessionDao;
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
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    private IProfessionDao professionDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogProVO dogProVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogProVO> list = professionDao.getList(dogProVO, pageVO);
        for(int i = 0; i< list.size(); i++){
            DogProVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        Integer integer = professionDao.getListCount(dogProVO);

        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<DogProVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        professionDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogProVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        professionDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogProVO dogProVO){
        ResultVO resultVO = ResultVO.getInstance();
        professionDao.update(dogProVO);
        return resultVO;
    }
}

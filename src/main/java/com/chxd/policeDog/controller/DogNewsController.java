package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogNewsDao;
import com.chxd.policeDog.vo.DogNewsVO;
import com.chxd.policeDog.vo.PageResultVO;
import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.ResultVO;
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
@RequestMapping("/news")
public class DogNewsController {
    @Autowired
    private IDogNewsDao dogNewsDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogNewsVO dogNewsVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogNewsVO> list = dogNewsDao.getList(dogNewsVO, pageVO);
        for(int i = 0; i<list.size(); i++){
            list.get(i).setContent(null);
        }
        Integer integer = dogNewsDao.getListCount(dogNewsVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody DogNewsVO dogNewsVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogNewsDao.add(dogNewsVO);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogNewsVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogNewsDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogNewsVO dogNewsVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogNewsDao.update(dogNewsVO);
        return resultVO;
    }
}

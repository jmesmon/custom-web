package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.vo.DogBaseInfoVO;
import com.chxd.policeDog.vo.PageResultVO;
import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cheng on 2017/8/27.
 */
@RestController
@RequestMapping("/dogBaseInfo")
public class DogBaseInfoController {
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getAll/{pageSize}/{curPage}")
    public PageResultVO getAll(@RequestBody DogBaseInfoVO dogBaseInfoVO, PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO,  pageVO);
        Integer integer = dogBaseInfoDao.selectAllCount();
        PageVO p = new PageVO();
        p.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(p);
        try {
//            TimeUnit.SECONDS.sleep(2);
        }catch(Exception e){
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("/get")
    public ResultVO getDog(@RequestBody DogBaseInfoVO dogBaseInfoVO){
        ResultVO resultVO = ResultVO.getInstance();

        return resultVO;
    }
}

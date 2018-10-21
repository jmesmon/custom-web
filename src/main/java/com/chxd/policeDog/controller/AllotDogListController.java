package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogAllotListDao;
import com.chxd.policeDog.vo.DogAllotListVO;
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
 * Created by cheng on 2017/9/24.
 */
@RestController
@RequestMapping("/alot/list")
public class AllotDogListController extends BaseController {
    @Autowired
    private IDogAllotListDao dogAllotListDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogAllotListVO dogAllotListVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogAllotListVO> list = dogAllotListDao.getList(dogAllotListVO, pageVO);
        Integer integer = dogAllotListDao.getListCount(dogAllotListVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody DogAllotListVO dogAllotListVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogAllotListDao.add(dogAllotListVO);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogAllotListVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogAllotListDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody DogAllotListVO allotListVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogAllotListDao.update(allotListVO);
        return resultVO;
    }
}

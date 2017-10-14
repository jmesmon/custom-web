package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IMyNoticeDao;
import com.chxd.policeDog.vo.MyNoticeVO;
import com.chxd.policeDog.vo.PageResultVO;
import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.ResultVO;
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
@RequestMapping("/notice")
public class MyNoticeController {
    @Autowired
    private IMyNoticeDao noticeDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody MyNoticeVO noticeVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<MyNoticeVO> list = noticeDao.getList(noticeVO, pageVO);
        Integer integer = noticeDao.getListCount(noticeVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/addBatch")
    public ResultVO addBatch(@RequestBody List<MyNoticeVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        noticeDao.addBatch(list);
        return resultVO;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody MyNoticeVO noticeVO){
        ResultVO resultVO = ResultVO.getInstance();
        List<MyNoticeVO> list = Lists.newArrayList();
        list.add(noticeVO);
        noticeDao.addBatch(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<MyNoticeVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        noticeDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody MyNoticeVO noticeVO){
        ResultVO resultVO = ResultVO.getInstance();
        noticeDao.update(noticeVO);
        return resultVO;
    }

}

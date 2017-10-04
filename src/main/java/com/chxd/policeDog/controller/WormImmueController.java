package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IWormImmueDao;
import com.chxd.policeDog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by cheng on 2017/8/31.
 */
@RestController
@RequestMapping("/wormImmue")
public class WormImmueController {
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;
    @Autowired
    private IWormImmueDao wormImmueDao;


    @RequestMapping("/list/worm/{pageSize}/{curPage}")
    public PageResultVO getWormList(@RequestBody DogWormVO dogWormVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        try {
            List<DogWormVO> list = wormImmueDao.getWormList(dogWormVO, pageVO);
            Integer integer = wormImmueDao.getWormCount(dogWormVO);
            for(int i = 0; i<list.size(); i++){
                DogWormVO w = list.get(i);
                List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(new DogBaseInfoVO(w.getDogChipNo()), PageVO.getInstance());
                if(dog.size() > 0) {
                    w.setDogInfo(dog.get(0));
                }
            }

            pageVO.setTotalRows(integer);
            page.setResult(list);
            page.setPageVO(pageVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("/list/immue/{pageSize}/{curPage}")
    public PageResultVO getImmueList(@RequestBody DogImmueVO dogImmueVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        try {
            List<DogImmueVO> list = wormImmueDao.getImmueList(dogImmueVO, pageVO);
            Integer integer = wormImmueDao.getImmueCount(dogImmueVO);
            for(int i = 0; i<list.size(); i++){
                DogImmueVO w = list.get(i);
                List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(new DogBaseInfoVO(w.getDogChipNo()), PageVO.getInstance());
                if(dog.size() > 0) {
                    w.setDogInfo(dog.get(0));
                }
            }

            pageVO.setTotalRows(integer);
            page.setResult(list);
            page.setPageVO(pageVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }

    @RequestMapping("/finishWorm")
    public ResultVO finishWorm(@RequestBody List<DogWormVO> list) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            for(int i = 0; i<list.size(); i++){
                wormImmueDao.finishWorm(list.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }


    @RequestMapping("/finishImmue")
    public ResultVO finishImmue(@RequestBody List<DogImmueVO> list) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            for(int i = 0; i<list.size(); i++){
                wormImmueDao.finishImmue(list.get(i));
            }
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/addWorm")
    public ResultVO finishWorm(@RequestBody DogWormVO wormVO) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            wormImmueDao.addWorm(wormVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/addImmue")
    public ResultVO addImmue(@RequestBody DogImmueVO immueVO) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            wormImmueDao.addImmue(immueVO);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/delWorm")
    public ResultVO delWorm(@RequestBody List<DogWormVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        wormImmueDao.delWorm(list);
        return resultVO;
    }

    @RequestMapping("/delImmue")
    public ResultVO delImmue(@RequestBody List<DogImmueVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        wormImmueDao.delImmue(list);
        return resultVO;
    }

    @RequestMapping("/updateImmueState")
    public ResultVO updateImmueState(@RequestBody DogImmueVO dogImmueVO){
        ResultVO resultVO = ResultVO.getInstance();
        wormImmueDao.updateImmueState(dogImmueVO);
        return resultVO;
    }

    @RequestMapping("/updateWormState")
    public ResultVO updateWormState(@RequestBody DogWormVO dogWormVO){
        ResultVO resultVO = ResultVO.getInstance();
        wormImmueDao.updateWormState(dogWormVO);
        return resultVO;
    }
}

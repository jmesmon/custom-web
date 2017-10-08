package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogNewsDao;
import com.chxd.policeDog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by cheng on 2017/9/3.
 */
@RestController
@RequestMapping("/news")
public class DogNewsController extends BaseController {
    @Autowired
    private IDogNewsDao dogNewsDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getById")
    public ResultVO getById(@RequestBody DogNewsVO dogNewsVO){
        ResultVO resultVO = ResultVO.getInstance();
        List<DogNewsVO> list = dogNewsDao.getList(dogNewsVO, PageVO.getInstance());
        if(list != null && list.size() > 0){
            DogNewsVO dog = list.get(0);
            try {
                dog.setContent(new String(dog.getContent().getBytes("ISO-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            resultVO.setResult(list.get(0));
        }else{
            resultVO.fail("no data");
        }
        return resultVO;
    }

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogNewsVO dogNewsVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();

        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();

        if(UserRoleVO.NORMAL_USER.equals(role)){
            //普通用户
            dogNewsVO.setWorkUnit(user.getWorkUnit());
        }else if(UserRoleVO.GLY_USER.equals(role) || UserRoleVO.FJ_JZ_USER.equals(role) ){
            //管理员用户
            dogNewsVO.setWorkUnit(user.getWorkUnit());
        }else if(UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)){

        }else{
            dogNewsVO.setWorkUnit(user.getWorkUnit());
        }
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

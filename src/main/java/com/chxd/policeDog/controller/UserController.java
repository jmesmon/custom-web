package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IPoliceUserDao;
import com.chxd.policeDog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/9/25.
 */
@RestController
@RequestMapping("/user")
public class UserController extends  BaseController{
    @Autowired
    private IPoliceUserDao policeUserDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/login")
    public ResultVO login(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> map){
        PoliceUserVO policeUserVO = new PoliceUserVO();
        policeUserVO.setPoliceId(map.get("policeId"));
        policeUserVO.setPassword(map.get("password"));

        ResultVO resultVO = ResultVO.getInstance();
        try{
            List<PoliceUserVO> list = policeUserDao.getList(policeUserVO, new PageVO());
            if(list.size() > 0){
                PoliceUserVO user = list.get(0);
                resultVO.setResult(user.clone());
                user.setPassword(null);
                setUserInfo(user);
                setUser(user);
            }else{
                resultVO.fail("0");
            }
        }catch(Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/base")
    public ResultVO base(){
        ResultVO resultVO = ResultVO.getInstance();

        try {
            PoliceUserVO currentUser = getCurrentUser();
            if(currentUser != null){
                resultVO.setResult(currentUser);
            }else{
                resultVO.fail();
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    private void setUserInfo(PoliceUserVO user){

        if (UserRoleVO.NORMAL_USER.equals(user.getUserRole())) {
            //普通用户
            DogBaseInfoVO dog = new DogBaseInfoVO();
            dog.setPoliceId(user.getPoliceId());
            List<DogBaseInfoVO> dogList = dogBaseInfoDao.selectAll(dog, new PageVO());
            user.setDogList(dogList);

        } else if (UserRoleVO.JZ_USER.equals(user.getUserRole())) {
            //分局局长
            List<DogBaseInfoVO> dogList = dogBaseInfoDao.getListByWorkUnit(user.getWorkUnit());
            user.setDogList(dogList);

        } else if (UserRoleVO.JZD_USER.equals(user.getUserRole())) {
            //九支队
        } else if (UserRoleVO.GLY_USER.equals(user.getUserRole())) {
            //管理员
        } else if (UserRoleVO.FZRY_USER.equals(user.getUserRole())) {
            //繁殖人员
        } else if (UserRoleVO.PXRY_USER.equals(user.getUserRole())) {
            //培训人员
        } else if (UserRoleVO.SUPER_USER.equals(user.getUserRole())) {
            //超级管理员
        }
    }

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody PoliceUserVO policeUserVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        PoliceUserVO currentUser = getCurrentUser();
        if( UserRoleVO.JZ_USER.equals(currentUser.getUserRole())){
            policeUserVO.setWorkUnit(currentUser.getWorkUnit());
        }else if( UserRoleVO.NORMAL_USER.equals(currentUser.getUserRole()) ){
            policeUserVO.setPoliceId(currentUser.getPoliceId());
        }else if( UserRoleVO.GLY_USER.equals(currentUser.getUserRole())){
            policeUserVO.setWorkUnit(currentUser.getWorkUnit());
        }
        List<PoliceUserVO> list = policeUserDao.getList(policeUserVO, pageVO);
        for(int i = 0; i<list.size(); i++){
            list.get(i).setPassword(null);
        }
        Integer integer = policeUserDao.getListCount(policeUserVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
        policeUserDao.add(policeUserVO);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<PoliceUserVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        policeUserDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
        policeUserDao.update(policeUserVO);
        return resultVO;
    }
}

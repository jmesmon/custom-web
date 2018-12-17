package com.chxd.policeDog.controller;

import com.chxd.policeDog.config.MyProps;
import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IPoliceUserDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Maps;
import org.apache.logging.log4j.util.Strings;
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
    @Autowired
    private MyProps myProps;

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
                if(UserRoleVO.JZ_USER.equals(user.getUserRole()) || UserRoleVO.JZD_USER.equals(user.getUserRole())){
                    user.setWorkUnit(null);
                }
                session.setAttribute("USER_PWD", user.getPassword());
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

    @RequestMapping("/chgPwd")
    public ResultVO chgPwd(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
        String pwd = (String)session.getAttribute("USER_PWD");
        if(pwd.equals(policeUserVO.getPassword())){
            policeUserVO.setPassword(policeUserVO.getPasswordNew());
            policeUserVO.setId(getCurrentUser().getId());
            if(policeUserVO.getId() != null) {
                policeUserDao.update(policeUserVO);
                resultVO.setMessage("密码修改成功，下次登录生效");
                session.setAttribute("USER_PWD", policeUserVO.getPassword());
            }else{
                resultVO.fail("无法获取当前用户，请重新登录");
            }
        }else{
            resultVO.fail("旧密码输入不正确，请重新输入");
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

    @RequestMapping("/isExist")
    public ResultVO isExist(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
//        if(getCurrentUser().getPoliceId().equals(policeUserVO.getPoliceId())){
//            return resultVO;
//        }
        try {
            int count = policeUserDao.isExist(policeUserVO.getPoliceId());
            resultVO.setSuccess(true);
            if(count > 0){
                resultVO.setSuccess(false);
            }else {
                resultVO.setResult(count);
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
        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();
        if(UserRoleVO.NORMAL_USER.equals(role)){
            //普通用户
            policeUserVO.setId(user.getId());
        }else if(UserRoleVO.GLY_USER.equals(role) || UserRoleVO.FJ_JZ_USER.equals(role) ){
            //管理员用户
            policeUserVO.setWorkUnit(user.getWorkUnit());
        }else if(UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)){

        }else{
            policeUserVO.setId(user.getId());
        }
        List<Map> policeDogList = dogBaseInfoDao.getPoliceDogCount();
        Map<String, Long> mapping = Maps.newHashMap();
        for (int i = 0; i < policeDogList.size(); i++) {
            Map<String, Object> map = policeDogList.get(i);
            String policeId = (String) map.get("policeId");
            if(Strings.isNotEmpty(policeId)) {
                Long qty = (Long) map.get("qty");
                mapping.put(policeId, qty);
            }
        }

        List<PoliceUserVO> list = policeUserDao.getList(policeUserVO, pageVO);
        for(int i = 0; i<list.size(); i++){
            PoliceUserVO u = list.get(i);
            u.setPassword(null);
            Long qty = mapping.get(u.getId());
            if(qty != null){
                u.setDogQty(qty.intValue());
            }
        }
        Integer integer = policeUserDao.getListCount(policeUserVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/getListByRole/{pageSize}/{curPage}")
    public PageResultVO getListByRole(@RequestBody PoliceUserVO policeUserVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
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
        if(Strings.isEmpty(policeUserVO.getUserRole())){
            policeUserVO.setUserRole(UserRoleVO.NORMAL_USER);
        }
        policeUserVO.setPassword("123456");
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

    @RequestMapping("/resetPwd")
    public ResultVO resetPwd(@RequestBody List<PoliceUserVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        for (int i = 0; i < list.size(); i++) {
            PoliceUserVO policeUserVO = list.get(i);
            PoliceUserVO user = new PoliceUserVO();
            user.setId(policeUserVO.getId());
            user.setPassword("123456");
            user.setPasswordNew("123456");
            policeUserDao.update(user);
        }
        return resultVO;
    }

    @RequestMapping("/setUserRole")
    public ResultVO setUserRole(@RequestBody List<PoliceUserVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        for(int i =0;i<list.size(); i++) {
            policeUserDao.update(list.get(i));
        }
        return resultVO;
    }

    @RequestMapping("/updateMyInfo")
    public ResultVO updateMyInfo(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
        policeUserVO.setId(getCurrentUser().getId());
        if(getCurrentUser().getId() == null){
            resultVO.fail("无法获取当前用户信息，请退出重新登录再试");
            return  resultVO;
        }
        policeUserDao.update(policeUserVO);
        return resultVO;
    }
}

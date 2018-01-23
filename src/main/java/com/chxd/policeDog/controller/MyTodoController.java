package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.ITodoDao;
import com.chxd.policeDog.vo.PoliceUserVO;
import com.chxd.policeDog.vo.ResultVO;
import com.chxd.policeDog.vo.UserRoleVO;
import com.xjj.util.XDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/10/8.
 */
@RestController
@RequestMapping("/todo")
public class MyTodoController extends BaseController {
    @Autowired
    private ITodoDao todoDao;

    //getMyTodo
    @RequestMapping("/getMyTodo")
    public ResultVO getMyTodo(){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            String nowDay = new SimpleDateFormat("YYYY").format(System.currentTimeMillis());
            LocalDate localDate = XDateUtils.dateToLocalDate(new Date()).plusDays(7);
            String next7Day = new SimpleDateFormat("YYYY-MM-dd").format(XDateUtils.localDateToDate(localDate));
            localDate = XDateUtils.dateToLocalDate(new Date()).plusMonths(1);
            String nextMonth = new SimpleDateFormat("YYYY-MM-dd").format(XDateUtils.localDateToDate(localDate));

            localDate = XDateUtils.dateToLocalDate(new Date()).plusYears(-8);
            String eightYearsOld = new SimpleDateFormat("YYYY-MM-dd").format(XDateUtils.localDateToDate(localDate));

            String workUnit = null;
            String policeId = null;
            Integer applyState = null;

            PoliceUserVO user = getCurrentUser();
            String role = user.getUserRole();
            if(UserRoleVO.NORMAL_USER.equals(role)){
                //普通用户
                policeId = user.getPoliceId();
            }else if(UserRoleVO.GLY_USER.equals(role) || UserRoleVO.FJ_JZ_USER.equals(role)){
                //管理员用户
                workUnit = user.getWorkUnit();
                applyState = 1;
            }else if(UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)) {
                applyState = 2;
            }else if(UserRoleVO.FZRY_USER.equals(role)|| UserRoleVO.PXRY_USER.equals(role)){
            }else{
                policeId = user.getPoliceId();
            }

            List<Map> myTodo = todoDao.getMyTodo(nowDay, next7Day, nextMonth, workUnit, policeId, applyState, eightYearsOld);
            resultVO.setResult(myTodo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }
}

package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IApplyTickoutDao;
import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.vo.*;
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
@RequestMapping("/apply/tickout")
public class ApplyTickoutController extends BaseController {
    @Autowired
    private IApplyTickoutDao applyTickoutDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody ApplyTickoutVO tickoutVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        PoliceUserVO currentUser = getCurrentUser();
        if( UserRoleVO.JZ_USER.equals(currentUser.getUserRole()) ){
            tickoutVO.setApplyUnit(currentUser.getWorkUnit());
            tickoutVO.setApplyStateGr(1);
        }else if( UserRoleVO.NORMAL_USER.equals(currentUser.getUserRole()) ){
            tickoutVO.setApplyUser(currentUser.getPoliceName());
        }else if( UserRoleVO.JZD_USER.equals(currentUser.getUserRole()) || UserRoleVO.SUPER_USER.equals(currentUser.getUserRole())){
            tickoutVO.setApplyStateGr(2);
            tickoutVO.setApplyState(2);
        }else if( UserRoleVO.FJ_JZ_USER.equals(currentUser.getUserRole())){
            //分局
//            tickoutVO.setApplyState(1);
            tickoutVO.setApplyUnit(currentUser.getWorkUnit());
        }else{
            tickoutVO.setApplyUnit(currentUser.getWorkUnit());
        }

        List<ApplyTickoutVO> list = applyTickoutDao.getList(tickoutVO, pageVO);
        for(int i = 0; i< list.size(); i++){
            ApplyTickoutVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        Integer integer = applyTickoutDao.getListCount(tickoutVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<ApplyTickoutVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        applyTickoutDao.add(list);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<ApplyTickoutVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        applyTickoutDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody List<ApplyTickoutVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<DogBaseInfoVO> dogList = Lists.newArrayList();
            for(int i = 0; i<list.size(); i++){
                ApplyTickoutVO vo = list.get(i);
                applyTickoutDao.update(list.get(i));
                if( vo.getApplyState() == 3){
                    //审批通过，修改警犬基本信息
                    DogBaseInfoVO dog = new DogBaseInfoVO();
                    if(vo.getId() == null) continue;;
                    dog.setId(vo.getDogId());
                    dog.setBelonging(vo.getBelongTo());
                    dog.setWorkPlace("刑侦总队");
                    dog.setWorkStage(3);
                    dogList.add(dog);
                }
            }
            if(dogList.size() > 0){
                dogBaseInfoDao.tickOut(dogList, list.get(0).getBelongTo());
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
}

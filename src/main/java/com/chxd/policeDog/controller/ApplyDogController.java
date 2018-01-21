package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IApplyDogDao;
import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.vo.*;
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
@RequestMapping("/apply/dog")
public class ApplyDogController extends BaseController {
    @Autowired
    private IApplyDogDao applyDogDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody ApplyDogVO applyDogVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        PoliceUserVO currentUser = getCurrentUser();
        applyDogVO.setWorkUnit(currentUser.getWorkUnit());
        if( UserRoleVO.JZ_USER.equals(currentUser.getUserRole()) && UserRoleVO.APPROVER_USER.equals(currentUser.getApproveRole()) || UserRoleVO.JZD_USER.equals(currentUser.getUserRole()) || UserRoleVO.SUPER_USER.equals(currentUser.getUserRole())){
            applyDogVO.setWorkUnit(null);
        }

        List<ApplyDogVO> list = applyDogDao.getList(applyDogVO, pageVO);
        Integer integer = applyDogDao.getListCount(applyDogVO);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody ApplyDogVO applyDogVO){
        ResultVO resultVO = ResultVO.getInstance();
        applyDogVO.setWorkUnit(getCurrentUser().getWorkUnit());
        applyDogDao.add(applyDogVO);
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<ApplyDogVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        applyDogDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody ApplyDogVO applyDogVO){
        ResultVO resultVO = ResultVO.getInstance();
        applyDogDao.update(applyDogVO);
        return resultVO;
    }

    @RequestMapping("/updateBath")
    public ResultVO update(@RequestBody List<ApplyDogVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        for(int i = 0;i<list.size(); i++) {
            applyDogDao.update(list.get(i));
        }
        return resultVO;
    }
    @RequestMapping("/approve")
    public ResultVO approve(@RequestBody List<ApplyDogVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        try{
            for(int i =0; i<list.size(); i++){
                applyDogDao.update(list.get(i));
            }
        }catch(Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
}

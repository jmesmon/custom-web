package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IDogTrainDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/9/3.
 */
@RestController
@RequestMapping("/train")
public class DogTrainController extends BaseController {
    @Autowired
    private IDogTrainDao dogTrainDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getById/{id}")
    public ResultVO getById(@PathParam("id") int id){
        ResultVO resultVO = ResultVO.getInstance();
        DogTrainVO vo = new DogTrainVO();
        vo.setId(id);
        List<DogTrainVO> list = dogTrainDao.getList(vo, PageVO.getInstance().setPageSze(1));
        if(list.size() > 0){
            resultVO.setResult(list.get(0));
        }else{
            resultVO.fail("没有找到");
        }
        return resultVO;
    }

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogTrainVO dogTrainVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();
        if(UserRoleVO.NORMAL_USER.equals(role)){
            //普通用户
            dogTrainVO.setPoliceId(user.getId());
        }else if(UserRoleVO.GLY_USER.equals(role)){
            //管理员用户
            dogTrainVO.setWorkUnit(user.getWorkUnit());
        }else if(UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)){

        }else{
            dogTrainVO.setPoliceId(user.getId());
        }

        List<DogTrainVO> list = dogTrainDao.getList(dogTrainVO, pageVO);
        Integer integer = dogTrainDao.getListCount(dogTrainVO);
        for(int i = 0; i< list.size(); i++){
            DogTrainVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/add")
    public ResultVO add(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogTrainDao.add(list);
        for(int i = 0; i<list.size(); i++) {
            DogBaseInfoVO dog = new DogBaseInfoVO();
            dog.setId(list.get(i).getDogId());
            dog.setNextTrainDateStr(list.get(i).getNextTrainDateStr());
            dog.setIsSign("");
            dog.setLastSignDateStr("");

            dogBaseInfoDao.update(dog);
        }
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogTrainDao.del(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        for(int i = 0; i<list.size(); i++) {
            dogTrainDao.update(list.get(i));
        }
        return resultVO;
    }
    @RequestMapping("/batchUpdate")
    public ResultVO batchUpdate(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            for (int i = 0; i < list.size(); i++) {
                dogTrainDao.update(list.get(i));
                DogBaseInfoVO dog = new DogBaseInfoVO();
                dog.setId(list.get(i).getDogId());
                dog.setNextTrainDateStr(list.get(i).getNextTrainDateStr());
                dog.setTrainScore(list.get(i).getTrainResult());

                dogBaseInfoDao.update(dog);
            }
        }catch(Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/getStatus")
    public ResultVO getStatus(@RequestBody List<DogTrainVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<Map<String, String>> status = dogTrainDao.getStatus(list);
            resultVO.setResult(status);
        }catch(Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/sendNotice")
    public ResultVO sendNotice(@RequestBody DogTrainVO dogTrainVO){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<DogTrainVO> list = dogTrainDao.getTrainById(dogTrainVO.getTrainId());
            List<MyNoticeVO> noticeList = Lists.newArrayList();
            String trainName = "";
            Date trainDate = null;
            for(int i = 0; i<list.size(); i++){
                DogTrainVO dt = list.get(i);
                MyNoticeVO no = new MyNoticeVO();
                no.setIsRead(1);
                no.setPoliceId(dt.getPoliceId()+"");
                no.setTitle("【培训通知】警犬：" + dt.getDogName() +
                        "，培训科目：" + dt.getTrainName() +
//                        "，开始时间：" + new SimpleDateFormat("YYYY-MM-dd").format(dt.getTrainStartDate()) +
                        "，详细请到\"报名培训\"中查看");
                no.setNoticeType("培训通知");
                trainName = dt.getTrainName();
                trainDate = dt.getTrainStartDate();
                noticeList.add(no);
            }
            List<PoliceUserVO> userList = dogBaseInfoDao.getAdminByTrainId(dogTrainVO.getTrainId());
            for(int i = 0; i<userList.size(); i++){
                MyNoticeVO no = new MyNoticeVO();
                no.setIsRead(1);
                no.setPoliceId(userList.get(i).getPoliceId()+"");
                no.setTitle("【培训通知】" +
                        "培训科目：" + trainName +
                        "，详细请到\"报名培训\"中查看，及时通知本单位参训人员");
                no.setNoticeType("培训通知");
                noticeList.add(no);
            }
            noticeDao.addBatch(noticeList);
        }catch(Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
}

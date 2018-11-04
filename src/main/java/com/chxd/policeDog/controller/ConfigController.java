package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IOrgConfigDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Maps;
import com.xjj.util.XDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/10/3.
 */
@RestController
@RequestMapping("/config")
public class ConfigController extends BaseController {
    @Autowired
    private IOrgConfigDao orgConfigDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getOrgList")
    public ResultVO getOrgList(){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<OrgConfigVO> list = orgConfigDao.getList(new OrgConfigVO(), new PageVO().setPageSze(1000));

            LocalDate localDate = XDateUtils.dateToLocalDate(new Date()).minusMonths(1);
            String lastMonth = new SimpleDateFormat("YYYY-MM-dd").format(XDateUtils.localDateToDate(localDate));
            String nowMonth = new SimpleDateFormat("YYYY-MM-dd").format(System.currentTimeMillis());
            List<Map> count = dogBaseInfoDao.getOrgCount(lastMonth, nowMonth);
            Map<String, Map> map = Maps.newHashMap();
            for(int i = 0; i<count.size(); i++){
                try {
                    String workUnit = (String)count.get(i).get("workUnit");
//                    Long val = (Long)count.get(i).get("val");
                    map.put(workUnit, count.get(i));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            List<Map> userCount = orgConfigDao.getUserCount();
            Map<String, Map> map2 = Maps.newHashMap();
            for(int i = 0; i<userCount.size(); i++){
                try {
                    String workUnit = (String)userCount.get(i).get("workUnit");
//                    Long val = (Long)count.get(i).get("val");
                    map2.put(workUnit, userCount.get(i));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            for(int i = 0; i<list.size(); i++){
                OrgConfigVO orgConfigVO = list.get(i);
                if(map.containsKey(orgConfigVO.getOrgName())){
                    Map val = map.get(orgConfigVO.getOrgName());
                    orgConfigVO.setDogQty(((BigDecimal)val.get("dogCount")).intValue());
                    orgConfigVO.setNewQty(((BigDecimal)val.get("newsCount")).intValue());
                    orgConfigVO.setWorkQty(val.get("workQty"));
                }
                if("通州分局".equals(orgConfigVO.getOrgName())){
                    Map val = map2.get("通州巡警支队警犬队");
                    orgConfigVO.setPoliceCount(((Long)val.get("userQty")).intValue());
                }else if(map2.containsKey(orgConfigVO.getOrgName())){
                    Map val = map2.get(orgConfigVO.getOrgName());
                    orgConfigVO.setPoliceCount(((Long)val.get("userQty")).intValue());
                }
            }
            resultVO.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }

        return resultVO;
    }

    @RequestMapping("/orgInfo")
    public ResultVO orgInfo(@RequestBody OrgConfigVO orgConfigVO){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<OrgConfigVO> list = orgConfigDao.getList(orgConfigVO, new PageVO().setPageSze(1000));
            resultVO.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }

        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody OrgConfigVO orgConfigVO){
        ResultVO resultVO = ResultVO.getInstance();
        orgConfigDao.update(orgConfigVO);
        return resultVO;
    }

    @RequestMapping("/getDogAnalysis")
    public ResultVO getDogAnalysis(){
        ResultVO resultVO = ResultVO.getInstance();
        String workUnit = null;
        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();
        workUnit = user.getWorkUnit();
        if(UserRoleVO.JZ_USER.equals(role) || UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)){
            workUnit = null;
        }
        List<Map> dogAnalysis = orgConfigDao.getDogAnalysis(workUnit);
        for(int i = 0; i<dogAnalysis.size(); i++){
            Map m = dogAnalysis.get(i);
            if(m.get("att_name")  == null){
                continue;
            }
            if(!m.get("att_name").getClass().getName().equals("java.lang.String")){
                byte[] b = (byte[])m.get("att_name");
                m.put("att_name", new String(b));
            }

        }
        resultVO.setResult(dogAnalysis);
        return resultVO;
    }

    @RequestMapping("/getUserAnalysis")
    public ResultVO getUserAnalysis(){
        ResultVO resultVO = ResultVO.getInstance();
        String workUnit = null;
        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();
        workUnit = user.getWorkUnit();
        if(UserRoleVO.JZ_USER.equals(role) || UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)){
            workUnit = null;
        }
        List<Map> userAnalysis = orgConfigDao.getUserAnalysis(workUnit);
        resultVO.setResult(userAnalysis);
        return resultVO;
    }

    @RequestMapping("/updateBreedSum")
    public ResultVO updateBreedSum(@RequestBody BreedSumVO breedSumVO){
        ResultVO resultVO = ResultVO.getInstance();
        orgConfigDao.updateBreedSum(breedSumVO);
        return resultVO;
    }

    @RequestMapping("/getBreedSumOrgList")
    public ResultVO getBreedSumOrgList(){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<BreedSumVO> list = orgConfigDao.getBreedSumList(new BreedSumVO(), new PageVO());
            resultVO.setResult(list.get(0));
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }

        return resultVO;
    }
}

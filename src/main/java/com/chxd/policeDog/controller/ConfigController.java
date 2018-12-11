package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IOrgConfigDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Maps;
import com.xjj.util.XDateUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
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

    @RequestMapping("/getAll/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogBaseInfoVO dogBaseInfoVO, @PathParam("") PageVO pageVO){
        PageResultVO rst = new PageResultVO();
        rst.setResult((List<? extends Object>) getOrgList().getResult());
        rst.setPageVO(new PageVO());
        return rst;
    }

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

        DogBaseInfoVO db = new DogBaseInfoVO();
        Integer integer = dogBaseInfoDao.selectAllCount(db);
        resultVO.setMessage(integer+"");

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
        DogBaseInfoVO dog = new DogBaseInfoVO();
        dog.setWorkPlace(workUnit);
        ResultVO dogProAnalysis = getDogProAnalysis(dog);
        Map<String, Integer> proData = (Map<String, Integer>) dogProAnalysis.getResult();
        for(Iterator<String> it = proData.keySet().iterator(); it.hasNext();){
            String proName = it.next();
            int proQty = proData.get(proName);
            Map<String, Object> m = Maps.newHashMap();
            m.put("ctype", "pro");
            m.put("val", proQty);
            m.put("att_name", proName);
            dogAnalysis.add(m);
        }
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

    @RequestMapping("/getDogPowerAnalysis")
    public ResultVO getDogPowerAnalysis(@RequestBody PoliceUserVO policeUserVO){
        ResultVO resultVO = ResultVO.getInstance();
        List<Map> dogPowerAnalysis = orgConfigDao.getDogPowerAnalysis(policeUserVO);
        resultVO.setResult(dogPowerAnalysis);
        return resultVO;
    }

    @RequestMapping("/getDogProAnalysis")
    public ResultVO getDogProAnalysis(@RequestBody DogBaseInfoVO dogBaseInfoVO){
        ResultVO resultVO = ResultVO.getInstance();
        dogBaseInfoVO.setState(3);
        dogBaseInfoVO.setUnit(1);
        List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, new PageVO().setPageSze(100000));
        Map<String, Integer> map = Maps.newHashMap();
        for(int i = 0; i<list.size(); i++){
            DogBaseInfoVO dog = list.get(i);
            String pro = dog.getMainPro();
            if(Strings.isEmpty(pro)) {
                pro = "未知";
            }
            String[] split = pro.split(",");
            for(String p : split){
                if("追踪".equals(p)){
                    p = "追踪(刑)";
                }
                if("鉴别".equals(p)){
                    p = "鉴别(刑)";
                }
                if("物证搜索".equals(p)){
                    p = "物证搜索(刑)";
                }
                if("搜捕".equals(p)){
                    p = "搜捕(刑)";
                }
                Integer counter = map.get(p);
                if(counter == null){
                    counter = new Integer(1);
                }else{
                    counter += 1;
                }
                map.put(p, counter);
            }
        }
        resultVO.setResult(map);
        return resultVO;
    }
}

package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IOrgConfigDao;
import com.chxd.policeDog.vo.OrgConfigVO;
import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.ResultVO;
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
public class ConfigController {
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
            String lastMonth = new SimpleDateFormat("YYYY-MM-01").format(XDateUtils.localDateToDate(localDate));
            String nowMonth = new SimpleDateFormat("YYYY-MM-01").format(System.currentTimeMillis());
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
            for(int i = 0; i<list.size(); i++){
                OrgConfigVO orgConfigVO = list.get(i);
                if(map.containsKey(orgConfigVO.getOrgName())){
                    Map val = map.get(orgConfigVO.getOrgName());
                    orgConfigVO.setDogQty(((BigDecimal)count.get(i).get("dogCount")).intValue());
                    orgConfigVO.setNewQty(((BigDecimal)count.get(i).get("newsCount")).intValue());
                    orgConfigVO.setWorkHours(((Double)count.get(i).get("workHours")).intValue());
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
        List<Map> dogAnalysis = orgConfigDao.getDogAnalysis();
        resultVO.setResult(dogAnalysis);
        return resultVO;
    }

    @RequestMapping("/getUserAnalysis")
    public ResultVO getUserAnalysis(){
        ResultVO resultVO = ResultVO.getInstance();
        List<Map> userAnalysis = orgConfigDao.getUserAnalysis();
        resultVO.setResult(userAnalysis);
        return resultVO;
    }
}

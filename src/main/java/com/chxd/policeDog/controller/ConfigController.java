package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IOrgConfigDao;
import com.chxd.policeDog.vo.OrgConfigVO;
import com.chxd.policeDog.vo.PageVO;
import com.chxd.policeDog.vo.ResultVO;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            List<Map> count = dogBaseInfoDao.getOrgCount();
            Map<String, Integer> map = Maps.newHashMap();
            for(int i = 0; i<count.size(); i++){
                try {
                    String workUnit = (String)count.get(i).get("workUnit");
                    Long val = (Long)count.get(i).get("val");
                    map.put(workUnit, val.intValue());
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            for(int i = 0; i<list.size(); i++){
                OrgConfigVO orgConfigVO = list.get(i);
                if(map.containsKey(orgConfigVO.getOrgName())){
                    orgConfigVO.setDogQty(map.get(orgConfigVO.getOrgName()));
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
}

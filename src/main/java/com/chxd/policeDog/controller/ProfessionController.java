package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IProfessionDao;
import com.chxd.policeDog.vo.DogBaseInfoVO;
import com.chxd.policeDog.vo.DogProVO;
import com.chxd.policeDog.vo.PageResultVO;
import com.chxd.policeDog.vo.PageVO;
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
@RequestMapping("/profession")
public class ProfessionController {
    @Autowired
    private IProfessionDao professionDao;
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;

    @RequestMapping("/getList/{pageSize}/{curPage}")
    public PageResultVO getList(@RequestBody DogProVO dogProVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogProVO> list = professionDao.getList(dogProVO, pageVO);
        for(int i = 0; i< list.size(); i++){
            DogProVO dp = list.get(i);
            DogBaseInfoVO dogInfo = new DogBaseInfoVO();
            dogInfo.setId(dp.getDogId());
            List<DogBaseInfoVO> dog = dogBaseInfoDao.selectAll(dogInfo, PageVO.getInstance());
            if(dog.size() > 0) {
                dp.setDogInfo(dog.get(0));
            }
        }
        Integer integer = professionDao.getListCount(dogProVO);

        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }
}

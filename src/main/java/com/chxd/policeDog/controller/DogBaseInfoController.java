package com.chxd.policeDog.controller;

import com.chxd.policeDog.dao.IDogBaseInfoDao;
import com.chxd.policeDog.dao.IWormImmueDao;
import com.chxd.policeDog.vo.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xjj.util.XDateUtils;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cheng on 2017/8/27.
 */
@RestController
@RequestMapping("/dogBaseInfo")
public class DogBaseInfoController {
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;
    @Autowired
    private IWormImmueDao wormImmueDao;

    @RequestMapping("/getAll/{pageSize}/{curPage}")
    public PageResultVO getAll(@RequestBody DogBaseInfoVO dogBaseInfoVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, pageVO);
        Integer integer = dogBaseInfoDao.selectAllCount(dogBaseInfoVO);

//        buildWord(list);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        try {
//            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }



        return page;
    }

    private void buildWord(List<DogBaseInfoVO> list){
        Configuration con = new Configuration();
        try {
            con.setDirectoryForTemplateLoading(new File("E://001"));//指定加载模板的位置
            con.setObjectWrapper(new DefaultObjectWrapper());//指定生产模板的方式
            con.setDefaultEncoding("utf-8");//设置模板读取的编码方式，用于处理乱码
            con.setClassicCompatible(true);

            Template template = con.getTemplate("s2.xml");//模板文件，可以是xml,ftl,html
            System.out.println(template.getEncoding());
            template.setEncoding("utf-8");//设置写入模板的编码方式

            Map root = new HashMap();//data数据

            root.put("year", "2017");
            root.put("month", "09");
            root.put("createUnit", "刑侦总队");
            root.put("createUser", "张山泉");

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E://001//export//s.doc")), "utf-8"));//生产文件输出流

            root.put("dogList", list);
            template.process(root, out);//将模板写到文件中
            out.flush();
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping("/get")
    public ResultVO getDog(@RequestBody DogBaseInfoVO dogBaseInfoVO) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, new PageVO());
            resultVO.setResult(list);
        } catch (Exception e) {
            e.printStackTrace();
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @RequestMapping("/addDog")
    public ResultVO addDogs(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        dogBaseInfoDao.add(dogList);
        return resultVO;
    }

    @RequestMapping("/initWormInfo/{nestNo}")
    public ResultVO initWormInfo(@PathVariable("nestNo") String nestNo) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            if (Strings.isEmpty(nestNo)) {
                resultVO.setSuccess(false);
                return resultVO;
            }
            DogBaseInfoVO dogQuery = new DogBaseInfoVO();
            dogQuery.setNestNo(nestNo);
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogQuery, PageVO.getInstance().setPageSze(1000));

            List<DogWormVO> data = Lists.newArrayList();

            List<WormImmueCfgVO> wormList = wormImmueDao.getWormImmueCfgVO(WormImmueCfgVO.getInstance().setPeriodType(WormImmueCfgVO.WORM_PERIOD));

            for (int i = 0; i < list.size(); i++) {
                DogBaseInfoVO dog = list.get(i);
                for (int j = 0; j < wormList.size(); j++) {
                    DogWormVO worm = new DogWormVO();
                    WormImmueCfgVO cfg = wormList.get(j);

                    LocalDate localDate = XDateUtils.dateToLocalDate(dog.getBirthday());
                    localDate = localDate.plusDays(cfg.getPeriod());

                    worm.setNestNo(nestNo);
                    worm.setDogChipNo(dog.getChipNo());
                    worm.setWormState(1);
                    worm.setWormDesc(cfg.getDescription());
                    worm.setWormDate(XDateUtils.localDateToDate(localDate));
                    data.add(worm);
                }
            }

            dogBaseInfoDao.addWorm(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }

    @RequestMapping("/initImmueInfo/{nestNo}")
    public ResultVO initImmueInfo(@PathVariable("nestNo") String nestNo) {
        ResultVO resultVO = ResultVO.getInstance();
        try {
            if (Strings.isEmpty(nestNo)) {
                resultVO.setSuccess(false);
                return resultVO;
            }
            DogBaseInfoVO dogQuery = new DogBaseInfoVO();
            dogQuery.setNestNo(nestNo);
            List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogQuery, PageVO.getInstance().setPageSze(1000));

            List<DogImmueVO> data = Lists.newArrayList();

            List<WormImmueCfgVO> wormList = wormImmueDao.getWormImmueCfgVO(WormImmueCfgVO.getInstance().setPeriodType(WormImmueCfgVO.IMMUE_PERIOD));

            for (int i = 0; i < list.size(); i++) {
                DogBaseInfoVO dog = list.get(i);
                for (int j = 0; j < wormList.size(); j++) {
                    DogImmueVO vo = new DogImmueVO();
                    WormImmueCfgVO cfg = wormList.get(j);

                    LocalDate localDate = XDateUtils.dateToLocalDate(dog.getBirthday());
                    localDate = localDate.plusDays(cfg.getPeriod());

                    vo.setNestNo(nestNo);
                    vo.setDogChipNo(dog.getChipNo());
                    vo.setImmueState(1);
                    vo.setImmueDate(XDateUtils.localDateToDate(localDate));
                    vo.setImmueName(cfg.getDescription());
                    data.add(vo);
                }
            }

            dogBaseInfoDao.addImmue(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultVO;
    }

    @RequestMapping("/tickout")
    public ResultVO doTickOut(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            dogBaseInfoDao.tickOut(dogList, dogList.get(0).getBelonging());
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }

    @RequestMapping("/died")
    public ResultVO doDied(@RequestBody List<DogBaseInfoVO> dogList) {
        ResultVO resultVO = ResultVO.getInstance();
        try{
            dogBaseInfoDao.died(dogList);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
    @RequestMapping("/relativeCheck/{boy}/{girl}")
    public ResultVO relativeCheck(@PathVariable("boy")String boy, @PathVariable("girl")String girl){
        ResultVO resultVO = ResultVO.getInstance();
        List<String> msgList = Lists.newArrayList();
        resultVO.setResult(msgList);

        DogBaseInfoVO boyDog = getDogByChipNo(new DogBaseInfoVO().setChipNo(boy)); // 公犬
        if(boyDog.getId() == null){
            resultVO.fail("公犬芯片号不存在");
            return resultVO;
        }
        DogBaseInfoVO girlDog = getDogByChipNo(new DogBaseInfoVO().setChipNo(girl)); // 母犬
        if(girlDog.getId() == null){
            resultVO.fail("母犬芯片号不存在");
            return resultVO;
        }

        List<DogBaseInfoVO> listA = Lists.newArrayList();
        List<DogBaseInfoVO> listB = Lists.newArrayList();
        //公犬三代亲属部分
        DogBaseInfoVO fatherA = getDogByChipNo(new DogBaseInfoVO().setChipNo(boyDog.getFatherId())); // 父亲
        fatherA.setDogSource("父亲");
        listA.add(fatherA);

        DogBaseInfoVO motherA = getDogByChipNo(new DogBaseInfoVO().setChipNo(boyDog.getMotherId())); // 母亲
        motherA.setDogSource("母亲");
        listA.add(motherA);

        DogBaseInfoVO grandfatherA = getDogByChipNo(new DogBaseInfoVO().setChipNo(fatherA.getFatherId())); // 爷爷
        grandfatherA.setDogSource("爷爷");
        listA.add(grandfatherA);

        DogBaseInfoVO grandmotherA = getDogByChipNo(new DogBaseInfoVO().setChipNo(fatherA.getMotherId())); // 奶奶
        grandmotherA.setDogSource("奶奶");
        listA.add(grandmotherA);

        DogBaseInfoVO grandpaA = getDogByChipNo(new DogBaseInfoVO().setChipNo(motherA.getFatherId())); // 姥爷
        grandpaA.setDogSource("姥爷");
        listA.add(grandpaA);
        DogBaseInfoVO grandmaA = getDogByChipNo(new DogBaseInfoVO().setChipNo(motherA.getMotherId())); // 姥姥
        grandmaA.setDogSource("姥姥");
        listA.add(grandmaA);

        //母犬三代亲属部分
        DogBaseInfoVO fatherB = getDogByChipNo(new DogBaseInfoVO().setChipNo(girlDog.getFatherId())); // 父亲
        fatherB.setDogSource("父亲");
        listB.add(fatherB);

        DogBaseInfoVO motherB = getDogByChipNo(new DogBaseInfoVO().setChipNo(girlDog.getMotherId())); // 母亲
        motherB.setDogSource("母亲");
        listB.add(motherB);

        DogBaseInfoVO grandfatherB = getDogByChipNo(new DogBaseInfoVO().setChipNo(fatherB.getFatherId())); // 爷爷
        grandfatherB.setDogSource("爷爷");
        listB.add(grandfatherB);

        DogBaseInfoVO grandmotherB = getDogByChipNo(new DogBaseInfoVO().setChipNo(fatherB.getMotherId())); // 奶奶
        grandmotherB.setDogSource("奶奶");
        listB.add(grandmotherB);

        DogBaseInfoVO grandpaB = getDogByChipNo(new DogBaseInfoVO().setChipNo(motherB.getFatherId())); // 姥爷
        grandpaB.setDogSource("姥爷");
        listB.add(grandpaB);

        DogBaseInfoVO grandmaB = getDogByChipNo(new DogBaseInfoVO().setChipNo(motherB.getMotherId())); // 姥姥
        grandmaB.setDogSource("姥姥");
        listB.add(grandmaB);

        Map<String, List<DogBaseInfoVO>> data = Maps.newHashMap();
        data.put("boy", listA);
        data.put("girl", listB);
        resultVO.setResult(data);

        for(int i = 0; i<listA.size(); i++){
            DogBaseInfoVO a = listA.get(i);
            if(Strings.isBlank(a.getChipNo())){
                continue;
            }
            for(int j = 0; j<listB.size(); j++){
                DogBaseInfoVO b = listB.get(j);
                if(Strings.isBlank(b.getChipNo())){
                    continue;
                }
                if(a.getChipNo().equals(b.getChipNo())){
                    a.setDogColour("_Tag");
                    b.setDogColour("_Tag");
                    resultVO.fail();
                    resultVO.setMessage("公犬的" + a.getDogSource() + "与母犬的" + b.getDogSource() + "为同一只犬");
                    return  resultVO;
                }
            }
        }

        return resultVO;
    }

    private DogBaseInfoVO getDogByChipNo(DogBaseInfoVO vo){
        if(vo == null || Strings.isEmpty(vo.getChipNo())){
            return new DogBaseInfoVO();
        }
        List<DogBaseInfoVO> list1 = dogBaseInfoDao.selectAll(vo, PageVO.getInstance());
        if(list1.size() > 0){
            return list1.get(0);
        }else{
           return new DogBaseInfoVO();
        }
    }
}

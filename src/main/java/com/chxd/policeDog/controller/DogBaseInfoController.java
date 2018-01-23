package com.chxd.policeDog.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.chxd.policeDog.config.MyProps;
import com.chxd.policeDog.dao.*;
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
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by cheng on 2017/8/27.
 */
@RestController
@RequestMapping("/dogBaseInfo")
public class DogBaseInfoController extends BaseController{
    @Autowired
    private IDogBaseInfoDao dogBaseInfoDao;
    @Autowired
    private IWormImmueDao wormImmueDao;
    @Autowired
    private IDogTrainDao dogTrainDao;
    @Autowired
    private IDogChangeDao dogChangeDao;
    @Autowired
    private IDogWorkDao dogWorkDao;


    @RequestMapping("/getAll/{pageSize}/{curPage}")
    public PageResultVO getAll(@RequestBody DogBaseInfoVO dogBaseInfoVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();

        PoliceUserVO user = getCurrentUser();
        String role = user.getUserRole();
        if(UserRoleVO.NORMAL_USER.equals(role)){
            //普通用户
            dogBaseInfoVO.setPoliceId(user.getId() + "");
        }else if(UserRoleVO.GLY_USER.equals(role) || UserRoleVO.FJ_JZ_USER.equals(role)){
            //管理员用户
            dogBaseInfoVO.setWorkPlace(user.getWorkUnit());
        }else if(UserRoleVO.JZ_USER.equals(role) || UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role)|| UserRoleVO.FZRY_USER.equals(role)|| UserRoleVO.PXRY_USER.equals(role)){

        }else{
            dogBaseInfoVO.setPoliceId(user.getId() + "");
        }

        List<DogBaseInfoVO> list = dogBaseInfoDao.selectAll(dogBaseInfoVO, pageVO);
        Integer integer = dogBaseInfoDao.selectAllCount(dogBaseInfoVO);
        if(list.size() > 0) {
            List<Map> dogPro = dogBaseInfoDao.getDogPro(list);

            Map<Integer, String> dogProMapping = Maps.newHashMap();
            for (int i = 0; i < dogPro.size(); i++) {
                Map map = dogPro.get(i);
                Integer dogId = (Integer) map.get("dog_id");
                String pros = dogProMapping.get(dogId);
                if (pros == null) {
                    pros = (String) map.get("trainName");
                } else {
                    pros += "，" + (String) map.get("trainName");
                }
                dogProMapping.put(dogId, pros);
            }
            for(int i = 0; i<list.size(); i++){
                DogBaseInfoVO dog = list.get(i);
                dog.setDogPros(dogProMapping.get(dog.getId()));
            }
        }

//        buildWord(list);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/getTrainList/{pageSize}/{curPage}")
    public PageResultVO getTrainList(@RequestBody DogBaseInfoVO dogBaseInfoVO, @PathParam("") PageVO pageVO) {
        PageResultVO page = new PageResultVO();
        List<DogBaseInfoVO> list = dogBaseInfoDao.getTrainList(dogBaseInfoVO, pageVO);
        Integer integer = dogBaseInfoDao.selectAllCount(dogBaseInfoVO);

//        buildWord(list);
        pageVO.setTotalRows(integer);
        page.setResult(list);
        page.setPageVO(pageVO);
        return page;
    }

    @RequestMapping("/getAnalysisData")
    public ResultVO getAnalysisData(@RequestBody PoliceUserVO user){
        ResultVO resultVO = ResultVO.getInstance();
        String year = new SimpleDateFormat("YYYY").format(System.currentTimeMillis());

        PoliceUserVO policeUser = getCurrentUser();
        String role = policeUser.getUserRole();
        if(UserRoleVO.NORMAL_USER.equals(role)){
            //普通用户
            user.setWorkUnit(policeUser.getWorkUnit());
        }else if(UserRoleVO.GLY_USER.equals(role) || UserRoleVO.FJ_JZ_USER.equals(role)){
            //分局局长、分局管理员，只看本局下的数据
            user.setWorkUnit(policeUser.getWorkUnit());
        }else if(UserRoleVO.JZD_USER.equals(role) || UserRoleVO.SUPER_USER.equals(role) || UserRoleVO.JZ_USER.equals(role)){
            //局长 九支队 管理员  查看全部数据
            user.setWorkUnit(null);
        }else{
            user.setWorkUnit(policeUser.getWorkUnit());
        }

        List<Map> list = dogBaseInfoDao.getAnalysisData(year + "-01-01", year + "-12-12", user.getWorkUnit());
        resultVO.setResult(list);
        return resultVO;
    }

    @RequestMapping("/getWorkData")
    public ResultVO getWorkData(@RequestBody PoliceUserVO user){
        ResultVO resultVO = ResultVO.getInstance();
        String year = new SimpleDateFormat("YYYY").format(System.currentTimeMillis());
        List<Map> list = dogBaseInfoDao.getWorkData(year + "-01-01", year + "-12-12", user.getWorkUnit(), "通过");
        resultVO.setResult(list);
        return resultVO;
    }

    @RequestMapping("/update")
    public ResultVO update(@RequestBody List<DogBaseInfoVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        for(int i = 0; i<list.size(); i++) {
            dogBaseInfoDao.update(list.get(i));
        }
        return resultVO;
    }

    @RequestMapping("/isNameDump")
    public ResultVO isNameDump(@RequestBody DogBaseInfoVO dogBaseInfoVO){
        ResultVO resultVO = ResultVO.getInstance();
        Integer integer = dogBaseInfoDao.selectAllCount(dogBaseInfoVO);
        if(integer != null && integer > 0){
            resultVO.setResult(integer);
            resultVO.setSuccess(false);
        }
        return resultVO;
    }

    @RequestMapping("/delete")
    public ResultVO delete(@RequestBody List<DogBaseInfoVO> list){
        ResultVO resultVO = ResultVO.getInstance();
        dogBaseInfoDao.del(list);
        return resultVO;
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
            e.printStackTrace();
        } catch (TemplateException e) {
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
                    worm.setDogId(dog.getId());
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

    @RequestMapping("/allot")
    public ResultVO allot(@RequestBody List<DogBaseInfoVO> list) {
        ResultVO resultVO = ResultVO.getInstance();
        dogBaseInfoDao.allot(list, list.get(0).getWorkPlace());
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
                    vo.setDogId(dog.getId());
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

    @RequestMapping("/changeUser")
    public ResultVO changeUser(@RequestBody DogChangeVO dogChangeVO){
        ResultVO resultVO = ResultVO.getInstance();
        try{
            DogBaseInfoVO dog = new DogBaseInfoVO();
            dog.setId(dogChangeVO.getDogId());
            dog.setPoliceId(dogChangeVO.getNewPoliceId());
            dog.setPoliceName(dogChangeVO.getNewPoliceName());
            dog.setWorkPlace(dogChangeVO.getNewWorkPlace());
            dogBaseInfoDao.changePoliceUser(dog);

            List<DogChangeVO> li = Lists.newArrayList();
            dogChangeVO.setChangeDate(new Date());
            PoliceUserVO currentUser = getCurrentUser();
            dogChangeVO.setApplyId(currentUser.getId());
            dogChangeVO.setAgentName(currentUser.getPoliceName());
//            dogChangeVO.setChangeState(1);
            dogChangeVO.setCreationDate(new Date());
            dogChangeVO.setLastUpdateDate(new Date());
            li.add(dogChangeVO);
            dogChangeDao.add(li);

            MyNoticeVO notice = new MyNoticeVO();
            notice.setNoticeType("变更通知");
            notice.setIsRead(1);
            notice.setTitle(currentUser.getPoliceName() + "分配给你一头警犬，请注意查收，可在\"警犬列表\"中查看");
            notice.setPoliceId(dogChangeVO.getNewPoliceId());
            notice.setCreationDate(new Date());
            notice.setLastUpdateDate(new Date());
            noticeDao.add(notice);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }
    @RequestMapping("/relativeCheck/{boy}/{girl}")
    public ResultVO relativeCheck(@PathVariable("boy")int boy, @PathVariable("girl")int girl){
        ResultVO resultVO = ResultVO.getInstance();
        List<String> msgList = Lists.newArrayList();
        resultVO.setResult(msgList);

        DogBaseInfoVO boyDog = getDogByDogId(new DogBaseInfoVO(boy)); // 公犬
        if(boyDog.getId() == null){
            resultVO.fail("公犬芯片号不存在");
            return resultVO;
        }
        DogBaseInfoVO girlDog = getDogByDogId(new DogBaseInfoVO(girl)); // 母犬
        if(girlDog.getId() == null){
            resultVO.fail("母犬芯片号不存在");
            return resultVO;
        }

        List<DogBaseInfoVO> listA = Lists.newArrayList();
        List<DogBaseInfoVO> listB = Lists.newArrayList();
        //公犬三代亲属部分
        DogBaseInfoVO fatherA = getDogByDogId(new DogBaseInfoVO(boyDog.getId())); // 父亲
        fatherA.setDogSource("父亲");
        listA.add(fatherA);

        DogBaseInfoVO motherA = getDogByDogId(new DogBaseInfoVO(boyDog.getId())); // 母亲
        motherA.setDogSource("母亲");
        listA.add(motherA);

        DogBaseInfoVO grandfatherA = getDogByDogId(new DogBaseInfoVO(fatherA.getId())); // 爷爷
        grandfatherA.setDogSource("爷爷");
        listA.add(grandfatherA);

        DogBaseInfoVO grandmotherA = getDogByDogId(new DogBaseInfoVO(fatherA.getId())); // 奶奶
        grandmotherA.setDogSource("奶奶");
        listA.add(grandmotherA);

        DogBaseInfoVO grandpaA = getDogByDogId(new DogBaseInfoVO(motherA.getId())); // 姥爷
        grandpaA.setDogSource("姥爷");
        listA.add(grandpaA);
        DogBaseInfoVO grandmaA = getDogByDogId(new DogBaseInfoVO(motherA.getId())); // 姥姥
        grandmaA.setDogSource("姥姥");
        listA.add(grandmaA);

        //母犬三代亲属部分
        DogBaseInfoVO fatherB = getDogByDogId(new DogBaseInfoVO(girlDog.getFatherId())); // 父亲
        fatherB.setDogSource("父亲");
        listB.add(fatherB);

        DogBaseInfoVO motherB = getDogByDogId(new DogBaseInfoVO(girlDog.getMotherId())); // 母亲
        motherB.setDogSource("母亲");
        listB.add(motherB);

        DogBaseInfoVO grandfatherB = getDogByDogId(new DogBaseInfoVO(fatherB.getFatherId())); // 爷爷
        grandfatherB.setDogSource("爷爷");
        listB.add(grandfatherB);

        DogBaseInfoVO grandmotherB = getDogByDogId(new DogBaseInfoVO(fatherB.getMotherId())); // 奶奶
        grandmotherB.setDogSource("奶奶");
        listB.add(grandmotherB);

        DogBaseInfoVO grandpaB = getDogByDogId(new DogBaseInfoVO(motherB.getFatherId())); // 姥爷
        grandpaB.setDogSource("姥爷");
        listB.add(grandpaB);

        DogBaseInfoVO grandmaB = getDogByDogId(new DogBaseInfoVO(motherB.getMotherId())); // 姥姥
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

    @RequestMapping("/searchList")
    private List<DogBaseInfoVO> searchDogList(@RequestParam(value="filter[value]", required = false) String chipNo){
        ResultVO resultVO = ResultVO.getInstance();
        if(Strings.isBlank(chipNo)){
            return new ArrayList<DogBaseInfoVO>();
        }
        try {
            List<DogBaseInfoVO> list = dogBaseInfoDao.search(chipNo);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return new ArrayList<DogBaseInfoVO>();
    }

    private DogBaseInfoVO getDogByDogId(DogBaseInfoVO vo){
        List<DogBaseInfoVO> list1 = dogBaseInfoDao.selectAll(vo, PageVO.getInstance());
        if(list1.size() > 0){
            return list1.get(0);
        }else{
            return new DogBaseInfoVO();
        }
    }

    @RequestMapping("/addDogInfo")
    public ResultVO addDogInfo(@RequestBody Map<String, Object> params){
        ResultVO resultVO = ResultVO.getInstance();
        try {
            DogBaseInfoVO dogBaseInfoVO = JSON.parseObject(JSON.toJSONString(params.get("baseInfo")), new TypeReference<DogBaseInfoVO>() {});
            dogBaseInfoVO.setCreationDate(new Date());
            dogBaseInfoVO.setUid(System.currentTimeMillis());

            List<DogBaseInfoVO> li = Lists.newArrayList();
            li.add(dogBaseInfoVO);
            dogBaseInfoDao.add(li);
            DogBaseInfoVO dg = new DogBaseInfoVO();
            dg.setUid(dogBaseInfoVO.getUid());
            li = dogBaseInfoDao.selectAll(dg, new PageVO());
            int wormCount = 0;
            int immuCount = 0;
            int trainCount = 0;
            if(li.size() > 0){
                DogBaseInfoVO dogInfo = li.get(0);
                try {
                    ArrayList<DogTrainVO> trainList = JSON.parseObject(JSON.toJSONString(params.get("trainData")), new TypeReference<ArrayList<DogTrainVO>>() {
                    });
                    for (int i = 0; i < trainList.size(); i++) {
                        trainList.get(i).setDogId(dogInfo.getId());
                    }
                    dogTrainDao.add(trainList);
                    trainCount = trainList.size();
                }catch (Exception e1){
                    e1.printStackTrace();
                }

                ArrayList<WormImmueInfoVO> wormImmueList = JSON.parseObject(JSON.toJSONString(params.get("wormImmueData")), new TypeReference<ArrayList<WormImmueInfoVO>>() {});
                for(int i = 0; i<wormImmueList.size(); i++){
                    WormImmueInfoVO wormImmueInfoVO = wormImmueList.get(i);
                    try {
                        DogWormVO worm = new DogWormVO();
                        worm.setDogId(dogInfo.getId());
                        worm.setWormDateStr(wormImmueInfoVO.getDate());
                        worm.setWormDesc(wormImmueInfoVO.getName());
                        worm.setWormState(2);
                        wormImmueDao.addWorm(worm);
                        wormCount ++;
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }

                    try {
                        DogImmueVO imu = new DogImmueVO();
                        imu.setDogId(dogInfo.getId());
                        imu.setImmueDateStr(wormImmueInfoVO.getDate());
                        imu.setImmueName(wormImmueInfoVO.getName());
                        imu.setImmueState(2);
                        wormImmueDao.addImmue(imu);
                        immuCount ++;
                    }catch (Exception e3){
                        e3.printStackTrace();
                    }
                }
            }else{
                resultVO.fail("操作失败，基本信息添加失败！");
                return resultVO;
            }
            Map<String, Object> data = Maps.newHashMap();
            data.put("trainCount", trainCount);
            data.put("wormCount", wormCount);
            data.put("immuCount", immuCount);
            resultVO.setResult(data);
        }catch (Exception e){
            e.printStackTrace();
            resultVO.fail(e.getMessage());
        }
        return resultVO;
    }


    @Autowired
    private MyProps myProps;

    @RequestMapping("/exportWorkData")
    public ResultVO exportWorkData(@RequestBody Map<String, Object> params){
        ResultVO resultVO = ResultVO.getInstance();
        List<Map> list = dogBaseInfoDao.getWorkData4Export((String) params.get("startDate"), (String) params.get("endDate"), (String) params.get("workUnit"));
        Configuration con = new Configuration();
        Writer out = null;
        try {
            con.setDirectoryForTemplateLoading(new File(myProps.getUploadFilePath() + "/template"));//指定加载模板的位置
            con.setObjectWrapper(new DefaultObjectWrapper());//指定生产模板的方式
            con.setDefaultEncoding("utf-8");//设置模板读取的编码方式，用于处理乱码
            con.setClassicCompatible(true);

            Template template = con.getTemplate("dog_work_data_temp.xml");//模板文件，可以是xml,ftl,html
            template.setEncoding("utf-8");//设置写入模板的编码方式

            Map root = new HashMap();//data数据
            root.put("ry_民警", 0);
            root.put("ry_辅警", 0);
            root.put("pz_德国牧羊犬", 0);
            root.put("pz_昆明犬", 0);
            root.put("pz_荷兰牧羊犬", 0);
            root.put("pz_罗威纳犬", 0);
            root.put("pz_拉布拉多犬", 0);
            root.put("pz_马里努阿犬", 0);
            root.put("pz_史宾格犬", 0);
            root.put("pz_其他", 0);
            root.put("jn_追踪", 0);
            root.put("jn_鉴别", 0);
            root.put("jn_搜索", 0);
            root.put("jn_搜捕", 0);
            root.put("jn_治安防范", 0);
            root.put("jn_搜爆", 0);
            root.put("jn_搜毒", 0);
            root.put("jn_搜救", 0);
            root.put("jn_其他", 0);
            root.put("sy_刑侦", 0);
            root.put("sy_巡逻", 0);
            root.put("cq_安检出勤", 0);
            root.put("qt_cq", 0);
            root.put("sy_刑侦", 0);
            root.put("sy_巡逻", 0);
            root.put("sy_安检", 0);
            root.put("sy_其他", 0);
            root.put("work_刑侦", 0);
            root.put("work_巡逻", 0);
            root.put("work_安检", 0);
            root.put("work_其他", 0);
            root.put("pa_一般", 0);
            root.put("pa_重特大", 0);
            root.put("workUnit", params.get("workUnit"));
            root.put("tbrq", new SimpleDateFormat("YYYY-MM-dd").format(System.currentTimeMillis()));
            root.put("shr", "");
            root.put("tbr", "");
            long ry_total = 0;
            for (int i = 0; i < list.size(); i++) {
                Map map = list.get(i);
                String k = (String)map.get("tName");
                if(k.equals("ry_民警") || k.equals("ry_辅警")){
                    long n = (Long)map.get("qty");
                    ry_total += n;
                }
                Object v = map.get("qty");
                root.put(k, v);
            }
            root.put("ry_qty", ry_total);

            String yearMonth = (String)params.get("startDate");
            yearMonth = yearMonth.replace("-", "").substring(0, 6);
            root.put("yearMonth", yearMonth);

            String path = "/export/" + new SimpleDateFormat("YYYYMMdd").format(System.currentTimeMillis()) + "/JiShuGongZuo_"+new SimpleDateFormat("YYYYMMddHHmmss").format(System.currentTimeMillis())+".xls";
            File dist = new File(myProps.getUploadFilePath() + path);
            dist.getParentFile().mkdirs();
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dist), "utf-8"));//生产文件输出流

            template.process(root, out);//将模板写到文件中
            out.flush();

            resultVO.setResult("/policeDog/resource" + path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
        return resultVO;
    }

    @RequestMapping("/exportFbAjData")
    public ResultVO exportFbAjData(@RequestBody DogWorkVO dogWorkVO){
        ResultVO resultVO = ResultVO.getInstance();
        Configuration con = new Configuration();
        Writer out = null;
        try {
            List<DogWorkVO> list = dogWorkDao.getList(dogWorkVO, new PageVO());
            if(list.size() > 0){
                dogWorkVO = list.get(0);
            }
            con.setDirectoryForTemplateLoading(new File(myProps.getUploadFilePath() + "/template"));//指定加载模板的位置
            con.setObjectWrapper(new DefaultObjectWrapper());//指定生产模板的方式
            con.setDefaultEncoding("utf-8");//设置模板读取的编码方式，用于处理乱码
            con.setClassicCompatible(true);

            Template template = con.getTemplate("fb_anjian.xml");//模板文件，可以是xml,ftl,html
            template.setEncoding("utf-8");//设置写入模板的编码方式

            String path = "/export/" + new SimpleDateFormat("YYYYMMdd").format(System.currentTimeMillis()) + "/FangBaoAnJian_"+new SimpleDateFormat("YYYYMMddHHmmss").format(System.currentTimeMillis())+".xls";
            File dist = new File(myProps.getUploadFilePath() + path);
            dist.getParentFile().mkdirs();
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dist), "utf-8"));//生产文件输出流

            template.process(dogWorkVO, out);//将模板写到文件中
            out.flush();
            resultVO.setResult("/policeDog/resource" + path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (Exception e) {
            }
        }
        return resultVO;
    }

}

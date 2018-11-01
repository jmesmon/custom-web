package com.chxd.policeDog.vo;

import java.util.Date;
import java.util.List;

/**
 * 警犬基本信息表
 * Created by cheng on 2017/8/15.
 */
public class DogBaseInfoVO extends BaseVO {
    private static final long serialVersionUID = -4631461102580927830L;

    private String  dogName;	//犬名
    private String  dogNameLike;	//犬名
    private String nestNo; //窝编号
    private String  chipNo;	//芯片号
    private String  chipNoLike;	//芯片号
    private Date chipNoInject; //芯片注入日期
    private String chipNoInjectStr; //芯片注入日期
    private Integer  sex;	//性别（1：公，2：母）
    private Date  birthday;	//出生日期
    private String  birthdayStr;	//出生日期
    private String  birthdayStart;
    private String  birthdayEnd;
    private String  breed;	//犬品种
    private String  dogSource;	//来源
    private String  dogColour;	//毛色
    private String  hairType;	//毛型
    private Integer  dogType;	//类型（1：工作犬，2：非工作犬）
    private Integer  dogLevel;	//犬种等级（1、2、3）
    private String  inbreeding;	//近交系数
    private String  tutor;	//训导员
    private String breeder; //繁育员
    private String  trainScore;	//复训成绩（优秀、合格、不合格）
    private Date  nextTrainDate;	//下次复训时间（yyyy-mm-dd）
    private String  nextTrainDateStr;	//下次复训时间（yyyy-mm-dd）
    private String  workPlace;	//工作单位（与人员信息关联自动生成）
    private String  workCity;	//所属片区
    private String  workArea;	//所属片区
    private String  workProvince;	//省区市
    private String  fileNo;	//警犬档案号
    private Date createDocDate;	//建档日期（YYYY-MM-dd）
    private String createDocDateStr;	//建档日期（YYYY-MM-dd）
    private String  dogPhoto;	//外貌特征（照片）
    private String  fatherId;	//父亲id
    private String  motherId;	//母亲id
    private Integer  growthStage;	//成长阶段（1：幼犬，2：成犬）
    private Integer  workStage;	//工作状态（1：待申领，2：已被申领，3：被淘汰，4：死亡）
//    private Integer  workSta11;	//工作状态（1：在训，2：在职，3：被淘汰，4：死亡，5：后备，6：退役）
    private String  belonging;	//淘汰/退休归属
    private String policeId;
    private String policeName;
    private String policeNameLike;
    private Long uid;

    private String isSign;
    private Date lastSignDate;
    private String lastSignDateStr;

    private List<DogTrainVO> trainInfo;
    private List<WormImmueInfoVO> wormImmueInfo;
    private String dogPros;

    private String rewardInfo; //立功受奖信息

    private String dogPro;
    private String mainPro;
    private String mainProLike;
    private String fatherName;
    private String motherName;

    private String dieReason;
    private String sickDate;
    private String cureDetail;
    private String dieDate;


    private Integer state; // 1: 在训、在职、后备；2：


    public DogBaseInfoVO() {

    }

    public String getSickDate() {
        return sickDate;
    }

    public void setSickDate(String sickDate) {
        this.sickDate = sickDate;
    }

    public String getDieReason() {
        return dieReason;
    }

    public void setDieReason(String dieReason) {
        this.dieReason = dieReason;
    }

    public String getCureDetail() {
        return cureDetail;
    }

    public void setCureDetail(String cureDetail) {
        this.cureDetail = cureDetail;
    }

    public String getDieDate() {
        return dieDate;
    }

    public void setDieDate(String dieDate) {
        this.dieDate = dieDate;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public DogBaseInfoVO(int id) {
        this.id = id;
    }

    public String getPoliceNameLike() {
        return policeNameLike;
    }

    public void setPoliceNameLike(String policeNameLike) {
        this.policeNameLike = policeNameLike;
    }

    public String getMainProLike() {
        return mainProLike;
    }

    public void setMainProLike(String mainProLike) {
        this.mainProLike = mainProLike;
    }

    public String getDogPro() {
        return dogPro;
    }

    public void setDogPro(String dogPro) {
        this.dogPro = dogPro;
    }

    public String getDogPros() {
        return dogPros;
    }

    public void setDogPros(String dogPros) {
        this.dogPros = dogPros;
    }

    public String getIsSign() {
        return isSign;
    }

    public void setIsSign(String isSign) {
        this.isSign = isSign;
    }

    public Date getLastSignDate() {
        return lastSignDate;
    }

    public void setLastSignDate(Date lastSignDate) {
        this.lastSignDate = lastSignDate;
    }

    public String getLastSignDateStr() {
        return lastSignDateStr;
    }

    public void setLastSignDateStr(String lastSignDateStr) {
        this.lastSignDateStr = lastSignDateStr;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getDogNameLike() {
        return dogNameLike;
    }

    public void setDogNameLike(String dogNameLike) {
        this.dogNameLike = dogNameLike;
    }

    public String getMainPro() {
        return mainPro;
    }

    public void setMainPro(String mainPro) {
        this.mainPro = mainPro;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public List<DogTrainVO> getTrainInfo() {
        return trainInfo;
    }

    public void setTrainInfo(List<DogTrainVO> trainInfo) {
        this.trainInfo = trainInfo;
    }

    public List<WormImmueInfoVO> getWormImmueInfo() {
        return wormImmueInfo;
    }

    public void setWormImmueInfo(List<WormImmueInfoVO> wormImmueInfo) {
        this.wormImmueInfo = wormImmueInfo;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getPoliceName() {
        return policeName;
    }

    public void setPoliceName(String policeName) {
        this.policeName = policeName;
    }

    public DogBaseInfoVO(String chipNo) {
        this.chipNo = chipNo;
    }

    public String getBirthdayStart() {
        return birthdayStart;
    }

    public void setBirthdayStart(String birthdayStart) {
        this.birthdayStart = birthdayStart;
    }

    public String getBirthdayEnd() {
        return birthdayEnd;
    }

    public void setBirthdayEnd(String birthdayEnd) {
        this.birthdayEnd = birthdayEnd;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getChipNo() {
        return chipNo;
    }

    public DogBaseInfoVO setChipNo(String chipNo) {
        this.chipNo = chipNo;
        return this;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDogSource() {
        return dogSource;
    }

    public void setDogSource(String dogSource) {
        this.dogSource = dogSource;
    }

    public String getDogColour() {
        return dogColour;
    }

    public void setDogColour(String dogColour) {
        this.dogColour = dogColour;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }

    public Integer getDogType() {
        return dogType;
    }

    public void setDogType(Integer dogType) {
        this.dogType = dogType;
    }

    public Integer getDogLevel() {
        return dogLevel;
    }

    public void setDogLevel(Integer dogLevel) {
        this.dogLevel = dogLevel;
    }

    public String getInbreeding() {
        return inbreeding;
    }

    public void setInbreeding(String inbreeding) {
        this.inbreeding = inbreeding;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTrainScore() {
        return trainScore;
    }

    public void setTrainScore(String trainScore) {
        this.trainScore = trainScore;
    }

    public Date getNextTrainDate() {
        return nextTrainDate;
    }

    public void setNextTrainDate(Date nextTrainDate) {
        this.nextTrainDate = nextTrainDate;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getWorkArea() {
        return workArea;
    }

    public void setWorkArea(String workArea) {
        this.workArea = workArea;
    }

    public String getWorkProvince() {
        return workProvince;
    }

    public void setWorkProvince(String workProvince) {
        this.workProvince = workProvince;
    }

    public String getFileNo() {
        return fileNo;
    }

    public void setFileNo(String fileNo) {
        this.fileNo = fileNo;
    }

    public Date getCreateDocDate() {
        return createDocDate;
    }

    public void setCreateDocDate(Date createDocDate) {
        this.createDocDate = createDocDate;
    }

    public String getDogPhoto() {
        return dogPhoto;
    }

    public void setDogPhoto(String dogPhoto) {
        this.dogPhoto = dogPhoto;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public Integer getGrowthStage() {
        return growthStage;
    }

    public void setGrowthStage(Integer growthStage) {
        this.growthStage = growthStage;
    }

    public Integer getWorkStage() {
        return workStage;
    }

    public void setWorkStage(Integer workStage) {
        this.workStage = workStage;
    }

    public String getBelonging() {
        return belonging;
    }

    public void setBelonging(String belonging) {
        this.belonging = belonging;
    }

    public String getNestNo() {
        return nestNo;
    }

    public void setNestNo(String nestNo) {
        this.nestNo = nestNo;
    }

    public Date getChipNoInject() {
        return chipNoInject;
    }

    public void setChipNoInject(Date chipNoInject) {
        this.chipNoInject = chipNoInject;
    }

    public String getBreeder() {
        return breeder;
    }

    public String getChipNoInjectStr() {
        return chipNoInjectStr;
    }

    public void setChipNoInjectStr(String chipNoInjectStr) {
        this.chipNoInjectStr = chipNoInjectStr;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getNextTrainDateStr() {
        return nextTrainDateStr;
    }

    public void setNextTrainDateStr(String nextTrainDateStr) {
        this.nextTrainDateStr = nextTrainDateStr;
    }

    public String getCreateDocDateStr() {
        return createDocDateStr;
    }

    public void setCreateDocDateStr(String createDocDateStr) {
        this.createDocDateStr = createDocDateStr;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
    }

    public String getRewardInfo() {
        return rewardInfo;
    }

    public void setRewardInfo(String rewardInfo) {
        this.rewardInfo = rewardInfo;
    }

    public String getChipNoLike() {
        return chipNoLike;
    }

    public void setChipNoLike(String chipNoLike) {
        this.chipNoLike = chipNoLike;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

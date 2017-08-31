package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * 警犬基本信息表
 * Created by cheng on 2017/8/15.
 */
public class DogBaseInfoVO extends BaseVO {
    private static final long serialVersionUID = -4631461102580927830L;

    private String  dogName;	//犬名
    private String nestNo; //窝编号
    private String  chipNo;	//芯片号
    private Date chipNoInject; //芯片注入日期
    private String chipNoInjectStr; //芯片注入日期
    private Integer  sex;	//性别（1：公，2：母）
    private Date  birthday;	//出生日期
    private String  birthdayStr;	//出生日期
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
    private String  workArea;	//所属片区
    private String  workProvince;	//省区市
    private String  fileNo;	//警犬档案号
    private Date createDocDate;	//建档日期（YYYY-MM-dd）
    private String createDocDateStr;	//建档日期（YYYY-MM-dd）
    private String  dogPhoto;	//外貌特征（照片）
    private Integer  fatherId;	//父亲id
    private Integer  motherId;	//母亲id
    private Integer  growthStage;	//成长阶段（1：幼犬，2：成犬）
    private Integer  workStage;	//工作状态（1：待申领，2：已被申领，3：被淘汰，4：死亡）
    private String  belonging;	//淘汰/退休归属

    public DogBaseInfoVO() {

    }
    public DogBaseInfoVO(String nestNo) {
        this.nestNo = nestNo;
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

    public void setChipNo(String chipNo) {
        this.chipNo = chipNo;
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

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public Integer getMotherId() {
        return motherId;
    }

    public void setMotherId(Integer motherId) {
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
}

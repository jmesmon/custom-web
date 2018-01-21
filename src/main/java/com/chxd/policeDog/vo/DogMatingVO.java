package com.chxd.policeDog.vo;

import java.util.Date;

/**
 * Created by cheng on 2017/9/13.
 */
public class DogMatingVO extends BaseVO {
    private Integer fatherDogId;
    private Integer motherDogId;
    private String fatherDogChipNo;
    private String fatherDogName;
    private String motherDogChipNo;
    private String motherDogName;
    private Date mateDate;
    private String mateDateStr;
    private Date bMuDate;
    private String bMuDateStr;
    private Date expectDate;
    private String expectDateStr;
    private Integer breedCount;
    private Integer liveCount7;
    private Integer liveCount21;
    private Integer mateState;

    private DogBaseInfoVO fatherDogInfo;
    private DogBaseInfoVO motherDogInfo;

    public String getFatherDogName() {
        return fatherDogName;
    }

    public void setFatherDogName(String fatherDogName) {
        this.fatherDogName = fatherDogName;
    }

    public String getMotherDogName() {
        return motherDogName;
    }

    public void setMotherDogName(String motherDogName) {
        this.motherDogName = motherDogName;
    }

    public Integer getMateState() {
        return mateState;
    }

    public String getFatherDogChipNo() {
        return fatherDogChipNo;
    }

    public void setFatherDogChipNo(String fatherDogChipNo) {
        this.fatherDogChipNo = fatherDogChipNo;
    }

    public String getMotherDogChipNo() {
        return motherDogChipNo;
    }

    public void setMotherDogChipNo(String motherDogChipNo) {
        this.motherDogChipNo = motherDogChipNo;
    }

    public Date getMateDate() {
        return mateDate;
    }

    public void setMateDate(Date mateDate) {
        this.mateDate = mateDate;
//        this.mateDateStr = new SimpleDateFormat("YYYY-MM-dd").format( this.mateDate);
    }

    public String getMateDateStr() {
        return mateDateStr;
    }

    public void setMateDateStr(String mateDateStr) {
        this.mateDateStr = mateDateStr;
    }

    public Date getbMuDate() {
        return bMuDate;
    }

    public void setbMuDate(Date bMuDate) {
        this.bMuDate = bMuDate;
    }

    public String getbMuDateStr() {
        return bMuDateStr;
    }

    public void setbMuDateStr(String bMuDateStr) {
        this.bMuDateStr = bMuDateStr;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public String getExpectDateStr() {
        return expectDateStr;
    }

    public void setExpectDateStr(String expectDateStr) {
        this.expectDateStr = expectDateStr;
    }

    public Integer getBreedCount() {
        return breedCount;
    }

    public void setBreedCount(Integer breedCount) {
        this.breedCount = breedCount;
    }

    public Integer getLiveCount7() {
        return liveCount7;
    }

    public void setLiveCount7(Integer liveCount7) {
        this.liveCount7 = liveCount7;
    }

    public Integer getLiveCount21() {
        return liveCount21;
    }

    public void setLiveCount21(Integer liveCount21) {
        this.liveCount21 = liveCount21;
    }

    public DogBaseInfoVO getFatherDogInfo() {
        return fatherDogInfo;
    }

    public void setFatherDogInfo(DogBaseInfoVO fatherDogInfo) {
        this.fatherDogInfo = fatherDogInfo;
    }

    public DogBaseInfoVO getMotherDogInfo() {
        return motherDogInfo;
    }

    public void setMotherDogInfo(DogBaseInfoVO motherDogInfo) {
        this.motherDogInfo = motherDogInfo;
    }

    public void setMateState(Integer mateState) {
        this.mateState = mateState;
    }

    public Integer getFatherDogId() {
        return fatherDogId;
    }

    public void setFatherDogId(Integer fatherDogId) {
        this.fatherDogId = fatherDogId;
    }

    public Integer getMotherDogId() {
        return motherDogId;
    }

    public void setMotherDogId(Integer motherDogId) {
        this.motherDogId = motherDogId;
    }
}

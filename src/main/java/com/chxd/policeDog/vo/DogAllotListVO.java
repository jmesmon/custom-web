package com.chxd.policeDog.vo;

public class DogAllotListVO extends BaseVO {
    private static final long serialVersionUID = -5956592691467306163L;
    private String dogName;
    private String dogNameLike;
    private String breed;
    private String dogColor;
    private String hairType;
    private String sex;
    private String owner;
    private String workUnit;
    private String allotDate;
    private String remark;

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public String getHairType() {
        return hairType;
    }

    public void setHairType(String hairType) {
        this.hairType = hairType;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getAllotDate() {
        return allotDate;
    }

    public void setAllotDate(String allotDate) {
        this.allotDate = allotDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDogNameLike() {
        return dogNameLike;
    }

    public void setDogNameLike(String dogNameLike) {
        this.dogNameLike = dogNameLike;
    }
}

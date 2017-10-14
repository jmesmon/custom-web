package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/10/6.
 */
public class MyNoticeVO extends  BaseVO{
    private String  title;	//
    private String  policeId;	//
    private Integer  isRead;	//1：未读，2：已读，
    private String  noticeType;	//

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }
}

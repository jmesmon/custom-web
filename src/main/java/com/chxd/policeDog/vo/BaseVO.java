package com.chxd.policeDog.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by cheng on 2017/8/15.
 */
public class BaseVO implements Serializable{
    private static final long serialVersionUID = 650523797756755074L;

    protected Integer id;
    protected Date creationDate;	//	创建日期
    protected Date lastUpdateDate;	//	最后修改日期

    private List<UserRoleVO> roleList;
    private List<DogBaseInfoVO> dogList;
    private List<TodoVO> todoList;

    public List<UserRoleVO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRoleVO> roleList) {
        this.roleList = roleList;
    }

    public List<DogBaseInfoVO> getDogList() {
        return dogList;
    }

    public void setDogList(List<DogBaseInfoVO> dogList) {
        this.dogList = dogList;
    }

    public List<TodoVO> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TodoVO> todoList) {
        this.todoList = todoList;
    }

    protected Date now = new Date();

    public Integer getId() {
        return id;
    }

    public BaseVO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}

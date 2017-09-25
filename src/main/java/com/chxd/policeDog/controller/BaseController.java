package com.chxd.policeDog.controller;

import com.chxd.policeDog.vo.PoliceUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by cheng on 2017/9/26.
 */

public class BaseController {
    @Autowired
    protected ServletContext servletContext;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    protected final String USER_KEY = "USER";

    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    public void setUser(PoliceUserVO user ){
        session.setAttribute(USER_KEY, user);
    }

    public PoliceUserVO getCurrentUser(){
        return (PoliceUserVO) session.getAttribute(USER_KEY);
    }
}

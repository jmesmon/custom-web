package com.chxd.policeDog.controller;

import com.chxd.policeDog.config.MyProps;
import com.chxd.policeDog.ueditor.ActionEnter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by cheng on 2017/9/26.
 */
@RestController
@RequestMapping("/ueditor")
public class UEditorController extends BaseController {
    @Autowired
    private MyProps myProps;

    @ResponseBody
    @RequestMapping("/controller")
    public void controller(){
        try {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type" , "text/html");
            String rootPath = servletContext.getRealPath( "/" );
            rootPath = myProps.getUploadFilePath();
            response.getWriter().write( new ActionEnter( request, rootPath ).exec() );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

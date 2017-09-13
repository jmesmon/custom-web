package com.chxd.policeDog.utils;

import com.alibaba.fastjson.JSON;
import com.chxd.policeDog.vo.DogBaseInfoVO;
import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
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

            List reportresult = new ArrayList();
            Map rep = new HashMap();

            rep.put("dogName", "统计设备一");
            rep.put("chipNo", "192.168.6.64");
            rep.put("test3", "30");
            rep.put("test4", "20");
            rep.put("test5", "10");

            reportresult.add(rep);
            root.put("reportresult", reportresult);

            root.put("year", 2017);
            root.put("month", 6);

            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("E://001//export//s.doc" +
                    "")), "utf-8"));//生产文件输出流


            List li = Lists.newArrayList();
            for (int i = 0; i < 10; i++) {
                DogBaseInfoVO dog = new DogBaseInfoVO();
                dog.setNestNo("122121" + i);
                dog.setDogName("黑虎" + i);
                dog.setChipNo("2323_" + i);

                Object o = JSON.toJSON(dog);

                li.add(o);
            }
            root.put("dogList", li);
            template.process(root, out);//将模板写到文件中
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}  
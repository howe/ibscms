package com.ibscms.extend.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibscms.extend.entity.Test;
import com.ibscms.extend.service.TestFrontService;

@Controller
public class TestBackgroundAct {

    @Autowired
    private TestFrontService testFrontService;

    @RequestMapping(value = "/backgroundtest.do")
    public void test(HttpServletRequest request) {

        Test test = testFrontService.getTest(1);
        System.out.println("当前用户名：" + test.getName());

    }

}

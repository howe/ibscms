package com.ibscms.extend.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.ibscms.extend.entity.Test;
import com.ibscms.extend.service.TestFrontService;
import com.jeecms.cms.entity.main.CmsSite;
import com.jeecms.cms.web.CmsUtils;
import com.jeecms.cms.web.FrontUtils;

@Controller
public class TestFrontAct {

    @Autowired
    private TestFrontService testFrontService;

    @RequestMapping(value = "/fronttest.jspx", method = RequestMethod.GET)
    public String test(HttpServletRequest request, ModelMap model) {

        ServletContext sc = request.getSession().getServletContext();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
        TestFrontService tmp = ac.getBean(TestFrontService.class);
        if (tmp != null) {
            System.out.println("TestFrontService服务已经启动~~~~~");
        }

        Test test = testFrontService.getTest(1);
        model.addAttribute("name", test.getName());

        CmsSite site = CmsUtils.getSite(request);
        String sol = site.getSolutionPath();
        FrontUtils.frontData(request, model, site);

        return FrontUtils.getTplPath(request, sol, "test", "tpl.test");

    }

}

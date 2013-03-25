package com.ibscms.extend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ibscms.extend.dao.mybatis.TestDao;
import com.ibscms.extend.entity.Test;

@Component
@Transactional(readOnly = true)
public class TestFrontService {

    @Autowired
    private TestDao testDao;

    public Test getTest(int id) {
        return testDao.get(id);
    }

}

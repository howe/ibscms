package com.ibscms.extend.dao.mybatis;

import com.ibscms.extend.entity.Test;

@MyBatisRepository
public interface TestDao {

    Test get(int id);

}

package com.springboot.database;

import com.springboot.database.domain.Girl;
import com.springboot.database.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: database
 * @description: 对Service进行测试
 * @author: JunOba
 * @create: 2018-12-07 21:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(18);
        Assert.assertEquals(new Integer(15), girl.getAge());
    }

}

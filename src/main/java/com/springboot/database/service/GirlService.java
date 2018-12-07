package com.springboot.database.service;

import com.springboot.database.domain.Girl;
import com.springboot.database.exception.GirlException;
import com.springboot.database.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回“年龄小于 10”
            throw new GirlException(100, "年龄小于 10");
        } else if (age > 10 && age < 16) {
            // 返回“年龄在 10~16 岁之间”
            throw new GirlException(101, "年龄在 10~16 岁之间");
        }

        // 其他操作
        // ...

    }
}

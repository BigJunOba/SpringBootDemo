package com.springboot.database.service;

import com.springboot.database.domain.Girl;
import com.springboot.database.enums.ResultEnum;
import com.springboot.database.exception.GirlException;
import com.springboot.database.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

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
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            // 返回“年龄在 10~16 岁之间”
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }

        // 其他操作
        // ...

    }

    /**
    * @Description: 通过Id查询一个女生的信息
    * @Param: Id
    * @return: 查询到的女生的信息
    * @Author: JunOba
    * @Date: 2018/12/7
    */
    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }
}

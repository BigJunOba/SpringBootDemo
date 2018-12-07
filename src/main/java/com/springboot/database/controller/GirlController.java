package com.springboot.database.controller;

import com.springboot.database.domain.Girl;
import com.springboot.database.repository.GirlRepository;
import com.springboot.database.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlsList() {
        return girlRepository.findAll();
    }

    @GetMapping(value = "/girls/query")
    public Girl girlFindOne(@PathParam("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PostMapping(value = "/girls/update/{id}")
    public Girl girlUpdateOne(@PathVariable("id") Integer id, @PathParam("cupSize") String cupSize, @PathParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRepository.save(girl);
    }

    @PostMapping(value = "/girls/add")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/delete/{id}")
    public void deleteOne(@PathVariable("id") Integer id){
        girlRepository.delete(id);
    }

    //通过年龄查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

}

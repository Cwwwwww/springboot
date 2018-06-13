package com.cw.controller;

import com.cw.entity.Girl;
import com.cw.entity.Result;
import com.cw.repository.GirlRepository;
import com.cw.service.GirlService;
import com.cw.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository repository;

    /**
     * 获得所有的Girl信息
     * @return
     */
    @GetMapping("/girls")
    public List<Girl> girlList() {
        return repository.findAll();
    }

    /**
     * 根据id查询Girl信息
     * @param id
     * @return
     */
    @GetMapping("/girls/{id}")
    public Girl girlId(@PathVariable("id") Integer id) {
        return repository.findById(id).get();
    }

    /**
     * 新增Girl信息
     * @param girl
     * @return
     */
//    @PostMapping("/girls")
//    public Girl girlAdd(@Valid Girl girl) {
//        Girl girl1 = new Girl(girl.getName(), girl.getAge(), girl.getAddress());
//        return repository.save(girl);
//    }

    /**
     * 规定格式下的新增Girl信息
     * @param girl
     * @param bindingResult
     * @return
     */
    @PostMapping("/girls")
    public Result girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        Result result = new Result();
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        Girl g = new Girl(girl.getName(), girl.getAge(), girl.getAddress());
        result = ResultUtil.success(g);
        return result;
    }

    /**
     * 更新一条Girl的信息
     * @param id
     * @param girl
     * @return
     */
    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id, @Valid Girl girl) {
        Girl girl1 = repository.findById(id).get();
        girl1.setName(girl.getName());
        girl1.setAge(girl.getAge());
        girl1.setAddress(girl.getAddress());
        return repository.save(girl1);
    }

    /**
     * 根据id删除Girl信息
     * @param id
     */
    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    /**
     * 在GirlRepository中自定义接口，通过年龄来查询Girl的信息
     * @param age
     * @return
     */
    @GetMapping("/girls/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return repository.findByAge(age);
    }

    @Autowired
    private GirlService service;

    /**
     * 配合GirlService中的@Transactional,具有事务管理的功能
     */
    @PostMapping("/girls/two")
    public void girlTwo() {
        service.insertTwo();
    }

    /**
     * 通过id获得Girl的age
     * @param id
     * @throws Exception
     */
    @GetMapping("/girls/getage/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        service.getAge(id);
    }
}

package com.cw.service;

import com.cw.entity.Girl;
import com.cw.enums.ResultEnum;
import com.cw.exception.GirlException;
import com.cw.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class GirlService {

    @Autowired
    private GirlRepository repository;

    @Transactional
    public void insertTwo() {
        Girl g1 = new Girl("girlA",12,"Yunnan");
        Girl g2 = new Girl("girlB", 19,"Huangshi");

        repository.save(g1);
        repository.save(g2);
    }

    /**
     * 通过id获取女生的年龄，然后对年龄进行区间判断
     * @param id
     * @throws Exception
     */
    public void getAge(Integer id) throws Exception {
        Girl girl = repository.findById(id).get();
        Integer age = girl.getAge();
        if (age < 10) {
            // 返回还在上小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if(age < 16) {
            // 返回还在上中学
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 通过id查询Girl的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return repository.findById(id).get();
    }
}

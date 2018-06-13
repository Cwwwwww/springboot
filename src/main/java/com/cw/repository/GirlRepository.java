package com.cw.repository;

import com.cw.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository  extends JpaRepository<Girl, Integer> {

    // 通过年龄来查找女生
    List<Girl> findByAge(Integer age);
}

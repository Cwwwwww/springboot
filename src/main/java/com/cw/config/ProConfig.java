package com.cw.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 使用在application.yml文件中自定义的字段
 */
@Component
@ConfigurationProperties(prefix = "cw")
public class ProConfig {

    private String name;

    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ProConfig{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

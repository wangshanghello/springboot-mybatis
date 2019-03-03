package com.constrpro.entity;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.entity
 * @ClassName: Project
 * @Author: 王尚
 * @Date: 2019/2/25 15:40
 * @Version: 1.0
 */
public class Project {

    private Integer id;
    private String name;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

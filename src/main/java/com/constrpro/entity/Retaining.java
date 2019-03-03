package com.constrpro.entity;

import java.util.Date;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.entity
 * @ClassName: MonitoringQuality
 * @Author: 王尚
 * @Date: 2019/2/22 10:12
 * @Version: 1.0
 */
public class Retaining {
    private Integer reid;
    private String rename;
    private String revalue;
    private String retime;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getRevalue() {
        return revalue;
    }

    public void setRevalue(String revalue) {
        this.revalue = revalue;
    }

    public String getRetime() {
        return retime;
    }

    public void setRetime(String retime) {
        this.retime = retime;
    }

    @Override
    public String toString() {
        return "Retaining{" +
                "reid=" + reid +
                ", rename='" + rename + '\'' +
                ", revalue='" + revalue + '\'' +
                ", retime='" + retime + '\'' +
                '}';
    }
}

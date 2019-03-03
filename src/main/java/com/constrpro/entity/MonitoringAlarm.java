package com.constrpro.entity;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.entity
 * @ClassName: MonitoringAlarm
 * @Author: 王尚
 * @Date: 2019/2/21 11:41
 * @Version: 1.0
 */
public class MonitoringAlarm {
    /**
     * 监测报警实体类
     */
    private Integer alaid;
    private String alaname;
    private Integer alavalue;

    public Integer getAlaid() {
        return alaid;
    }

    public void setAlaid(Integer alaid) {
        this.alaid = alaid;
    }

    public String getAlaname() {
        return alaname;
    }

    public void setAlaname(String alaname) {
        this.alaname = alaname;
    }

    public Integer getAlavalue() {
        return alavalue;
    }

    public void setAlavalue(Integer alavalue) {
        this.alavalue = alavalue;
    }

}

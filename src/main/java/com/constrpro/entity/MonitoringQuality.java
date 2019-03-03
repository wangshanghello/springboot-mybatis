package com.constrpro.entity;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.entity
 * @ClassName: MonitoringQuality
 * @Author: 王尚
 * @Date: 2019/2/22 10:12
 * @Version: 1.0
 */
public class MonitoringQuality {
    private Integer quaid;
    private String quaname;
    private String maxvalue;
    private String alarmvalue;
    private String maxrate;

    public Integer getQuaid() {
        return quaid;
    }

    public void setQuaid(Integer quaid) {
        this.quaid = quaid;
    }

    public String getQuaname() {
        return quaname;
    }

    public void setQuaname(String quaname) {
        this.quaname = quaname;
    }

    public String getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(String maxvalue) {
        this.maxvalue = maxvalue;
    }

    public String getAlarmvalue() {
        return alarmvalue;
    }

    public void setAlarmvalue(String alarmvalue) {
        this.alarmvalue = alarmvalue;
    }

    public String getMaxrate() {
        return maxrate;
    }

    public void setMaxrate(String maxrate) {
        this.maxrate = maxrate;
    }
}

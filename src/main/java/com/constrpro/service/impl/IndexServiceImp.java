package com.constrpro.service.impl;

import com.constrpro.entity.MonitoringAlarm;
import com.constrpro.entity.MonitoringQuality;
import com.constrpro.entity.Project;
import com.constrpro.entity.Retaining;
import com.constrpro.mapper.UserMapper;
import com.constrpro.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.service.impl
 * @ClassName: IndexServiceImp
 * @Author: 王尚
 * @Date: 2019/2/21 13:06
 * @Version: 1.0
 */
@Service
public class IndexServiceImp implements IndexService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<MonitoringAlarm> findAlarm() {
        return userMapper.findAlarm();
    }

    @Override
    public List<MonitoringQuality> findQuality() {
        return userMapper.findQuality();
    }

    @Override
    public List<Retaining> findRetaining() {
        return userMapper.findRetaining();
    }

    @Override
    public List<Retaining> findRetaining1() {
        return userMapper.findRetaining1();
    }

    @Override
    public List<Retaining> findRetaining2() {
        return userMapper.findRetaining2();
    }
    @Override
    public List<Retaining> findRetaining3() {
        return userMapper.findRetaining3();
    }

    @Override
    public void updateRetaining() {
        userMapper.updateRetaining();
    }

    @Override
    public List<Project> findProject() {
        return userMapper.findProject();
    }

    @Override
    public void pushDataScheduled() {
        userMapper.pushDataScheduled();
    }
}

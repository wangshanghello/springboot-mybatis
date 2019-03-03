package com.constrpro.service;

import com.constrpro.entity.MonitoringAlarm;
import com.constrpro.entity.MonitoringQuality;
import com.constrpro.entity.Project;
import com.constrpro.entity.Retaining;

import java.util.List;

/**
 * @ProjectName: springboot-mybatis
 * @Package: com.constrpro.service
 * @ClassName: IndexService
 * @Author: 王尚
 * @Date: 2019/2/21 13:04
 * @Version: 1.0
 */
public interface IndexService {
    /* *
     * 功能描述:查询监测报警
     * @return
     * @throws
     * @param []
     * @date 2019/2/22 10:16
     * @author 王尚
     */
    List<MonitoringAlarm> findAlarm();

    /* *
     * 功能描述:查询质量监测值
     * @return
     * @throws
     * @param
     * @date 2019/2/22 10:17
     * @author 王尚
     */
    List<MonitoringQuality> findQuality();

    /* *
 * 功能描述: 查询维护墙顶竖向位移
 * @return
 * @throws
 * @param [u]
 * @date 2019/2/22 15:58
 * @author 王尚
 */
    List<Retaining> findRetaining();

    List<Retaining> findRetaining1();

    List<Retaining> findRetaining2();

    List<Retaining> findRetaining3();

    /* *
     * 功能描述: 随机数
     * @return
     * @throws
     * @param []
     * @date 2019/2/25 17:53
     * @author 王尚
     */
    void updateRetaining();

    /* *
     * 功能描述: 查询项目的值
     * @return
     * @throws
     * @param []
     * @date 2019/2/25 17:53
     * @author 王尚
     */
    List<Project> findProject();

    /* *
     * 功能描述: 定时任务
     * @return
     * @throws
     * @param []
     * @date 2019/2/28 10:01
     * @author 王尚
     */
    void pushDataScheduled();
}

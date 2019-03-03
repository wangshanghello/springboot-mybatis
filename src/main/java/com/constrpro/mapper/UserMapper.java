package com.constrpro.mapper;

import com.constrpro.entity.MonitoringAlarm;
import com.constrpro.entity.MonitoringQuality;
import com.constrpro.entity.Project;
import com.constrpro.entity.Retaining;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    /* *
     * 功能描述: 查询监测报警数据
     * @return
     * @throws
     * @param []
     * @date 2019/2/21 11:45
     * @author 王尚
     */
    @Select("SELECT ALAID,ALANAME,ALAVALUE FROM MONITORINGALARM")
    List<MonitoringAlarm> findAlarm();

    /* *
     * 功能描述: 查询质量监测值
     * @return
     * @throws
     * @param
     * @date 2019/2/22 10:18
     * @author 王尚
     */
    @Select("SELECT * FROM MONITORINGQUALITY")
    List<MonitoringQuality> findQuality();

    /* *
     * 功能描述: 查询维护墙顶竖向位移当天的数据
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author 王尚
     */
    @Select("SELECT A.* FROM RETAINING A WHERE TO_DAYS(NOW())-TO_DAYS(A.RETIME) = 0")
    List<Retaining> findRetaining();

    /* *
     * 功能描述: 查询维护墙顶竖向位移昨天的数据
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author 王尚
     */
    @Select("SELECT A.* FROM RETAINING A WHERE TO_DAYS(NOW())-TO_DAYS(A.RETIME) = 1 ")
    List<Retaining> findRetaining1();

    /* *
     * 功能描述: 查询维护墙顶竖向位移前天的数据
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author 王尚
     */
    @Select("SELECT A.* FROM RETAINING A WHERE TO_DAYS(NOW())-TO_DAYS(A.RETIME) = 2  ")
    List<Retaining> findRetaining2();

    /* *
     * 功能描述: 查询维护墙顶竖向位移三天内的时间
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author 王尚
     */
    @Select("SELECT SUBSTRING(A.RETIME,1,10) as RETIME FROM RETAINING A WHERE SUBSTRING(A.RETIME,1,10)>=DATE_SUB(NOW(),INTERVAL 3 DAY) GROUP BY SUBSTRING(A.RETIME,1,10) ")
    List<Retaining> findRetaining3();

    /* *
     * 功能描述: 给 维护墙顶竖向位移加入随机数
     * @return
     * @throws
     * @param []
     * @date 2019/2/26 16:21
     * @author 王尚
     */
    @Update("UPDATE retaining s SET s.revalue = (SELECT CAST(RAND()*100 AS signed) AS rand)WHERE SUBSTRING(s.RETIME,1,10)= DATE_FORMAT(NOW(),'%Y-%m-%d')")
    void updateRetaining();

    /* *
     * 功能描述: 查询项目占比的数据
     * @return
     * @throws
     * @param []
     * @date 2019/2/26 16:22
     * @author 王尚
     */
    @Select("SELECT A.* FROM Project A  ")
    List<Project> findProject();

    /* *
     * 功能描述: 定时任务
     * @return
     * @throws
     * @param
     * @date 2019/2/28 10:02
     * @author 王尚
     */
    @Update("UPDATE retaining A \n" +
            "SET A.retime = DATE_ADD( A.retime, INTERVAL 1 DAY ) \n" +
            "WHERE\n" +
            "\tSUBSTRING( A.RETIME, 1, 10 ) >= DATE_SUB(NOW( ), INTERVAL 4 DAY ) \n")
    void pushDataScheduled();
}

package com.constrpro.controller;

import com.alibaba.fastjson.JSON;
import com.constrpro.entity.*;
import com.constrpro.service.IndexService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author wangshang
 * @date 2019年2月24日/上午10:08:39
 * @类作用:
 */
//如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面
@Controller
public class IndexController {
    @Autowired
    private IndexService IndexService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    /* *
     * 功能描述:查询监测报警
     * @return
     * @throws
     * @param [request]
     * @date 2019/2/21 11:56
     * @author 王尚
     */
    @RequestMapping(value = "/findalarm", method = RequestMethod.POST)
    @ResponseBody
    public List<MonitoringAlarm> findAlarm() {
        try {
            List<MonitoringAlarm> alarm = IndexService.findAlarm();
            return alarm;
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
        return null;
    }
    /* *
     * 功能描述: 查询质量监测值
     * @return
     * @throws
     * @param
     * @date 2019/2/22 10:16
     * @author 王尚
     */

    @RequestMapping(value = "/findQuality", method = RequestMethod.POST)
    @ResponseBody
    public List<MonitoringQuality> findQuality() {
        try {
            List<MonitoringQuality> quality = IndexService.findQuality();

            return quality;
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
        return null;
    }

    /* *
     * 功能描述: 查询维护墙顶竖向位移
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author 王尚
     */
    @RequestMapping(value = "/findRetaining", method = RequestMethod.POST)
    @ResponseBody
    public List<Retaining> findRetaining() {
        try {
            List<Retaining> retaining = IndexService.findRetaining();
            return retaining;
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
    @RequestMapping("demo")
    public String demo() {
        return "addUser";
    }
    @RequestMapping(value = "/finddemo", method = RequestMethod.GET)
    @ResponseBody
    public String finddemo() {
        try {
            List<Retaining> retaining = IndexService.findRetaining();   //当天的数据
            List<Retaining> retaining1 = IndexService.findRetaining1(); //昨天的数据
            List<Retaining> retaining2 = IndexService.findRetaining2(); //前天的数据
            List<Retaining> retime = IndexService.findRetaining3();//取三天的时间

            MiddleBaseVo m = new MiddleBaseVo();
            m.setSameResult(retaining);
            m.setYesterResult(retaining1);
            m.setBeforeResult(retaining2);
            m.setTimeResult(retime);
            return JSON.toJSONString(m);
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/updateRetaining", method = RequestMethod.POST)
    public void updateRetaining() {
        try {
            //向数据库插入随机数
            IndexService.updateRetaining();
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/findProject", method = RequestMethod.GET)
    @ResponseBody
    public List<Project> findProject() {
        try {
            List<Project> project = IndexService.findProject();
            return project;
        } catch (Exception e) {
            logger.info("查询质量监测值异常...");
            e.printStackTrace();
        }
        return null;

    }

    /* *
     * 功能描述: 定时任务 每天凌晨1点会自动把前三天的日期+1
     * @return
     * @throws
     * @param []
     * @date 2019/2/28 10:00
     * @author 王尚
     */
    @RequestMapping(value = "/pushDataScheduled")
    @Scheduled(cron = "0 0 1 * *  ?")
    public void pushDataScheduled() {
        logger.info("start push data scheduled!");
        IndexService.pushDataScheduled();
        logger.info("end push data scheduled!");
    }
}

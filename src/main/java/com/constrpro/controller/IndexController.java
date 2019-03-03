
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
 * @date 2019��2��24��/����10:08:39
 * @������:
 */
//���ֻ��ʹ��@RestControllerע��Controller����Controller�еķ����޷�����jspҳ��
@Controller
public class IndexController {
    @Autowired
    private IndexService IndexService;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(IndexController.class);

    /* *
     * ��������:��ѯ��ⱨ��
     * @return
     * @throws
     * @param [request]
     * @date 2019/2/21 11:56
     * @author ����
     */
    @RequestMapping(value = "/findalarm", method = RequestMethod.POST)
    @ResponseBody
    public List<MonitoringAlarm> findAlarm() {
        try {
            List<MonitoringAlarm> alarm = IndexService.findAlarm();
            return alarm;
        } catch (Exception e) {
            logger.info("��ѯ�������ֵ�쳣...");
            e.printStackTrace();
        }
        return null;
    }
    /* *
     * ��������: ��ѯ�������ֵ
     * @return
     * @throws
     * @param
     * @date 2019/2/22 10:16
     * @author ����
     */

    @RequestMapping(value = "/findQuality", method = RequestMethod.POST)
    @ResponseBody
    public List<MonitoringQuality> findQuality() {
        try {
            List<MonitoringQuality> quality = IndexService.findQuality();

            return quality;
        } catch (Exception e) {
            logger.info("��ѯ�������ֵ�쳣...");
            e.printStackTrace();
        }
        return null;
    }

    /* *
     * ��������: ��ѯά��ǽ������λ��
     * @return
     * @throws
     * @param [u]
     * @date 2019/2/22 15:58
     * @author ����
     */
    @RequestMapping(value = "/findRetaining", method = RequestMethod.POST)
    @ResponseBody
    public List<Retaining> findRetaining() {
        try {
            List<Retaining> retaining = IndexService.findRetaining();
            return retaining;
        } catch (Exception e) {
            logger.info("��ѯ�������ֵ�쳣...");
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
            List<Retaining> retaining = IndexService.findRetaining();   //���������
            List<Retaining> retaining1 = IndexService.findRetaining1(); //���������
            List<Retaining> retaining2 = IndexService.findRetaining2(); //ǰ�������
            List<Retaining> retime = IndexService.findRetaining3();//ȡ�����ʱ��

            MiddleBaseVo m = new MiddleBaseVo();
            m.setSameResult(retaining);
            m.setYesterResult(retaining1);
            m.setBeforeResult(retaining2);
            m.setTimeResult(retime);
            return JSON.toJSONString(m);
        } catch (Exception e) {
            logger.info("��ѯ�������ֵ�쳣...");
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "/updateRetaining", method = RequestMethod.POST)
    public void updateRetaining() {
        try {
            //�����ݿ���������
            IndexService.updateRetaining();
        } catch (Exception e) {
            logger.info("��ѯ�������ֵ�쳣...");
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
            logger.info("��ѯ�������ֵ�쳣...");
            e.printStackTrace();
        }
        return null;

    }

    /* *
     * ��������: ��ʱ���� ÿ���賿1����Զ���ǰ���������+1
     * @return
     * @throws
     * @param []
     * @date 2019/2/28 10:00
     * @author ����
     */
    @RequestMapping(value = "/pushDataScheduled")
    @Scheduled(cron = "0 0 1 * *  ?")
    public void pushDataScheduled() {
        logger.info("start push data scheduled!");
        IndexService.pushDataScheduled();
        logger.info("end push data scheduled!");
    }
}

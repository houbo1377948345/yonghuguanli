package com.itheima.web.scheduletask;

import com.itheima.dao.StatisticMapper;
import com.itheima.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//定时任务管理
@Component
public class ScheduleTask {
    @Autowired
    private StatisticMapper statisticMapper;
    @Autowired
    private MailUtils mailUtils;
    @Value("${spring.mail.username}")
    private String mailto;

    //定时邮件发送任务，每天12点整发送邮件
    @Scheduled(cron = "0 19 11 * * ?")
    public void sendEmail(){
        //  定制邮件内容
        long totalvisit = statisticMapper.getTotalVisit();
        long totalComment = statisticMapper.getTotalComment();
        StringBuffer content = new StringBuffer();
        content.append("博客系统总访问量为："+totalvisit+"人次").append("\n");
        content.append("博客系统总评论量为："+totalComment+"人次").append("\n");
        mailto="1377948345@qq.com";//这里改为你要发送的邮箱,比如自己的邮箱
        mailUtils.sendSimpleEmail(mailto,"个人博客系统流量统计情况",content.toString());
    }
}
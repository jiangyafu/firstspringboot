package com.jyf.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Component
public class TestTask {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    //定义时间任务 毫秒 http://cron.qqe2.com/
//    @Scheduled(fixedRate = 3000)
//    @Scheduled(cron = "6-40 * * * * ? ")
    public void reportCurrentTime(){
        System.out.println("DATE_FORMAT = " + DATE_FORMAT.format(new Date()));
    }
}

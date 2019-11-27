package com.jyf.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * 发送短信  发送邮件   app消息推送     节省运维凌晨发布任务时间提供效率
 * 异步任务
 */
@RestController
@RequestMapping("/tasks")
public class DoTask {
    @Autowired
    private AsyncTask asyncTask;

    @RequestMapping("/test1")
    public String test1() throws Exception {
        long start = System.currentTimeMillis();
        Future<Boolean> a = asyncTask.doTask11();
        Future<Boolean> b = asyncTask.doTask22();
        Future<Boolean> c = asyncTask.doTask33();
        while (!a.isDone() || !b.isDone() || !c.isDone()){
            if(a.isDone() && b.isDone() && c.isDone()){
                break;
            }
        }
        long end = System.currentTimeMillis();
        String time = "任务完成用时："+(end - start)+"毫秒";
        System.out.println("time = " + time);
        return time;
    }
}

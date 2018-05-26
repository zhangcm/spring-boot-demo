package com.study.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author zhangcm
 * @since 1.0, 2017/10/13 上午10:07
 */
@Component
public class AsyncTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Async("simpleExecutor")
    public Future<String> doTask1() {
        logger.info("Task1 started");
        long start = System.currentTimeMillis();
        sleep(5000);
        long end = System.currentTimeMillis();
        logger.info("Task1 finished, time elapsed: " + (end - start) + " ms");
        return new AsyncResult<String>("Task1 accomplished");
    }

    @Async("customExecutor")
    public Future<String> doTask2() {
        logger.info("Task2 started");
        long start = System.currentTimeMillis();
        sleep(3000);
        long end = System.currentTimeMillis();
        logger.info("Task2 finished, time elapsed: " + (end - start) + " ms");
        return new AsyncResult<String>("Task2 accomplished");
    }

    @Async
    public Future<String> doTask3() {
        logger.info("Task3 started");
        long start = System.currentTimeMillis();
        sleep(4000);
        long end = System.currentTimeMillis();
        logger.info("Task3 finished, time elapsed: " + (end - start) + " ms");
        return new AsyncResult<String>("Task3 accomplished");
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

package com.study;

import com.study.task.AsyncTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zhangcm
 * @since 1.0, 2017/10/13 上午9:56
 */
@SpringBootApplication
@EnableAsync
public class AsyncDemoApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ApplicationContext ctx = SpringApplication.run(AsyncDemoApplication.class, args);

        AsyncTask asyncTask = ctx.getBean(AsyncTask.class);

        Future<String> task1 = asyncTask.doTask1();
        Future<String> task2 = asyncTask.doTask2();
        Future<String> task3 = asyncTask.doTask3();

        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                System.out.println("Task1 result: " + task1.get());
                System.out.println("Task2 result: " + task2.get());
                System.out.println("Task3 result: " + task3.get());
                break;
            }
        }

        System.out.println("All tasks finished");
    }

}

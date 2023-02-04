package com.seamew.创建线程的三种方法;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j(topic = "c.TreadCreationTest")
public class TreadCreationTest
{
    @Test
    public void testCreateThread1()
    {
        // 使用继承 Thread 类的方法来创建线程
        new Thread("t1") {
            @Override
            public void run() {
                log.debug("Thread t1 is running");
            }
        }.start();
        log.debug("Thread main is running");
    }

    @Test
    public void testCreateThread2()
    {
        // 实现 Runnable 接口创建线程
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.debug("Runnable target is running");
            }
        };
        new Thread(runnable, "t1").start();
        log.debug("Thread main is running");
    }

    @Test
    public void testCreateThread3()
    {
        // 通过 lambda 表达式实现 Runnable 接口的方式来创建线程，这个方法是方法 2 的简化版
        new Thread(() -> log.debug("Lambda runnable target is running"), "t1").start();
        log.debug("Thread main is running");
    }
}

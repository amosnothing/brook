package com.amos.common;


import com.amos.Factory;

/**
 * 测试多线程情况下，aBuilder的入参put到bBuilder里面去的情况
 * 或者 aBuilder调用了clear导致bBuilder里面的入参被清空的情况
 *
 * @author chenjun
 * @date 2020/6/7 11:01
 */
public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            int count = 0;
            int loop = 100;
            for (int i = loop; i > 0; i--) {
                String phone = Factory.phoneBuilder().withPhone(threadName).build();
                boolean bl = threadName.equals(phone);
                if (!bl) {
                    System.out.println("Thread: " + threadName + ", loop:" + i + ", phone:" + phone);
                    count++;
                }
                // 让线程睡眠一会
                Thread.sleep(5);
            }
            System.out.println("线程冲突次数：" + count);
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        ThreadDemo t1 = new ThreadDemo("t1");
        ThreadDemo t2 = new ThreadDemo("t2");
        t1.start();
        t2.start();
    }
}

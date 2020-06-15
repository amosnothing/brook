package com.amos.example;


import com.amos.Factory;

/**
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
            int count1 = 0;
            int count2 = 0;
            int loop = 100;
            for (int i = loop; i > 0; i--) {
                // 往map中put线程名
                String phone = Factory.phoneBuilder().withPhone(threadName).build();
                // 判断当前实际线程名和从map中get到的线程名是否一致
                boolean flag1 = threadName.equals(phone);
                if (!flag1) {
                    System.out.println("Thread: " + threadName + ", loop:" + i + ", phone:" + phone);
                    count1++;
                }
                String name = Factory.nameBuilder().withName(threadName).build();
                // 判断当前实际线程名和从map中get到的线程名是否一致
                boolean flag2 = threadName.equals(name);
                if (!flag2) {
                    System.out.println("Thread: " + threadName + ", loop:" + i + ", name:" + name);
                    count2++;
                }
                Thread.sleep(5);
            }
            System.out.println("Thread:" + threadName + ", phone冲突次数：" + count1);
            System.out.println("Thread:" + threadName + ", name冲突次数：" + count2);
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

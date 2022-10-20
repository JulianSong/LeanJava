package lean.thread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class LeanRunnable implements Runnable {
    Thread t;
    @Override
    public void run() {
        try {
            System.out.println("Do some thing via Runnable");
            Thread.sleep(300);
            System.out.println("Some thing is done via Runnable");
        }catch (Exception e) {

        }
    }

    public void start(){
        if (t == null) {
            t = new Thread(this,"LeanRunnable");
        }
    }
}

class LeanCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(6000);
        System.out.println("Thread:" + Thread.currentThread().getName());
        return "My nam is z";
    }
}

class Counter {
    public static Counter lock = new Counter();
    public  static long count = 0;
}

class Increase extends  Thread {
    public  static List<Increase> increases = new ArrayList<>();
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (Counter.lock) {
                Counter.count ++;
                System.out.println("Increase " + this.getName() +  " Counter is " + Counter.count);
                for (Increase ice :increases) {
                    if (ice != this) {
                        System.out.println("State of thread " + ice.getName() + " is " + ice.getState());
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void runIncrease() throws InterruptedException {
        for (int i = 0; i < 4; i++) {
            Increase ice = new Increase();
            ice.setName("Increase" + i);
            Increase.increases.add(ice);
        }
        for (Increase increase : Increase.increases) {
            increase.start();
            increase.join();
        }
    }
}

public class LeanThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Do some thing via via Thread");
            Thread.sleep(1000);
            System.out.println("Some thing is done via Thread");
        }catch (Exception e) {

        }
    }

    public static void runThread() {
        LeanRunnable lr = new LeanRunnable();
        lr.start();
        LeanThread lt = new LeanThread();
        lt.start();
    }

    public static void runCallable() {
        System.out.println("Thread:" + Thread.currentThread().getName() + " runCallable -- start ");
        LeanCallable lc = new LeanCallable();
        FutureTask<String> ft = new FutureTask(lc);
        Thread t = new Thread(ft);
        t.setName("TestCallable");
        t.start();
        System.out.println("Thread:" + Thread.currentThread().getName() + " runCallable -- Thread.start");
        try{
            System.out.println("Thread:" + Thread.currentThread().getName() + " " + ft.get(1000,TimeUnit.MILLISECONDS));
        }catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Thread:" + Thread.currentThread().getName() + " runCallable -- end");
    }

    public static void runSync() {
        try {
            Increase.runIncrease();
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}

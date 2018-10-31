package com.kryocore.common.ThreadLocal;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

public class ThreadLocalExample {
    public static void main(String[] args){
        //创建ThreadLocal实例
        ThreadLocal<Integer> tlocal = new ThreadLocal<>();
        IntStream.range(0,10).forEach(i -> new Thread(() ->{
            try{
                tlocal.set(i);
                System.out.println(currentThread() + " set i " + tlocal.get());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(currentThread() + " get i " + tlocal.get());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start()
        );

    }
}

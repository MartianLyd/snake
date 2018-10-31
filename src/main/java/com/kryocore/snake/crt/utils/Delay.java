package com.kryocore.snake.crt.utils;

import java.util.Random;

/**
 * Created by lvshimin on 2017/6/29.
 */
public class Delay {

    private static final String TAG = "[delay]";

    private static Random random = new Random();

    public static void delay(int x) {
        int delay = random.nextInt(x);
        doDelay(delay);
    }

    public static void delay(int base, int x) {
        int delay = random.nextInt(x) + base;
        doDelay(delay);
    }

    public static void delay1000(int x) {
        int delay = random.nextInt(x) + 1000;
        doDelay(delay);
    }

    public static void delay3000(int x) {
        int delay = random.nextInt(x) + 3000;
        doDelay(delay);
    }

    private static void doDelay(int delay) {
        try {
            Log.d(TAG, "延时:" + delay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

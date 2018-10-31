package com.kryocore.snake.crt.utils;

/**
 * Created by lvshimin on 2017/6/14.
 */
public class Log {

    private static final String TAG = "[Crawler]";

    public static void d(String msg) {
        System.out.println(TAG + msg);
    }

    public static void e(String msg) {
        System.err.println(TAG + msg);
    }

    public static void d(String tag, String msg) {
        System.out.println(TAG + tag + msg);
    }

    public static void e(String tag, String msg) {
        System.err.println(TAG + tag + msg);
    }


}

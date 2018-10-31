package com.kryocore.snake.crt.utils;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public class CrawlerErrorPropertiesUtil {

    public static Properties getProps() {
        init();
        return props;
    }

    public static void setProps(Properties props) {
        CrawlerErrorPropertiesUtil.props = props;
    }

    public static Properties props;

    private static final String name = "crawler_error.properties";


    private static void init() {

        InputStream in = null;

        try {

            in = new BufferedInputStream(new FileInputStream(name));
            props = new Properties();
            props.load(in);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void set(String key, String value) {

        FileOutputStream out = null;

        try {

            out = new FileOutputStream(name);

            if (props == null) {
                init();
            }

            props.setProperty(key, value);
            props.store(out, "");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public static String get(String key) {

        if (props == null) {
            init();
        }

        return props.getProperty(key);
    }

    public static void main(String[] args) {

//        System.out.println(CrawlerErrorPropertiesUtil.get("lastId"));
//
//        CrawlerErrorPropertiesUtil.set("lastId", String.valueOf(11));
//        CrawlerErrorPropertiesUtil.set("lastId2", String.valueOf("last.ssss"));
//        System.out.println(CrawlerErrorPropertiesUtil.get("lastId"));
//        System.out.println(CrawlerErrorPropertiesUtil.get("lastId2"));

        Enumeration<Object> keys = getProps().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = props.get(key).toString().replace("[null]","");

            System.out.println("key:" + key + ",value:" + value);
        }


    }

}

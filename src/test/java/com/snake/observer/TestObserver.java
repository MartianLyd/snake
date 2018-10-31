package com.snake.observer;

/**
 * 测试观察者模式
 * @author kryocore
 */
public class TestObserver {
    public static void main(String[] args){
        WechatServer ws = new WechatServer();
        Observer userZhang = new User("zhangsan");
        Observer userLi = new User("lisi");
        Observer userWang = new User("wangqiang");

        ws.registerObserver(userZhang);
        ws.registerObserver(userLi);
        ws.registerObserver(userWang);

        ws.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("=========================");

        ws.removeObserver(userLi);
        ws.setInfomation("JAVA是世界上最好用的语言！");

    }
}

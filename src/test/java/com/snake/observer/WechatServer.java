package com.snake.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口,对Observerable接口的三个方法进行了具体实现
 */
public class WechatServer implements Observerable {

    private List<com.snake.observer.Observer> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<com.snake.observer.Observer>();
    }

    @Override
    public void registerObserver(com.snake.observer.Observer o) {
        list.add(o);
    }

    @Override
    public void removeObserver(com.snake.observer.Observer  o) {
        if(!list.isEmpty()){
            list.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(int k = 0;k<list.size();k++){
            list.get(k).update(message);
        }
    }

    public void setInfomation(String message){
        this.message = message;
        System.out.println("微服务更新消息： " + message);
        notifyObserver();
    }
}

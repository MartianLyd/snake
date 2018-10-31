package com.snake.observer;

public class User implements Observer {

    private String name;
    private String message;

    public User(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        readMessage();
    }

    public void readMessage(){
        System.out.println(name + "收到推送消息： " + message);
    }
}

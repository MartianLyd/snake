package com.snake.observer;

/**
 * 抽象观察者
 * 定义了一个update方法，当被观察者调用notifyObservers()方法时，观察者的update方法会被调用
 * @author kryocore
 */
public interface Observer {
    public void update(String message);
}

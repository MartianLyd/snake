package com.snake.observer;

/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author kryocore
 */
public interface Observerable {

    public void registerObserver(com.snake.observer.Observer o);
    public void removeObserver(com.snake.observer.Observer o);
    public void notifyObserver();
}

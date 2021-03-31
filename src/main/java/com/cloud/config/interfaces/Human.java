package com.cloud.config.interfaces;

@FunctionalInterface
public interface Human {
    //抽象方法 需要被试下
    void eat(String name);

    // default修饰的默认方法，不需要被子类实现
    default void run(){
        System.out.println("I can run...");
    }
}

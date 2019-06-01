package com.weichao.exercise.aop;

/**
 * 目标对象
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHelloWorld() {
        System.out.println("hello world!");
    }
}

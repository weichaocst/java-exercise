package com.weichao.exercise.proxy;

/**
 * @author weichao
 * @Description
 * @date 2019/4/16 10:55
 */
public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String hi(String msg) {
        return "Hi, " + msg;
    }

}

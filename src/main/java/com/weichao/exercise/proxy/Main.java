package com.weichao.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author weichao
 * @Description
 * @date 2019/4/16 11:01
 */
public class Main {

    public static void main(String[] args) throws Exception{
        //生成代理类的Class对象
        Class<?> clazz = Proxy.getProxyClass(HelloService.class.getClassLoader(), HelloService.class);
        // 创建InvocationHandler
        InvocationHandler myInvocationHandler = new MyInvocationHandler(new HelloServiceImpl());
        HelloService f = (HelloService) clazz.getConstructor(InvocationHandler.class).newInstance(myInvocationHandler);
        f.hello("weichao");
        f.hi("haha");
    }
}

package com.weichao.exercise.aop;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 *  从测试类
 */
public class SimpleAOPTest {

    @Test
    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) Proxy.newProxyInstance(HelloServiceImpl.class.getClassLoader(),
                helloServiceImpl.getClass().getInterfaces(), beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}

package com.weichao.exercise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author weichao
 * @Description
 * @date 2019/4/16 10:56
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    MyInvocationHandler(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强逻辑
        System.out.println("PROXY : " + proxy.getClass().getName());

        // 反射调用，目标方法
        Object result = method.invoke(object, args);

        // 输出目标方法执行结果
        System.out.println(method.getName() + " : " + result);

        return result;

    }
}

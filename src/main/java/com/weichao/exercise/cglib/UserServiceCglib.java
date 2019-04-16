package com.weichao.exercise.cglib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;


/**
 * @author weichao
 * @Description
 * @date 2019/4/16 14:18
 */
public class UserServiceCglib implements MethodInterceptor {

    private Object object;

    public Object getInstance(Object object){
        this.object = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.object.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开始。。。");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("事务结束。。。");
        return result;
    }
}

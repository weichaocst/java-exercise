package com.weichao.exercise.ioc.simplespring;

/**
 * IOC容器顶层接口
 */
public interface BeanFactory {

    /**
     * 根据对象的名称标识来获取对象的实例
     * @param name 对象的名称
     * @return 指定名称的对象的实例
     */
    Object getBean(String name);
}

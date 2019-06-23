package com.weichao.exercise.ioc.simplespring;

import java.util.Map;

/**
 * 注册读取接口
 * 负责读取用户注册的对象
 * 继承该接口的类可以实现多种读取的方式，如配置文件读取，注解读取，网络读取
 */
public interface SourceReader {

    /**
     * 读取用户注册的对象信息
     * @param filePath 读取路径
     * @return 注册对象信息Map
     */
    Map<String,BeanInfo> loadBeans (String filePath);
}

package com.weichao.exercise.ioc.simplespring;

/**
 * 上下文构造方法
 * 该方法中指明注册读取器
 * 并在构造该方法时一次性加载注册的对象
 */
public class XMLContext extends AbstractBeanFactory{

    XMLContext(String filePath){
        super(filePath);
        this.setSourceReader(new XMLSourceReader());
        this.registerBeans();
    }

    @Override
    protected void setSourceReader(SourceReader sourceReader) {
        this.reader = sourceReader;
    }
}

package com.weichao.exercise.ioc.simplespring;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 最顶层的IOC实现
 * 负责从注册容器中获取注册对象
 * 实现从对象描述信息转换为对象实例的过程
 * 实现根据名称获取对象的方法
 */
public abstract class AbstractBeanFactory implements BeanFactory{

    //注册文件信息
    private String filePath;

    //注册对象信息Map
    private Map<String,BeanInfo> container;

    //对象注册读取器
    protected SourceReader reader;

    public AbstractBeanFactory(String filePath){
        this.filePath = filePath;
    }

    /**
     * 子类具体实现使用什么样的注册读取器
     * @param sourceReader
     */
    protected abstract void setSourceReader(SourceReader sourceReader);

    /**
     * 从注册读取器中读取注册对象信息的Map
     */
    public void registerBeans(){
        this.container = this.reader.loadBeans(filePath);
    }

    /**
     * 实现BeanFactory定义的根据名称
     * @param name 对象的名称
     * @return
     */
    @Override
    public Object getBean(String name) {

        //根据对象名获取该对象的描述信息
        BeanInfo beanInfo = this.container.get(name);
        //容器中不存在该对象返回null或者抛出异常
        if(beanInfo == null){
            return null;
        } else {
            return this.parseBean(beanInfo);
        }

    }

    /**
     * 解析并生成对象实例
     * 主要通过反射来实现
     * 1.根据类名加载类
     * 2.使用Class对象clazz实例化该类，获取一个对象，采用无参构造方法，要求注册的对象必须含有无参构造方法】
     * 3.这逐个设置对象字段的值，通过set Method的方式，而不是直接使用Field对象，因为用户可能在set方法中做一些处理
     * 4.返回该对象的实例
     * @param beanInfo 指定对象的描述信息
     * @return
     */
    protected Object parseBean(BeanInfo beanInfo){

        Class clazz;
        try{
            clazz = Class.forName(beanInfo.getType());
            Object bean = clazz.newInstance();

            //获取该类的所有公共方法，实际上Spring获取的是所有方法，包括非公有方法
            Method[] methods = clazz.getMethods();

            for(String property:beanInfo.getProperties().keySet()){
                //获取属性的setter方法
                String setter = "set"+ property.substring(0,1).toUpperCase() + property.substring(1);

                //遍历类的所有公共方法
                for(Method method:methods){
                    String methoName = method.getName();
                    if(methoName.equals(setter)){
                        //从对象的描述信息中获取该属性的值
                        Object value = beanInfo.getProperties().get(property);
                        if(value == null){
                            value = getBean(property);
                        }
                        method.invoke(bean,value);
                        continue;
                    }
                }
            }
            return bean;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

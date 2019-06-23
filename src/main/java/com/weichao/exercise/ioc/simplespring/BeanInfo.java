package com.weichao.exercise.ioc.simplespring;

import java.util.HashMap;
import java.util.Map;

/**
 * 该类用于描述注册在容器中的对象
 */
public class BeanInfo {

    /**
     * 对象的标识
     */
    private String id;

    /**
     * 对象的类型
     */
    private String type;

    /**
     * 对象的属性和值得集合
     */
    private Map<String,Object> properties = new HashMap<String,Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "BeanInfo{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", properties=" + properties +
                '}';
    }
}

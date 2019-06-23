package com.weichao.exercise.ioc.simplespring;

import com.sun.org.apache.xalan.internal.xsltc.trax.SAX2DOM;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * XML注册读取器
 * 该类继承了注册读取器接口，并模拟实现了读取注册对象信息的方法
 */
public class XMLSourceReader implements SourceReader{


    @Override
    public Map<String, BeanInfo> loadBeans(String filePath){
        Document document = null;
        //加载xml配置文件
        try{
            InputStream inputStream = new FileInputStream(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse(inputStream);
        }catch (FileNotFoundException e){
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e){
            throw new RuntimeException(e);
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (SAXException e){
            throw new RuntimeException(e);
        }

        Element root = document.getDocumentElement();
        //获取所有的Bean标签
        NodeList nodeList = root.getChildNodes();
        Map<String,BeanInfo> beans = new HashMap<String,BeanInfo>();
        //遍历<bean>标签
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                BeanInfo beanInfo = new BeanInfo();
                beanInfo.setId(id);
                beanInfo.setType(className);

                Map<String,Object> properties = beanInfo.getProperties();
                //遍历<property>标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");
                        if (value != null && value.length() > 0) {
                            properties.put(name,value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            // 将引用填充到相关字段中
                            properties.put(name,beans.get(value));
                        }

                    }
                }
                // 将 bean 注册到 bean 容器中
                beans.put(id, beanInfo);
            }
        }
        return beans;
    }
}

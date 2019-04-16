package com.weichao.exercise.ioc;

import org.junit.Test;

/**
 * @author weichao
 * @Description
 * @date 2019/4/16 16:18
 */
public class SimpleIOCTest {

    @Test
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel.toString());
        Car car = (Car) bf.getBean("car");
        System.out.println(car.toString());
    }
}

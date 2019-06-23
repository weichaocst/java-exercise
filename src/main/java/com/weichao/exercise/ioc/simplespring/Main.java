package com.weichao.exercise.ioc.simplespring;

import com.weichao.exercise.ioc.Car;

public class Main {

    public static void main(String[] args) {
        BeanFactory factory = new XMLContext("D:\\IdeaProjects\\java-exercise\\src\\main\\java\\com\\weichao\\exercise\\ioc\\ioc.xml");
        Car car = (Car)factory.getBean("car");
        System.out.println(car.toString());
    }
}


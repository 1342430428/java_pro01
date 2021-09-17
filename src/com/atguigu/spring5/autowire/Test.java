package com.atguigu.spring5.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean9.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.test();
    }
}

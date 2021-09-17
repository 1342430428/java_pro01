package com.atguigu.spring5.collectiontype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean6.xml");
        Stu stu = context.getBean("stu", Stu.class);
        stu.printf();
    }
}

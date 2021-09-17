package com.atguigu.spring5.factorybean;

import com.atguigu.spring5.collectiontype.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean7.xml");
        Course myBean1 = context.getBean("MyBean", Course.class);
        Course myBean2 = context.getBean("MyBean", Course.class);
        System.out.println(myBean1);
        System.out.println(myBean2);
    }
}
/**
 * singleton单实例加载配置文件的时候就创建对象
 * prototype多实例在调用getbean方法的时候才创建对象
 */

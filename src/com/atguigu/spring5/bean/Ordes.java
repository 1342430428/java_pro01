package com.atguigu.spring5.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ordes {
    private String oname;

    public Ordes() {
        System.out.println("第一步执行无参构造创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("调用set方法设置属性的值");
    }

    public void initMethod() {
        System.out.println("执行初始化方法");
    }

    public void destroyMethod() {
        System.out.println("第五步调用销毁方法！");
    }


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean8.xml");
        Ordes ordes = context.getBean("orders", Ordes.class);
        System.out.println("第四部 获取到创建出来的bean对象");
        System.out.println(ordes);
        context.close();
    }
}

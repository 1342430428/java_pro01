package com.atguigu.spring5.autowire;

public class Emp {
    private Dept dept;

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void test() {
        System.out.println(dept);
    }
}

package com.atguigu.spring5;

public class Book {
    private String bname;
    private String bauthor;
    private String address;
    public String test;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void testDemo() {
        System.out.println(bname + ";" + bauthor + ";" + address);
    }

    public void test() {
        System.out.println("nihao");
        System.out.println("hhh");
        System.out.println("wuxiao");
    }
}

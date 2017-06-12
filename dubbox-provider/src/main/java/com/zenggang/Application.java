package com.zenggang;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-dubbo-provider.xml");
        applicationContext.start();

        System.in.read();
    }
}

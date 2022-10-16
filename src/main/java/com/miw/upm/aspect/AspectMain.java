package com.miw.upm.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.miw.upm.aspectTarget.ServiceOne;
import com.miw.upm.config.AspectConfig;

public final class AspectMain {

    public static void run() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        ServiceOne serviceOne = context.getBean(ServiceOne.class);
        serviceOne.method();
        serviceOne.argOneString("cadena");
        serviceOne.returnInt();
        try {
            serviceOne.exception();
        } catch (Exception e) {
        }
        serviceOne.annotation();
        ((AbstractApplicationContext) context).close();
    }
}

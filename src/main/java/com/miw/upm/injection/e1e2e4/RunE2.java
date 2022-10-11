package com.miw.upm.injection.e1e2e4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.miw.upm.config.E2Config;

public class RunE2 {

    private static Logger log = LoggerFactory.getLogger(RunE2.class);

    public static void run() {
        // Creamos la Factoría de Spring, con el fichero de configuración "E2Config" la
        // configuramos
        ApplicationContext context = new AnnotationConfigApplicationContext(E2Config.class);
        // Le pido un Bean, con el contexto de mi Factoría de Spring.
        MessageManager manager = context.getBean(MessageManager.class);
        // Y ya puedo utilizar ese Bean.
        manager.addMessage("1", "uno");
        log.info(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}

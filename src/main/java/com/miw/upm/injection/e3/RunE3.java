package com.miw.upm.injection.e3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class RunE3 {

    private static Logger log = LoggerFactory.getLogger(RunE3.class);

    public static void run() {
        // Creamos la Factoría de Spring, con un fichero XML de configuración
        // "META-INF/e3Config.xml" lo configuramos
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "META-INF/e3Config.xml" });
        // Le pido un Bean, con el contexto de mi Factoría de Spring.
        MessageManager manager = context.getBean(MessageManager.class);
        // Y ya puedo utilizar ese Bean.
        manager.addMessage("1", "uno");
        log.info(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}

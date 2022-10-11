package com.miw.upm.injection.e1e2e4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class RunE4 {

    private static Logger log = LoggerFactory.getLogger(RunE4.class);

    public static void run() {
        // Creamos la Factoría de Spring (pero NO la configuro)
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        // Le pedimos a dicha Factoría de Spring que escaneé el paquete con mis clases
        // con anotaciones de Spring
        context.scan("com.miw.upm.injection.e1e2e4");
        // Refrescamos, recargamos el contexto
        context.refresh();
        // Le pido un Bean, con el contexto de mi Factoría de Spring.
        MessageManager manager = context.getBean(MessageManager.class);
        // Y ya puedo utilizar ese Bean.
        manager.addMessage("1", "uno");
        log.info(manager.findMessage("1"));
        ((AbstractApplicationContext) context).close();
    }
}

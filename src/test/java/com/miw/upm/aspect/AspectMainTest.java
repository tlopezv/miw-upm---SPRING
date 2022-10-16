package com.miw.upm.aspect;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AspectMainTest {

    private static Logger log = LoggerFactory.getLogger(AspectMainTest.class);

    @Test
    public void runTest() {
        log.info("Ejecutamos el método 'run' de la clase 'RunE1'");
        log.info("Dónde creamos la Factoría de Spring, con el fichero de configuración \"E1Config\" la configuramos");
        log.info(
                "La clase de configuración \"E1Config\" indica que escaneé un paquete y todas las clases que encuentre con anotaciones las convierta en un Bean");
        AspectMain.run();
        assertTrue(true);
    }
}

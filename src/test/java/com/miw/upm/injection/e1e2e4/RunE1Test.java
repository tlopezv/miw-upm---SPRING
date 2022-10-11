package com.miw.upm.injection.e1e2e4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunE1Test {

    private static Logger log = LoggerFactory.getLogger(RunE1Test.class);

    @Test
    public void runTest() {
        log.info("Ejecutamos el método 'run' de la clase 'RunE1'");
        log.info("Dónde creamos la Factoría de Spring, con el fichero de configuración \"E1Config\" la configuramos");
        log.info(
                "La clase de configuración \"E1Config\" indica que escaneé un paquete y todas las clases que encuentre con anotaciones las convierta en un Bean");
        RunE1.run();
        assertTrue(true);
    }
}

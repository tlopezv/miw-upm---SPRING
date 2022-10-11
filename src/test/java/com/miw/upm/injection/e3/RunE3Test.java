package com.miw.upm.injection.e3;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

public class RunE3Test {

    private static Logger log = LoggerFactory.getLogger(RunE3Test.class);

    @Test
    public void runTest() {
        log.info("Ejecutamos el método 'run' de la clase 'RunE3'");
        log.info(
                "Dónde creamos la Factoría de Spring, con un fichero XML de configuración \"META-INF/e3Config.xml\" lo configuramos");
        log.info("Defino los Beans a través del XML");
        RunE3.run();
        assertTrue(true);
    }
}

package com.miw.upm.injection.e1e2e4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunE4Test {

    private Logger log = LoggerFactory.getLogger(RunE4Test.class);

    @Test
    public void runTest() {
        log.info("Ejecutamos el método 'run' de la clase 'RunE4'");
        log.info("Dónde creamos la Factoría de Spring (pero NO la configuro)");
        log.info(
                "Le pedimos a dicha Factoría de Spring que escaneé el paquete con mis clases con anotaciones de Spring");
        RunE4.run();
        assertTrue(true);
    }
}

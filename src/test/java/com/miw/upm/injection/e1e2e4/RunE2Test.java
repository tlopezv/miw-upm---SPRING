package com.miw.upm.injection.e1e2e4;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunE2Test {

    private static Logger log = LoggerFactory.getLogger(RunE2Test.class);

    @Test
    public void runTest() {
        log.info("Ejecutamos el método 'run' de la clase 'RunE2'");
        log.info("Dónde creamos la Factoría de Spring, con el fichero de configuración \"E2Config\" la configuramos");
        log.info(
                "La clase de configuración \"E2Config\" indica que NO escaneé ningún paquete. Por cada Bean que quiero que devuelva mi aplicación creo un método que devuelva el tipo del Bean, lo califico con la anotación @Bean.");
        RunE2.run();
        assertTrue(true);
    }
}

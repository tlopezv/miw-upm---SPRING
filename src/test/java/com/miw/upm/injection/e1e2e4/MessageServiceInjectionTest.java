package com.miw.upm.injection.e1e2e4;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.miw.upm.config.E1Config;

// Esto se tiene que ejecutar con una clase especial de Spring para que pueda inyectar dependencias en el Test
@RunWith(SpringJUnit4ClassRunner.class)
// Tengo que configurar la Fábrica de Spring, y por lo tanto tengo que decirle
// cuál es mi fichero de configuración.
@ContextConfiguration(classes = E1Config.class)
public class MessageServiceInjectionTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void testAddMessage() {
        messageService.add("1", "uno");
        assertEquals("uno", messageService.message("1"));
    }

    @Test
    public void testKey() {
        messageService.add("2", "dos");
        messageService.add("3", "tres");
        messageService.add("4", "cuatro");
        assertEquals("2", messageService.key("dos"));
        assertEquals("4", messageService.key("cuatro"));
    }
}

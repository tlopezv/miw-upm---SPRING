package com.miw.upm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.miw.upm.injection.e1e2e4.MessageManager;
import com.miw.upm.injection.e1e2e4.MessageService;

/**
 * Clase de configuración para Spring.
 * No escaneo paquetes, por cada Bean que quiero que devuelva mi aplicación creo
 * un método que devuelva el tipo del Bean, lo califico con la anotación @Bean.
 * Y en dichos métodos hago yo el 'new'
 */
@Configuration
public class E2Config {

    // <bean id="messageService"
    // class="com.miw.upm.injection.e1e2e4.MessageService"/>
    @Bean
    public MessageService messageService() {
        return new MessageService();
    }

    // <bean id="messageManager"
    // class="com.miw.upm.injection.e1e2e4.MessageManager"/>
    @Bean
    public MessageManager messageManager() {
        return new MessageManager();
    }
}

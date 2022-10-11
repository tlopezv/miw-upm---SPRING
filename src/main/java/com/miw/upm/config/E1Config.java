package com.miw.upm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración para Spring, diciendole que escaneé un paquete y todas
 * las clases que encuentre con anotaciones las convierta en un Bean
 */
@Configuration
@ComponentScan(basePackages = { "com.miw.upm.injection.e1e2e4" })
public class E1Config {
}

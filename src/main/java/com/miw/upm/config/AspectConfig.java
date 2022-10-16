package com.miw.upm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { "com.miw.upm.aspect", "com.miw.upm.aspectTarget" })
public class AspectConfig {
}

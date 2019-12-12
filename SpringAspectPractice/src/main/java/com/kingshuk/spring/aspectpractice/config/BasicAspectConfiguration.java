package com.kingshuk.spring.aspectpractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.kingshuk.spring.aspectpractice.aspects")
public class BasicAspectConfiguration {

}

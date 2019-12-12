package com.kingshuk.spring.aspectpractice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by kingshuk on 9/7/17.
 */
@Configuration
@EnableAspectJAutoProxy  //This annotation make sure that aop can use proxy objects (Spring AOP Proxy Support)
@ComponentScan("com.kingshuk.spring.aop")
@PropertySource("classpath:petName.properties")
public class AOPImplementationConfig {

}

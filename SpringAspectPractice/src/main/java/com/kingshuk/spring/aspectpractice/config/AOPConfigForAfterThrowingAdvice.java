package com.kingshuk.spring.aspectpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.service.ClaimsBusinessService;
import com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.service.ClaimsBusinessServiceImpl;

/**A class created to control the aspects related to the point
 * cut declaration practice classes
 * Created by CO21321 on 2/12/2018.
 */
@Configuration
@EnableAspectJAutoProxy  /**This annotation make sure that aop can use proxy objects (Spring AOP Proxy Support)*/
@ComponentScan("com.kingshuk.spring.aop.afterthrowingadvice")
public class AOPConfigForAfterThrowingAdvice {

    @Bean(name = "ClaimsBusinessService")
    public ClaimsBusinessService getClaimsBusinessServiceBean(){
        return new ClaimsBusinessServiceImpl();
    }
}

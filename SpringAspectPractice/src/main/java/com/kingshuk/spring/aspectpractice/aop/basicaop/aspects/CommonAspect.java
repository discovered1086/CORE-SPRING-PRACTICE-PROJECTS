package com.kingshuk.spring.aspectpractice.aop.basicaop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 02/10/2018.
 */
@Aspect
@Component
public class CommonAspect {

    /**
     * The pointcut declaration or the expression in fact does NOT travel through child
     * packages. it exactly follow the declaration
     *
     * ex. below we have specified aop package, this does mean, the expression will be called
     * only for any method in a class which is directly under the package aop.
     */
    /*@Pointcut("execution(* com.kingshuk.spring.aop.*.*(..))")
    private void commonCalls(){}*/

    @Pointcut("execution(* com.kingshuk.spring.aop.basicaop.beans.*.*(..))")
    private void commonCallsInBeans(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.basicaop.service.*.*(..))")
    private void commonCallsInService(){}

    /**
     * Now we're going to combine the two point cut declarations to make
     * another point cut declaration. Because think about it, if we somehow
     * were able to directly use the two point cuts with && operator inside the two advice methods,
     * we would still use redundant point cut declaration calls,
     *
     * And the whole point of the pointcut declaration is to promote re-usability,
     * So here we go.....
     */

    /**
     * The commented out point cut declaration below does NOT work,
     *
     * Because here's what the expressions say
     * 1. The first expression says use this expression for any method for any class
     * that belongs to the beans package
     *
     * 2.The second expression says use this expression for any method for any class
     * that belongs to the service package
     *
     * Unless there's a class that exists in both the packages, the combination of the two
     * will never work
     */

    /*@Pointcut("commonCallsInBeans() && commonCallsInService()")
    private void commonCallInBeansAndService(){}*/


    //The correct one
    @Pointcut("commonCallsInBeans() || commonCallsInService()")
    private void commonCallInBeansAndService(){}


    @Before("commonCallInBeansAndService()")
    public void printBeforeStatement(){
        System.out.println("This is printed BEFORE any method calls in the package");
    }

    @After("commonCallInBeansAndService()")
    public void printAfterStatement(){
        System.out.println("This is printed AFTER any method calls in the package");
    }
}

package com.kingshuk.spring.aspectpractice.aop.afterthrowingadvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * An aspect class for claims related processing
 * Created by CO21321 on 2/13/2018.
 */
@Aspect
@Component
@Order(2)
public class ClaimDetailsExceptionHandlingAspect {

    /**
     * This is how returning value is captured in aspects
     *
     * The pointcut can be declared in FOUR different ways
     *
     * 1. @AfterThrowing(
     *          pointcut = "com.kingshuk.spring.aop.afterthrowingadvice.aspect.CommonPointcutsForAfterThrowing.forAddingOneInsured()",
     *          throwing = "aClaimException")
     *
     * 2. @AfterThrowing(
     *          pointcut = "execution(* com.kingshuk.spring.aop.afterthrowingadvice.service.*.*NewInsured(..))",
     *          throwing = "aClaimException")
     *
     * 3. @AfterThrowing(value = "com.kingshuk.spring.aop.afterthrowingadvice.aspect.CommonPointcutsForAfterThrowing.forAddingOneInsured()",
     *          throwing = "aClaimException")
     *
     * 4. @AfterThrowing(value = "execution(* com.kingshuk.spring.aop.afterthrowingadvice.service.*.*NewInsured(..))",
     *          throwing = "aClaimException")
     *
     * ******************************************************************************************************************************
     *
     * *****IMPORTANT****: The most important thing to note here is that,  after throwing just helps you read the exception and it's details like
     * messages and stuff and log etc. however you can NOT prevent the exception from being propagated to the calling method.
     *
     * For that we'll need the @Around service, @AfterThrowing is just for using the exception to perform some meaningful action before
     * it eventually propagates to the calling method
     */


    @AfterThrowing(
             pointcut = "com.kingshuk.spring.aop.afterthrowingadvice.aspect.CommonPointcutsForAfterThrowing.forAddingOneInsured()",
            throwing = "aClaimException")
    public void captureClaimProcessException(JoinPoint joinPoint, Throwable aClaimException){
        System.out.println("\n_____________________________________________________________________\n" +
                "<<ClaimDetailsExceptionHandlingAspect>> Just calling this AFTER an exception has been thrown during a claim processing");
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();

        System.out.println("The method that has thrown this exception is"+signature);

        System.out.println("\nThe message from the exception is: "+aClaimException.getMessage());

        System.out.println("\nThe detailed exception is: "+aClaimException);

        System.out.println("\n_____________________________________________________________________\n" );
    }
}

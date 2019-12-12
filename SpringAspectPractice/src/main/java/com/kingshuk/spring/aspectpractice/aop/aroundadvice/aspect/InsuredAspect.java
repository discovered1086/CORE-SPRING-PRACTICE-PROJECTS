package com.kingshuk.spring.aspectpractice.aop.aroundadvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**A class that represents the Insured Aspect
 * Created by CO21321 on 2/16/2018.
 */
@Aspect
@Component
@Order(3)
public class InsuredAspect {
    /**
     * This is not the common logging API, this is simply the java.util API
     */
    private static Logger logger= Logger.getLogger(InsuredAspect.class.getName());
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
            pointcut = "com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.allInsuredActivitiesExceptAddingInsured()",
            throwing = "anInsuredException")
    public void insuredAfterThrowingExample(JoinPoint joinPoint, Throwable anInsuredException){
        logger.info("\n______________________AFTER THROWING ADVICE STARTS_______________________________________________\n" +
                "<<ClaimDetailsExceptionHandlingAspect>> Just calling this AFTER an exception has been thrown during querying an insured");
        MethodSignature signature= (MethodSignature) joinPoint.getSignature();

        logger.info("The method that has thrown this exception is"+signature);

        logger.info("\nThe message from the exception is: "+anInsuredException.getMessage());

        logger.info("\nThe detailed exception is: "+anInsuredException);

        logger.info("\n_____________________AFTER THROWING ADVICE ENDS________________________________________________\n" );
    }


    @Before("com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.allInsuredActivitiesExceptAddingInsured()")
    public void JustBeforeTheActualMethod(){
        logger.info("\n________________________BEFORE ADVICE CODE STARTS_____________________________________________\n" +
                "<<ClaimsAspect>> Just calling this BEFORE a claim processing");
        logger.info("\n________________________BEFORE ADVICE CODE ENDS__________________________________________________\n");
    }
}

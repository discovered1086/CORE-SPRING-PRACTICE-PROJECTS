package com.kingshuk.spring.aspectpractice.aop.aroundadvice.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * This aspect class takes care of logging timings
 * Created by CO21321 on 2/13/2018.
 */

@Aspect
@Component
@Order(1)
public class TimeLoggingAspect {

    /**
     * This is not the common logging API, this is simply the java.util API
     */
    private static Logger logger = Logger.getLogger(TimeLoggingAspect.class.getName());
    /**
     * Previously we have handled the time logging in the most dorky way possible. By using the
     * combination of the @Before and the @AfterReturning advices
     *
     * Now we have a way better way of doing it.
     *
     * The @Around advice has a handle to the target method, called proceeding join point
     *
     * the proceed() call is actually going to call the target method.
     */

    /**
     * The order of the advice execution is
     * <p>
     * Main app --> AOP Proxy[--> @Around --> @Before --> Call to the target method --> @AfterReturning --> @Around] --> Main app
     * <p>
     * Main app --> AOP Proxy[--> @Around --> @Before --> Call to the target method --> @After --> @Around] --> Main app
     * <p>
     * Main app --> AOP Proxy[--> @Around --> @Before --> Call to the target method --> @AfterThrowing --> @Around] --> Main app
     * <p>
     * <p>
     * When you have all of them (Meaning a combination of the 'After' s)
     * <p>
     * Main app --> AOP Proxy[--> @Around --> @Before --> Call to the target method --> @After--> @AfterReturning --> @Around] --> Main app
     * <p>
     * Main app --> AOP Proxy[--> @Around --> @Before --> Call to the target method --> @After--> @AfterThrowing --> @Around] --> Main app
     */

    @Around("com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.forAllClaims()")
    public Object logTheTimeOfClaimProcessing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("\n__________________________AROUND ADVICE CODE STARTS_____________________________________________\n" +
                "<<TimeLoggingAspect>> Before calling the target method through the handle");

        logger.info("The method we're have hooked this advice to, is: " + proceedingJoinPoint.getSignature().toShortString());

        long startTime = System.currentTimeMillis();
        /**
         * This is actually making the call to the target method - in this case it is viewOneClaim method
         */
        Object result = proceedingJoinPoint.proceed();


        long endTime = System.currentTimeMillis();

        logger.info("The time taken by the method is " + (endTime - startTime) + " ms");
        logger.info("<<TimeLoggingAspect>> Done with the work in this aspect\n" +
                "__________________________AROUND ADVICE CODE ENDS____________________________________________\n");

        return result;

    }


    @Around("com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.allInsuredActivitiesExceptAddingInsured()")
    public Object logTheTimeForInsuredProcessing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("\n__________________________AROUND ADVICE WITH AFTER THROWING CODE STARTS_____________________________________________\n" +
                "<<TimeLoggingAspect>> Before calling the target method through the handle");

        logger.info("The method we're have hooked this advice to, is: " + proceedingJoinPoint.getSignature().toShortString());

        long startTime = System.currentTimeMillis();
        /**
         * This is actually making the call to the target method - in this case it is all the insured query methods
         *
         * There's a weird thing happening if we don't catch the exception and I believe this
         * is related to the @Around advice.
         *
         * The exception which is being propagated to the main app (because we didn't handle it in the around advice
         * method), is being printed before the prints for around advice
         *
         * this is because spring is printing the exception not the system output stream
         *
         * There're two streams being used for printing, spring is using logger output stream
         * whereas the System class is using the standard output stream.
         */

        //Object result=proceedingJoinPoint.proceed();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception ex) {
            logger.info("<<TimeLoggingAspect>> Caught the exception baby...!!\n");
        }


        long endTime = System.currentTimeMillis();

        logger.info("The time taken by the method is " + (endTime - startTime) + " ms");
        logger.info("<<TimeLoggingAspect>> Done with the work in this aspect\n" +
                "__________________________AROUND ADVICE WITH AFTER THROWING CODE ENDS____________________________________________\n");

        return result;

    }
}

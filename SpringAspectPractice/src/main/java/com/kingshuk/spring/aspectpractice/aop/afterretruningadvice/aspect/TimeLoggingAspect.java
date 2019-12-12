package com.kingshuk.spring.aspectpractice.aop.afterretruningadvice.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * This aspect class takes care of logging timings
 * Created by CO21321 on 2/13/2018.
 */

@Aspect
@Component
@Order(1)
public class TimeLoggingAspect {

    private Long timeAtTheBeginning;

    @Before("com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()")
    public void logTimeBeforeMethodCall() {
        timeAtTheBeginning = System.currentTimeMillis();

        //System.out.println(timeAtTheBeginning);
    }

    /**
     * This is how returning value is captured in aspects
     *
     * The pointcut can be declared in FOUR different ways
     *
     * 1. @AfterReturning(
     *          pointcut = "com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()")
     *
     * 2. @AfterReturning(
     *          pointcut = "execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))")
     *
     * 3. @AfterReturning(value = "com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()")
     *
     * 4. @AfterReturning(value = "execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))")
     *
     * AND one additional way because here we're not using the returning result
     *
     * 5. @AfterReturning("com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()")
     */

    @AfterReturning("com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()")
    public void logTimeTakenAfterMethodCall() {
        //System.out.println(timeAtTheEnd);

        System.out.println("________________________________________________________________\n" +
                "Total time taken for the entire operation is " + (System.currentTimeMillis() - timeAtTheBeginning) + " ms");
    }
}

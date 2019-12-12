package com.kingshuk.spring.aspectpractice.aop.aroundadvice.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.aroundadvice.beans.ClaimEvent;

/**
 * An aspect class for claims related processing
 * Created by CO21321 on 2/13/2018.
 */
@Aspect
@Component
@Order(2)
public class ClaimDetailsAspect {
    /**
     * This is not the common logging API, this is simply the java.util API
     */
    private static Logger logger= Logger.getLogger(ClaimDetailsAspect.class.getName());

    /**
     * This is how returning value is captured in aspects
     *
     * The pointcut can be declared in FOUR different ways
     *
     * 1. @AfterReturning(
     *          pointcut = "com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.forAllClaims()",
     *          returning = "aClaim")
     *
     * 2. @AfterReturning(
     *          pointcut = "execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*OneClaim*(..))",
     *          returning = "aClaim")
     *
     * 3. @AfterReturning(value = "com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.forAllClaims()",
     *          returning = "aClaim")
     *
     * 4. @AfterReturning(value = "execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*OneClaim*(..))",
     *          returning = "aClaim")
     *
     */

    @AfterReturning(
            pointcut = "execution(* com.kingshuk.spring.aop.aroundadvice.service.*.*OneClaim*(..))",
            returning = "aClaim")
    public ClaimEvent processClaimsAlerts(JoinPoint joinPoint, ClaimEvent aClaim){
        logger.info("\n________________________AFTER RETURNING ADVICE CODE STARTS_____________________________________________\n" +
                "<<ClaimsAspect>> Just calling this AFTER returning from a claim processing");
        aClaim.getInsured().setFirstName("Deeksha");
        aClaim.getInsured().setLastName("Banerjee");

        MethodSignature joinPointSignature = (MethodSignature) joinPoint.getSignature();

        logger.info("The method signature is " + joinPointSignature);

        /*for (Object args : joinPoint.getArgs()) {
            logger.info(args.toString());

        }*/
        logger.info("The claim event Id passed to the method was "+joinPoint.getArgs()[0]);

        logger.info("__________________________AFTER RETURNING ADVICE CODE ENDS__________________________________________________\n");

        return aClaim;
    }

    @Before("com.kingshuk.spring.aop.aroundadvice.aspect.CommonPointcutsForAround.forAllClaims()")
    public void JustBeforeTheActualMethod(){
        logger.info("\n________________________BEFORE ADVICE CODE STARTS_____________________________________________\n" +
                "<<ClaimsAspect>> Just calling this BEFORE a claim processing");
        logger.info("\n________________________BEFORE ADVICE CODE ENDS__________________________________________________\n");
    }
}

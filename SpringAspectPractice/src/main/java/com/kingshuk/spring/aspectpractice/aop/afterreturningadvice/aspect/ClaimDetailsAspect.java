package com.kingshuk.spring.aspectpractice.aop.afterreturningadvice.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.afterreturningadvice.beans.ClaimEvent;

/**
 * An aspect class for claims related processing
 * Created by CO21321 on 2/13/2018.
 */
@Aspect
@Component
@Order(2)
public class ClaimDetailsAspect {

    /**
     * This is how returning value is captured in aspects
     *
     * The pointcut can be declared in FOUR different ways
     *
     * 1. @AfterReturning(
     *          pointcut = "com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()",
     *          returning = "aClaim")
     *
     * 2. @AfterReturning(
     *          pointcut = "execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))",
     *          returning = "aClaim")
     *
     * 3. @AfterReturning(value = "com.kingshuk.spring.aop.afterretruningadvice.aspect.CommonPointcutsForAfterReturning.forAllClaims()",
     *          returning = "aClaim")
     *
     * 4. @AfterReturning(value = "execution(* com.kingshuk.spring.aop.afterretruningadvice.service.*.*OneClaim*(..))",
     *          returning = "aClaim")
     *
     */

    @AfterReturning(
            pointcut = "execution(* com.kingshuk.spring.aop.afterreturningadvice.service.*.*OneClaim*(..))",
            returning = "aClaim")
    public ClaimEvent processClaimsAlerts(JoinPoint joinPoint, ClaimEvent aClaim){
        System.out.println("\n_____________________________________________________________________\n" +
                "<<ClaimsAspect>> Just calling this AFTER returning from a claim processing");
        aClaim.getInsured().setFirstName("Deeksha");
        aClaim.getInsured().setLastName("Banerjee");

        MethodSignature joinPointSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("The method signature is " + joinPointSignature);

        /*for (Object args : joinPoint.getArgs()) {
            System.out.println(args.toString());

        }*/
        System.out.println("The claim event Id passed to the method was "+joinPoint.getArgs()[0]);

        System.out.println("____________________________________________________________________________\n");

        return aClaim;
    }
}

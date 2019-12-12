package com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/** Created this aspect class to practice the ordering of aspects
 * Created by CO21321 on 2/12/2018.
 */
@Aspect
@Component
/**
 * The @Order annotation helps order the execution of the aspects. It's not a hint.
 * It's a guaranteed approach that if order is specified, then the container will run
 * the aspects in the order specified.
 *
 * -->Lower number is higher precedence.
 * -->Negative numbers are allowed
 * -->Numbers don't have to be consecutive
 *
 * |*| This annotation can only be applied to Aspect classes and not advices inside an aspect class
 */
@Order(1)
public class InsuredAspect {
    /**
     * Because the point cut expression has been moved to a different class, we need to specify a fully qualified class name
     * for the point cut declaration
     */
    @Before("com.kingshuk.spring.aop.morepointcutsandjoinpoints.aspect.CommonPointCutDeclarations.getInsuredDetailsWithoutGetterSetter()")
    public void printAfterClaimRaised(JoinPoint joinPoint){
        System.out.println("");

        System.out.println("\n_____________________________________________________________________\n"+
                "<<InsuredAspect>> Just calling this BEFORE a claim has been raised and also with setters");
        MethodSignature joinPointSignature = (MethodSignature)joinPoint.getSignature();

        System.out.println("The method signature is "+joinPointSignature);

        for (Object args : joinPoint.getArgs()) {
            System.out.println(args.toString());
        }

        System.out.println("____________________________________________________________________________\n");
    }
}

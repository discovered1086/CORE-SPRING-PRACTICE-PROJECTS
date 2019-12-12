package com.kingshuk.spring.aspectpractice.aop.morepointcutsandjoinpoints.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**A class that holds the common pointcut declarations
 * Created by CO21321 on 2/12/2018.
 */
@Aspect
@Component
public class CommonPointCutDeclarations {
    /**
     * There's one thing to notice in the below pointcut expression,
     * the argument list has one defined argument and then a ,.. meaning there are more arguments,
     * However this works even if the method has just one argument as long as that argument is an Insured object
     *
     * There does NOT have to be an argument where ,.. is specified.
     */
    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.*(com.kingshuk.spring.aop.morepointcutsandjoinpoints.beans.Insured, ..))")
    public void claimRaised(){}

   @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.set*(..))")
    public void setterMethods(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.get*(..))")
    public void getterMethods(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.beans.ClaimBenefits.get*(..))")
    public void getterMethodsForClaimBenefits(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.getInsured*(..))")
    public void getterMethodsForInsured(){}

    @Pointcut("claimRaised() && !setterMethods())")
    public void claimRaisedButNoInsuredSetter(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.*InsuredClaims(com.kingshuk.spring.aop.morepointcutsandjoinpoints.beans.Insured, ..))")
    public void claimInsuredCombinedInfo(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.*Benefit*(..))")
    public void getBenefitInfo(){}

    @Pointcut("execution(* com.kingshuk.spring.aop.morepointcutsandjoinpoints.*.*.*Insured*(..))")
    public void getInsuredInfo(){}

    @Pointcut("getBenefitInfo() && !(setterMethods() || getterMethodsForClaimBenefits())")
    public void getBenefitDetailsWithoutGetterSetter(){}

    @Pointcut("getInsuredInfo() && !(setterMethods() || getterMethodsForInsured() || claimInsuredCombinedInfo())")
    public void getInsuredDetailsWithoutGetterSetter(){}
}

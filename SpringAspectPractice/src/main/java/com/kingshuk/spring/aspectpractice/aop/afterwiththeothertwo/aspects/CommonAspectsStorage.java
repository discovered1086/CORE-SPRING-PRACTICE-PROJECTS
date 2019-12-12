package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.aspects;

import org.aspectj.lang.annotation.Pointcut;

/**A class that holds all pointcut expressions for this package
 * Created by CO21321 on 2/15/2018.
 */
public class CommonAspectsStorage {

    @Pointcut("execution(* *Food())")
    public void forAllFoodServices(){}

    @Pointcut("execution(public String com.kingshuk.spring.aop.afterwiththeothertwo.beans.Cheetah.getPetFood())")
    public void getCheetahFoodAspect(){}

    @Pointcut("execution(String com.kingshuk.spring.aop.afterwiththeothertwo.beans.Tiger.getPetFood())")
    public void getTigerFoodAspect(){}
}

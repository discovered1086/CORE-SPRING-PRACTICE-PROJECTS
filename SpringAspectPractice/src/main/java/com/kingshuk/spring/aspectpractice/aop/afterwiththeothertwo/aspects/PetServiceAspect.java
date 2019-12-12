package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 9/7/17.
 * Java class with collection of related advices for the application
 */
@Aspect
@Component
public class PetServiceAspect {

    /**
     * The below point cut expression will be called BEFORE the method getPetFood()
     * on the Tiger class (with package matching package details) is called, always.
     * 
     * The access modifier public is not mandatory.
     */
    @Before("com.kingshuk.spring.aop.afterwiththeothertwo.aspects.CommonAspectsStorage.getTigerFoodAspect()")
    //This is what we call a point-cut expression
    public void petFoodServiceMethodCall() {
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
        System.out.println("<<PetServiceAspect>> This is called BEFORE getting the tiger food");
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
    }

    /**
     * The below point cut expression will be called AFTER any method name ending with the word 'Food'
     * (of course the classes within the package mentioned in the @ComponentScan will be checked for this method),
     * With any kind of return type has returned from the method call successfully (without any exception)
     * 
     * has completed it's execution.
     */
    @AfterReturning(pointcut = "com.kingshuk.spring.aop.afterwiththeothertwo.aspects.CommonAspectsStorage.forAllFoodServices()",
            returning = "foodResult") //Here's another point-cut expression
    public void petFoodServiceMethodCallAfterReturning(JoinPoint joinPoint, Object foodResult) {
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
        System.out.println("<<PetServiceAspect>> This is called AFTER RETURNING from getting the food");

        System.out.println("The method being called was " + joinPoint.getSignature().toShortString());

        System.out.println("The returning result is--> " + foodResult);

        System.out.println("\n____________________________ASPECT PRINT ENDS____________________________________\n");
    }

    @AfterThrowing(pointcut = "com.kingshuk.spring.aop.afterwiththeothertwo.aspects.CommonAspectsStorage.forAllFoodServices()",
            throwing = "execObject")
    public void petFoodServiceMethodCallAfterThrowing(JoinPoint joinPoint, Throwable execObject) {
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
        System.out.println("<<PetServiceAspect>> This is called AFTER THROWING from getting the food");

        System.out.println("The method being called was " + joinPoint.getSignature().toShortString());

        System.out.println("The returning exception is--> " + execObject);

        System.out.println("\n____________________________ASPECT PRINT ENDS____________________________________\n");
    }

    /**
     * The below point cut expression will be called AFTER the method getPetFood()
     * on the Cheetah class (with package matching package details) has completed it's execution.
     * 
     * and the difference between this one and @AfterReturning is that @AfterReturning works when there's a successful execution
     * ,@AfterThrowing works when there's any exception from the method
     * 
     * But @After works regardless of the outcome/exception, it's like the finally block in java,
     *
     * ***************************************************************************************
     * The @After advice is executed BEFORE the @AfterThrowing advice and BEFORE the @AfterReturning advice
     * ***************************************************************************************
     * 
     * Then the question might be, why use the @AfterThrowing or @AfterReturning annotations at all?
     * 
     * Well the answer is,
     * 1) Because the @After does NOT have access to the exception object like the @AfterThrowing
     * 2) And the @After also does NOT have access to the returning result object like @AfterReturning
     * 
     * The access modifier public is not mandatory. but here it's kept for learning purposes
     */
    @After(value = "com.kingshuk.spring.aop.afterwiththeothertwo.aspects.CommonAspectsStorage.getCheetahFoodAspect()")
    //Here's yet another point-cut expression
    public void petFoodServiceMethodCallAfterForCheetah(JoinPoint joinPoint) {
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
        System.out.println("<<PetServiceAspect>> This is called AFTER getting the Cheetah food and AFTER the @AfterReturning but BEFORE the @AfterThrowing advices");
        System.out.println("The method being called was " + joinPoint.getSignature().toShortString());
        System.out.println("\n____________________________ASPECT PRINT ENDS____________________________________\n");
    }


    @After("com.kingshuk.spring.aop.afterwiththeothertwo.aspects.CommonAspectsStorage.getTigerFoodAspect()")
    //Here's yet another point-cut expression
    public void petFoodServiceMethodCallAfterForTiger(JoinPoint joinPoint) {
        System.out.println("\n____________________________ASPECT PRINT STARTS____________________________________\n");
        System.out.println("<<PetServiceAspect>> This is called AFTER getting the Tiger food and AFTER the @AfterReturning but BEFORE the @AfterThrowing advices");
        System.out.println("The method being called was " + joinPoint.getSignature().toShortString());
        System.out.println("\n____________________________ASPECT PRINT ENDS____________________________________\n");
    }
}

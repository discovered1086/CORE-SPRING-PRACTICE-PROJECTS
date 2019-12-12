package com.kingshuk.spring.aspectpractice.aop.basicaop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
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
    @Before("execution(String com.kingshuk.spring.aop.basicaop.beans.Tiger.getPetFood())")  //This is what we call a point-cut expression
    public void petFoodServiceMethodCall(){
        System.out.println("This is called BEFORE getting the tiger food");
    }

    /**
     * The below point cut expression will be called AFTER any method name ending with the word 'Food'
     * (of course the classes within the package mentioned in the @ComponentScan will be checked for this method),
     * With any kind of return type has returned from the method call (?? Have to confirm)
     * has completed it's execution.
     */
    @AfterReturning("execution(* *Food())") //Here's another point-cut expression
    public void petFoodServiceMethodCallAfterReturning(){
        System.out.println("This is called AFTER getting the food");
    }

    /**
     * The below point cut expression will be called AFTER the method getPetFood()
     * on the Cheetah class (with package matching package details) has completed it's execution.
     *
     * The access modifier public is not mandatory. but here it's kept for learning purposes
     */
    @After("execution(public String com.kingshuk.spring.aop.basicaop.beans.Cheetah.getPetFood())") //Here's yet another point-cut expression
    public void petFoodServiceMethodCallAfter(){
        System.out.println("This is called WAY AFTER getting the cheetah food");
    }
}

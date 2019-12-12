package com.kingshuk.spring.aspectpractice.aop.basicaop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 9/11/17.
 */
@Aspect
@Component
public class EmployeeAspect {

    /**
     * Below is what we call A Pointcut Declaration. We declare the point cut expression just once
     * and then it can be reused again and again. This way, if we need to change the expression, we can just change in once place.
     *
     * It is accompanied by a method without a body. This method is kind of a variable that can be used to refer to this expression.
     */

    @Pointcut("execution(* *Employee*(String))")
    private void employeeSearch(){}

    /**
     * The below pointcut expression will be called BEFORE any method having the word 'Employee'
     * and having A STRING ARGUMENT type (of course the classes within the package mentioned in the @ComponentScan will be checked for this method)
     * is called
     *
     * The '*' for access modifier means it can be anything
     */
    @Before("employeeSearch()")
    public void employeeSearchCall(){
        System.out.println("Calling the <employeeSearchCall> method BEFORE the employee search calls");
    }

    /**
     * The below pointcut expression will be called BEFORE any method having the word 'Employee'
     * and having ANY KIND OF ARGUMENT type (of course the classes within the package mentioned in the @ComponentScan will be checked for this method)
     * is called
     *
     * The '*' for access modifier means it can be anything
     */
    @Before("execution(* *Employee*(..))")
    public void employeeSearchCallWithZeroOrManyParams(){
        System.out.println("Calling the <employeeSearchCallWithZeroOrManyParams> method BEFORE the employee search calls");
    }

    /**
     * The below pointcut expression will be called BEFORE any method ending with the word 'Pet'
     * and having A REFERENCE TO A Pet CLASS AS FIRST ARGUMENT and ANYTHING AS A SECOND ARGUMENT
     * (of course the classes within the package mentioned in the @ComponentScan will be checked for this method)
     * is called
     *
     * The '*' for access modifier means it can be anything
     */
    @Before("execution(* *Pet(com.kingshuk.spring.aop.basicaop.beans.Pet,..))")  //Must use the fully qualified class name, otherwise throws an error
    public void petRegistryAspectCall(){
        System.out.println("Calling the <petRegistryAspectCall> method BEFORE the employee search calls");
    }
}

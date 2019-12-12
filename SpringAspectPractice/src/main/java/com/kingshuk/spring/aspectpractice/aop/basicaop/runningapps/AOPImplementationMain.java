package com.kingshuk.spring.aspectpractice.aop.basicaop.runningapps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.aop.basicaop.beans.Pet;
import com.kingshuk.spring.aspectpractice.config.AOPImplementationConfig;

/** Class created to test the AOP in action for EmployeeDAO class
 * Created by kingshuk on 9/7/17.
 */
public class AOPImplementationMain {

    public static void main(String[] args) {

        //Read the spring config from the java class
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPImplementationConfig.class);

        //Get the bean from the spring container
        Pet pet = applicationContext.getBean("tiger", Pet.class);

        //call the getter methods for the name, make noise and pet food
        System.out.println("My pet tiger " + pet.getPetName() + " makes noise like " + pet.makeNoise() + " and it   the fact is " + pet.getPetFood());


        //Closing the application context - spring container
        applicationContext.close();

    }
}

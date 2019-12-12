package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.runningapps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.beans.Pet;
import com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.service.EmployeeManagementDAO;
import com.kingshuk.spring.aspectpractice.config.AOPConfigForAfterAdvice;

/**A class to test the after advice in use
 * Created by kingshuk on 9/11/17.
 */
public class AOPAfterAdviceEmployeeHarness {

    public static void main(String[] args) {
        //Getting the configuration from the java config file to create the container
            AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPConfigForAfterAdvice.class);

        //Getting the bean from the container
        EmployeeManagementDAO employeeManagementDAO = applicationContext.getBean("EmployeeDAO", EmployeeManagementDAO.class);

        //Calling the method on the employee management DAO bean
        employeeManagementDAO.getEmployeeDetails("1");

        //Calling the method on the employee management DAO bean
        employeeManagementDAO.getAllEmployeeNames();


        //Checking the pet employee methods
        Pet pet = applicationContext.getBean("tiger", Pet.class);

        Pet pet1 = applicationContext.getBean("MyCheetah", Pet.class);

        employeeManagementDAO.registerEmployeePet(pet1, "1");


        //Closing the application context/container
        applicationContext.close();
    }
}

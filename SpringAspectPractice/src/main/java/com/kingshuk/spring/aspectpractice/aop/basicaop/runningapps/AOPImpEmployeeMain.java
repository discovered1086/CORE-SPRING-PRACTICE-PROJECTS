package com.kingshuk.spring.aspectpractice.aop.basicaop.runningapps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.aop.basicaop.beans.Pet;
import com.kingshuk.spring.aspectpractice.aop.basicaop.service.ContractorManagementDAO;
import com.kingshuk.spring.aspectpractice.aop.basicaop.service.EmployeeManagementDAO;
import com.kingshuk.spring.aspectpractice.config.AOPImplementationConfig;

/**
 * Created by kingshuk on 9/11/17.
 */
public class AOPImpEmployeeMain {

    public static void main(String[] args) {
        //Getting the configuration from the java config file to create the container
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AOPImplementationConfig.class);

        //Getting the bean from the container
        EmployeeManagementDAO employeeManagementDAO = applicationContext.getBean("EmployeeDAO", EmployeeManagementDAO.class);

        //Calling the method on the employee management DAO bean
        employeeManagementDAO.getEmployeeDetails("1");

        //Calling the method on the employee management DAO bean
        employeeManagementDAO.getAllEmployeeNames();


        //Getting the Contractor DAO from the container
        ContractorManagementDAO contractorManagementDAO=applicationContext.getBean("ContractorDAO",ContractorManagementDAO.class);

        contractorManagementDAO.getAllContractorCompanyNames();

        //Checking the pet employee methods
        Pet pet =applicationContext.getBean("tiger", Pet.class);

        contractorManagementDAO.registerContractorPet(pet);

        Pet pet1=applicationContext.getBean("MyCheetah", Pet.class);

        employeeManagementDAO.registerEmployeePet(pet1,"1");


        //Closing the application context/container
        applicationContext.close();
    }
}

package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.basicaop.beans.Pet;

/**
 * Created by kingshuk on 9/11/17.
 * Just a class for testing the AOP in different ways
 */
@Component("EmployeeDAO")
public class EmployeeManagementDAO {

    public void getEmployeeDetails(String employeeId){
        System.out.println("<<EmployeeManagementDAO>> This is the getEmployeeDetails method");
    }

    public List<String> getAllEmployeeNames(){
        System.out.println("<<EmployeeManagementDAO>> This is the getAllEmployeeNames method");
        return new ArrayList<>();
    }

    public String searchEmployee(String employeeId, String employeeName){
        System.out.println("<<EmployeeManagementDAO>> This is the searchEmployee method");
        return null;
    }

    public void registerEmployeePet(Pet pet, String employeeID){
        System.out.println("<<EmployeeManagementDAO>> This is the registerEmployeePet method");
        System.out.println("<<EmployeeManagementDAO>> And the pet loves "+pet.getPetFood());
    }


}

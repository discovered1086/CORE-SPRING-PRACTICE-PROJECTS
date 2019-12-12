package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.basicaop.beans.Pet;

/**
 * Created by kingshuk on 9/11/17.
 */
@Component("ContractorDAO")
public class ContractorManagementDAO {

    public void getEmployeeDetails(String employeeId){
        System.out.println("<<ContractorManagementDAO>> This is the getEmployeeDetails method");
    }

    public List<String> getAllContractorCompanyNames(){
        System.out.println("<<ContractorManagementDAO>> This is the getAllContractorCompanyNames method");
        return new ArrayList<>();
    }

    public String searchEmployee(String employeeId, String employeeName){
        System.out.println("<<ContractorManagementDAO>> This is the searchEmployee method");
        return null;
    }

    public void registerContractorPet(Pet pet){
        System.out.println("<<ContractorManagementDAO>> This is the registerContractorPet method");
        System.out.println("<<EmployeeManagementDAO>> And the pet loves "+pet.getPetFood());
    }
}

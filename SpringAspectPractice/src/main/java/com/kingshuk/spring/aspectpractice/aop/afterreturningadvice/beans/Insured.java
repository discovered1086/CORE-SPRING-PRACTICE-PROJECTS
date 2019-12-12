package com.kingshuk.spring.aspectpractice.aop.afterreturningadvice.beans;

/** Just a bean to hold the insured information
 * Created by CO21321 on 2/12/2018.
 */
public class Insured {

    private Integer insuredId;

    private String firstName;

    private String lastName;

    private String dob;

    private Integer employeeId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(Integer insuredId) {
        this.insuredId = insuredId;
    }

    @Override
    public String toString() {
        return "Insured{" +
                "insuredId=" + insuredId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }
}

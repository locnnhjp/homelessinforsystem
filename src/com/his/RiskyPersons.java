/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his;

/**
 *
 * @author anonymous
 */
public class RiskyPersons {
    private SA3TenantCategory SA3Category;
    private int numOfPerson;
    
    public RiskyPersons(SA3TenantCategory SA3Category, int numOfPerson) {
        this.SA3Category = SA3Category;
        this.numOfPerson = numOfPerson;
    }
    
    public RiskyPersons() {
        this(null, 0);
    }
    
    public RiskyPersons(RiskyPersons otherRiskyPersons) {
        this(otherRiskyPersons.SA3Category, otherRiskyPersons.numOfPerson);
    }
    
    public void setSA3Category(SA3TenantCategory SA3Category) {
        this.SA3Category = SA3Category;
    }
    
    public SA3TenantCategory getSA3Category() {
        return SA3Category;
    }
    
    public void setNumOfPerson(int numOfPerson) {
        this.numOfPerson = numOfPerson;
    }
    
    public int getNumOfPerson() {
        return numOfPerson;
    }
    
    @Override
    public String toString() {
        return "";
        // TODO: Implement toString method
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RiskyPersons) {
            RiskyPersons other = (RiskyPersons)obj;
            return this.SA3Category.getLocation().getName().equals(other.SA3Category.getLocation().getName())
                    && this.SA3Category.getWeeklyIncome().toString().equals(other.SA3Category.getWeeklyIncome().toString())
                    && this.SA3Category.getIncomeSource().equals(other.SA3Category.getIncomeSource())
                    && this.SA3Category.getAge().toString().equals(other.SA3Category.getAge().toString())
                    && this.SA3Category.getGender().toString().equals(other.SA3Category.getGender().toString());
        }
        return false;
    }
}

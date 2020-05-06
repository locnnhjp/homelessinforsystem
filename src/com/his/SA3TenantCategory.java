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
public class SA3TenantCategory extends Person {
    private Location location;
    private WEEKLY_INCOME weeklyIncome;
    private String incomeSource;
    
    public SA3TenantCategory(AGE age, GENDER gender,
            Location location, 
            WEEKLY_INCOME weeklyIncome,
            String incomeSource) {
        super(age, gender);
        this.location = location;
        this.weeklyIncome = weeklyIncome;
        this.incomeSource = incomeSource;
    }
    
    public SA3TenantCategory() {
        this(null, null, null, null, null);
    }
    
    public SA3TenantCategory(SA3TenantCategory other) {
        this(other.getAge(), other.getGender(), 
                other.location, other.weeklyIncome, other.incomeSource);
    }
    
    public void setLocation(Location location) {
        this.location = location;
    }
    
    public Location getLocation() {
        return location;
    }
    
    public void setWeeklyIncome(WEEKLY_INCOME weeklyIncome) {
        this.weeklyIncome = weeklyIncome;
    }
    
    public WEEKLY_INCOME getWeeklyIncome() {
        return weeklyIncome;
    }
    
    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }
    
    public String getIncomeSource() {
        return incomeSource;
    }
    
    @Override
    public String toString() {
        return "";
        // TODO: implement toString
    }
}

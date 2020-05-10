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
public enum AGE {
    Category1("50-54", 50, 54),
    Category2("55-59", 55, 59),
    Category3("60-64", 60, 64),
    Category4("Over 65", 65, 200);
    
    private final String AGE_STRING;
    private final int MIN_AGE;
    private final int MAX_AGE;
    
    private AGE(String ageString, int minAge, int maxAge) {
        this.AGE_STRING = ageString;
        this.MIN_AGE = minAge;
        this.MAX_AGE = maxAge;
    }
    
    public String getAgeString() {
        return this.AGE_STRING;
    }
    public int getMIN_AGE() {
        return this.MIN_AGE;
    }
    
    public int getMAX_AGE() {
        return this.MAX_AGE;
    }
    
    @Override
    public String toString() {
        return AGE_STRING;
    }
}

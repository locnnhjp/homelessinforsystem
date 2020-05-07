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
    Category1(55, 54),
    Category2(55, 59),
    Category3(60, 64),
    Category4(65, 200);
    
    private final int MIN_AGE;
    private final int MAX_AGE;
    
    private AGE(int minAge, int maxAge) {
        this.MIN_AGE = minAge;
        this.MAX_AGE = maxAge;
    }
    
    public int getMIN_AGE() {
        return this.MIN_AGE;
    }
    
    public int getMAX_AGE() {
        return this.MAX_AGE;
    }
}

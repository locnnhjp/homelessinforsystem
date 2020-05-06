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
public enum WEEKLY_INCOME {
    Category1(-2000, 0),
    Category2(1, 399),
    Category3(400, 599),
    Category4(600, 999);
    
    private int minIncome;
    private int maxIncome;
    
    private WEEKLY_INCOME(int minIncome, int maxIncome) {
        this.minIncome = minIncome;
        this.maxIncome = maxIncome;
    }
    
    public int getMinIncome() {
        return this.minIncome;
    }
    
    public int getMaxIncome() {
        return this.maxIncome;
    }
}

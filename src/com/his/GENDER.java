package com.his;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anonymous
 */
public enum GENDER {
    GENDER_MALE("male"),
    GENDER_FEMALE("female");
    
    private String gender;
    
    private GENDER(String gender) {
        this.gender = gender;
    }
    
    public String getGENDER() {
        return this.gender;
    }
    
}

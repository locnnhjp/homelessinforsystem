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
public abstract class Person {
    private AGE age;
    private GENDER gender;
    
    public Person(AGE age, GENDER gender) {
        this.age = age;
        this.gender = gender;
    }
    
    public Person() {
        this(null, null);
    }
    
    public Person(Person otherPerson) {
        this(otherPerson.age, otherPerson.gender);
    }
    
    public void setAge(AGE age) {
        this.age = age;
    }
    
    public AGE getAge() {
        return age;
    }
    
    public GENDER getGender() {
        return gender;
    }
    
    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}

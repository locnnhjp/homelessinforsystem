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
public class Location {
    private String SA3code;
    private String name;
    
    public Location(String SA3code, String name) {
        this.SA3code = SA3code;
        this.name = name;
    }
    
    public Location() {
        this(null, null);
    }
    
    public Location(Location anotherLocation) {
        this(anotherLocation.SA3code, anotherLocation.name);
    }
    
    public void setSA3code(String SA3code) {
        this.SA3code = SA3code;
    }
    
    public String getSA3code() {
        return SA3code;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s", this.getSA3code(), this.getName());
    }
    
    
}

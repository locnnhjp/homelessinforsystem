/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author anonymous
 */

public class DataFile {
    private static final String DATA_FILE_PATH = "resource" + File.separator + "futureDemand.csv";
    private static final String EMPLOYED = "Employed";
    private static final String OTHER = "Other";
    private List<RiskyPersons> riskyPersonsList;
    
    public DataFile() {
        riskyPersonsList = new ArrayList<>();
        readFile();
    }
    
    public final void readFile() {
        riskyPersonsList = new ArrayList<>();
        // csv File import
        FileInputStream fi = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        try {
            fi = new FileInputStream(DATA_FILE_PATH);
            isr = new InputStreamReader(fi);
            br = new BufferedReader(isr);
            
            String line;
            
            // current line number;
            int i = 0;
            
            while ((line = br.readLine()) != null) {
                // pass first three lines
                if (i < 3) {
                    System.out.println(line);
                } else {
                    String[] data = line.split(",");
                    String SA3code = data[0];
                    String locationName = data[1];
                    Location location = new Location(SA3code, locationName);
                    WEEKLY_INCOME weeklyIncome = getWeeklyIncome(data[2]);
                    
                    GENDER gender = GENDER.GENDER_MALE;
                    // Male 50-54 years old, employed
                    AGE age = AGE.Category1;
                    String incomeSource = EMPLOYED;
                    int numOfPerson = Integer.parseInt(data[3]);
                    SA3TenantCategory category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    RiskyPersons riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male 50-54 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[4]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male 55-59 years old, Employed
                    age = AGE.Category2;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[5]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male 55-59 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[6]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male 60-64 years old, Employed
                    age = AGE.Category3;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[7]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male 60-64 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[8]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male over 65 years old, Employed
                    age = AGE.Category4;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[9]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Male over 65 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[10]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    
                    
                    gender = GENDER.GENDER_FEMALE;
                    // Female 50-54 years old, employed
                    age = AGE.Category1;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[11]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female 50-54 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[12]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female 55-59 years old, Employed
                    age = AGE.Category2;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[13]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female 55-59 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[14]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female 60-64 years old, Employed
                    age = AGE.Category3;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[15]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female 60-64 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[16]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female over 65 years old, Employed
                    age = AGE.Category4;
                    incomeSource = EMPLOYED;
                    numOfPerson = Integer.parseInt(data[17]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                    
                    // Female over 65 years old, other
                    incomeSource = OTHER;
                    numOfPerson = Integer.parseInt(data[18]);
                    category = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
                    riskyPersons = new RiskyPersons(category, numOfPerson);
                    this.riskyPersonsList.add(riskyPersons);
                }
                i++;
            }
            System.out.println(riskyPersonsList.size());
        } catch (FileNotFoundException e) {
            System.out.print("Data file not found!\n" + e);
        } catch (IOException | NumberFormatException e) {
            System.out.print("An error occurred while reading data file!\n" + e);
        } finally {
            try {
                if (fi != null) {
                    fi.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    
    public void setRiskyPersonsList(List<RiskyPersons> list) {
        this.riskyPersonsList = list;
    }
    
    public List<RiskyPersons> getRiskyPersonsList(){
        return riskyPersonsList;
    }

    private WEEKLY_INCOME getWeeklyIncome(String income) {
        switch (income) {
            case "Negative/Nil income":
                return WEEKLY_INCOME.Category1;
            case "$1-$399":
                return WEEKLY_INCOME.Category2;
            case "$400-$599":
                return WEEKLY_INCOME.Category3;
            default:
                return WEEKLY_INCOME.Category4;
        }
    }
    
}

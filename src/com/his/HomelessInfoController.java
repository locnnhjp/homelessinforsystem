/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anonymous
 */
public class HomelessInfoController implements Initializable {

    // Location tab
    @FXML
    private Tab locationTab;

    @FXML
    private Button AddLocationButton;

    @FXML
    private TextField SA3CodeTextField;

    @FXML
    private TextField LocationNameTextField;

    @FXML
    private Label SA3CodeLabel;

    @FXML
    private Label locationNameLabel;

    
    // Tenant tab
    @FXML
    private Tab tenantTab;

    @FXML
    private ComboBox<String> ageComboBox;
    
    private final ObservableList<String> ageList = 
            FXCollections.observableArrayList(AGE.Category1.getAgeString(), 
                    AGE.Category2.getAgeString(), AGE.Category3.getAgeString(), 
                    AGE.Category4.getAgeString());
    
    
    
    // Reports tab
    @FXML
    private ComboBox<String> rpLocationNameSelect;

    @FXML
    private ComboBox<WEEKLY_INCOME> rpIncomeSelect;

    @FXML
    private ComboBox<GENDER> rpGenderSelect;

    @FXML
    private ComboBox<AGE> rpAgeSelect;

    @FXML
    private ComboBox<String> rpIncomeSourceSelect;

    @FXML
    private Button makeReportButton;

    @FXML
    private Label rpDetailLabel;
    
    // init
    DataFile dataFile = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Read datafile
        dataFile = DataFile.getInstance();
        dataFile.readFile();
        // TODO
        ageComboBox.setItems(ageList);
        
        reportInit();
    }
    
    /**
     * Reports tab init method
    */
    public void reportInit() {
        // Reports tab
        ObservableList<String> locationNameList  =
                FXCollections.observableArrayList(dataFile.getLocationList());
        rpLocationNameSelect.setItems(locationNameList);
        
        ObservableList<WEEKLY_INCOME> weeklyIncomeList =
                FXCollections.observableArrayList(
                        WEEKLY_INCOME.Category1, 
                        WEEKLY_INCOME.Category2, 
                        WEEKLY_INCOME.Category3, 
                        WEEKLY_INCOME.Category4);
        rpIncomeSelect.setItems(weeklyIncomeList);
        
        ObservableList<GENDER> genderList = 
                FXCollections.observableArrayList(GENDER.GENDER_MALE, GENDER.GENDER_FEMALE);
        rpGenderSelect.setItems(genderList);
        
        ObservableList<AGE> ageList =
                FXCollections.observableArrayList(
                        AGE.Category1,
                        AGE.Category2,
                        AGE.Category3,
                        AGE.Category4
                );
        rpAgeSelect.setItems(ageList);
        
        ObservableList<String> incomeSourceList =
                FXCollections.observableArrayList("Employed", "Other");
        rpIncomeSourceSelect.setItems(incomeSourceList);
    }
    
    @FXML
    void addLocationButtonPressed(ActionEvent event) {
        boolean isSA3CodeEmpty = FormValidation.textFieldNotEmpty(SA3CodeTextField, SA3CodeLabel, "SA3Code is required!");
        boolean isLocationNameEmpy = FormValidation.textFieldNotEmpty(LocationNameTextField, locationNameLabel, "Location name is required!");
        
        if (isSA3CodeEmpty && isLocationNameEmpy) {
            boolean isValidSA3Code = FormValidation.isValidSA3Code(SA3CodeTextField, SA3CodeLabel, "SA3Code is invalid!");
            boolean isValidLocationName = FormValidation.isValidLocationName(LocationNameTextField, locationNameLabel, "Location name is invalid!");
            
            if (isValidSA3Code && isValidLocationName) {
                String SA3Code = SA3CodeTextField.getText();
                String locationName = LocationNameTextField.getText();
                try {
                    dataFile.addData(SA3Code, locationName);
                    
                    // Clear form
                    SA3CodeTextField.setText("");
                    LocationNameTextField.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    @FXML
    void makeReportButtonPressed(ActionEvent event) {
        String locationName = rpLocationNameSelect.getValue();
        Location location = new Location(locationName, "50000");
        GENDER gender = rpGenderSelect.getValue();
        AGE age = rpAgeSelect.getValue();
        WEEKLY_INCOME weeklyIncome = rpIncomeSelect.getValue();
        String incomeSource = rpIncomeSourceSelect.getValue();
        int result = -1;
        SA3TenantCategory sa3TenantCategory = new SA3TenantCategory(age, gender, location, weeklyIncome, incomeSource);
        RiskyPersons inputRiskyPersons = new RiskyPersons(sa3TenantCategory, 0);
        List<RiskyPersons> riskyPersonsList = dataFile.getRiskyPersonsList();
        System.out.println(riskyPersonsList.size());
        for (RiskyPersons riskyPersons : riskyPersonsList) {
            if (riskyPersons.equals(inputRiskyPersons)) {
                result = riskyPersons.getNumOfPerson();
            }
        }
        
        String rpDetail = "Location name: " + locationName + "\n"
                        + "Gender: " + gender.toString() + "\n"
                        + "Age: " + age.toString() + "\n"
                        + "Income source: " + incomeSource + "\n"
                        + "Weekly income: " + weeklyIncome.toString() + "\n"
                        + "Num of risky person: " + result;
        rpDetailLabel.setText(rpDetail);
    }
}

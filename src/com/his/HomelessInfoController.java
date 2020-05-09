/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author anonymous
 */
public class HomelessInfoController implements Initializable {

    @FXML
    private Tab locationTab;

    @FXML
    private Button AddLocationButton;

    @FXML
    private TextField SA3CodeTextField;

    @FXML
    private TextField LocationNameTextField;

    @FXML
    private Tab tenantTab;

    @FXML
    private ComboBox<String> ageComboBox;
    
    private final ObservableList<String> ageList = 
            FXCollections.observableArrayList(AGE.Category1.getAgeString(), 
                    AGE.Category2.getAgeString(), AGE.Category3.getAgeString(), 
                    AGE.Category4.getAgeString());
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ageComboBox.setItems(ageList);
    }    
    
}

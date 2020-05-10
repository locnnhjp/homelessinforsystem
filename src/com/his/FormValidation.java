/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.his;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author anonymous
 */
public class FormValidation {
    public static boolean textFieldNotEmpty(TextField tf) {
        boolean r = false;
        if (tf.getText() != null  && !tf.getText().isEmpty()) {
            r = true;
        }
        return r;
    }
    
    public static boolean textFieldNotEmpty(TextField tf, Label label, String aValidationText) {
        boolean r = true;
        String c = null;
        if (!textFieldNotEmpty(tf)) {
            r = false;
            c = aValidationText;
        }
        label.setText(c);
        return r;
    }
    
    public static boolean isValidSA3Code(TextField tf, Label label, String aValidationText) {
        boolean r = true;
        String c = null;
        Pattern p = Pattern.compile("^5[0-9]{4}$");
        Matcher m = p.matcher(tf.getText());
        if (!m.find()) {
            r = false;
            c = aValidationText;
        }
        label.setText(c);
        return r;
    }
    
    public static boolean isExistSA3Code(TextField tf, Label label, String aValidationText) {
        List<String> SA3CodeList = DataFile.getInstance().getSA3CodeList();
        boolean r = false;
        String c = null;
        if (SA3CodeList.contains(tf.getText())) {
            r = true;
            c = aValidationText;
        }
        label.setText(c);
        return r;
    }
    
    public static boolean isValidLocationName(TextField tf, Label label, String aValidationText) {
        boolean r = true;
        String c = null;
        Pattern p = Pattern.compile("^[A-Za-z]+( - [A-Za-z]+)*$");
        Matcher m = p.matcher(tf.getText());
        if (!m.find()) {
            r = false;
            c = aValidationText;
        }
        label.setText(c);
        return r;
    }
    
    public static boolean isExistLocationName(TextField tf, Label label, String aValidationText) {
        List<String> locationNameList = DataFile.getInstance().getLocationList();
        boolean r = false;
        String c = null;
        if (locationNameList.contains(tf.getText())) {
            r = true;
            c = aValidationText;
        }
        label.setText(c);
        return r;
    }
}

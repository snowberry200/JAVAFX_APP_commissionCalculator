package com.example.commissioncalculator_group21;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.math.BigDecimal;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;


//implement initializable to get access to the initialize method
public class Controller implements Initializable {

    //list down all required data and formulas
    BigDecimal sliderPercentage = new BigDecimal(5.0);

    private  static final NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en","gh"));
    //percentage variable
    //All controllers listed in the FXML file
    @FXML
    Label myLabel;
    @FXML
    Button calculateController;
    @FXML
    Button resetController;
    @FXML
    TextField totalSalesController;
    @FXML
    Slider sliderController;
    @FXML
    TextField commissionController;
    
    //calculating commission
    @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
    int mySliderValue = (int)sliderController.getValue();
    myLabel.setText(Integer.toString(mySliderValue)+"%");
        sliderController.valueProperty().addListener(new ChangeListener<Number>() {
            @Override

            //method for calculating commission based on the changes in the slider.

            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                sliderPercentage = BigDecimal.valueOf(newValue.intValue()/100.0);
                int mySliderValue = (int)sliderController.getValue();
                myLabel.setText(Integer.toString (mySliderValue)+"%");
                myLabel.setTextFill(Color.RED);
            }
        });

    }
        public void onCalculate(){
            try {
                currency.setGroupingUsed(true);
                BigDecimal totalSales = new BigDecimal(totalSalesController.getText());
                BigDecimal commission = totalSales.multiply(sliderPercentage);
                commissionController.setText(currency.format(commission));
            }catch( NumberFormatException e){
                totalSalesController.setText("please enter an Amount to proceed");
                myLabel.setText("CHOOSE COMMISSION RATE!!");
                myLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR,12));
                myLabel.setTextFill(Color.RED);
                //totalSalesController.selectAll();
                totalSalesController.requestFocus();
            }


        }

        //re-setting in the app
        public void onReset(){
            totalSalesController.setText(null);
            commissionController.setText(null);
            sliderController.setValue(0.0);

        }
}
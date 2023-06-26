package com.internshala.temp;

//import com.sun.deploy.xml.XMLable;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox1;
	@FXML
	public ChoiceBox<String> choiceBox2;
	@FXML
	public TextField userInput;
	@FXML
	public TextField resultField;
	@FXML
	public Button convertButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		choiceBox1.getItems().add("Celsius");
		choiceBox1.getItems().add("Fahrenheit");
		choiceBox1.getItems().add("Rankine");
		choiceBox1.getItems().add("Kelvin");

		choiceBox2.getItems().add("Celsius");
		choiceBox2.getItems().add("Fahrenheit");
		choiceBox2.getItems().add("Rankine");
		choiceBox2.getItems().add("Kelvin");

		choiceBox1.setValue("Celsius");
		choiceBox2.setValue("Fahrenheit");


		convertButton.setOnAction(event -> {
			convert();
		});

	}

	private void convert() {
		float enteredtemp = 0.0f;
		String input = 	userInput.getText(); // 23.4 = "23.4"

		try
		{
			enteredtemp = Float.parseFloat(input);
		}
		catch (NumberFormatException e)
		{
			warnUser("Invalid Temperature Entered" ,"Please enter a valid temperature.");
			return;
		}

		String fromUnit = choiceBox1.getValue();
		String toUnit = choiceBox2.getValue();

		if (fromUnit.equals(toUnit)) {
			warnUser("Invalid Unit Selection", "Please select different units for conversion.");
			return;
		}

		double convertedTemp;


		if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit"))
		{
			convertedTemp = (enteredtemp * 9 / 5) + 32;
		}
		else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin"))
		{
			convertedTemp = (enteredtemp + 273.15);
		}
		else if (fromUnit.equals("Celsius") && toUnit.equals("Rankine"))
		{
			convertedTemp = (enteredtemp +273.15) * 9 / 5;
		}
		else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius"))
		{
			convertedTemp = (enteredtemp - 32) * 5 / 9;
		}
		else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin"))
		{
			convertedTemp = (enteredtemp + 459.67) * 5 / 9;
		}
		else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Rankine"))
		{
			convertedTemp = (enteredtemp + 459.67);
		}
		else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius"))
		{
			convertedTemp = (enteredtemp - 273.15);
		}
		else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit"))
		{
			convertedTemp = (enteredtemp * 9/5) - 459.67;
		}
		else if (fromUnit.equals("Kelvin") && toUnit.equals("Rankine"))
		{
			convertedTemp = (enteredtemp * 9/5);
		}
		else if (fromUnit.equals("Rankine") && toUnit.equals("Celsius"))
		{
			convertedTemp = (enteredtemp - 491.67) * 5 / 9;
		}
		else if (fromUnit.equals("Rankine") && toUnit.equals("Fahrenheit"))
		{
			convertedTemp = (enteredtemp - 459.67);
		}
		else if (fromUnit.equals("Rankine") && toUnit.equals("Kelvin"))
		{
			convertedTemp = (enteredtemp *5/9);
		}

		else {
			warnUser("Unsupported Conversion", "The selected conversion is not supported.");
			return;
		}

		resultField.setText(String.valueOf(convertedTemp));
	}

	private void warnUser(String header, String content) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText(header);
		alert.setContentText(content);
		alert.show();
	}

}










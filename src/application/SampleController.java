package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

public class SampleController {
	@FXML
	private Button Convertir;
	@FXML
	private Button Cambiar;
	@FXML
	private ComboBox<String> Unit;
	@FXML
	private ComboBox<String> TextInput;
	@FXML
	private ComboBox<String> TextOutput;
	@FXML
	private TextField NumberInput;
	@FXML
	private Label UnitInput;
	@FXML
	private Label NumerOutput;
	@FXML
	private Label UnitOutput;
	private String TipoDato;
	private String DatoEntrada;
	private String DatoSalida;
	private String UnidadEntrada;
	private String UnidadSalida;
	private double Number;
	private String NumberString;
	private String Result;
	/**
	 * initialize nos inicializa y agrega texto al combobox.
	 */
	@FXML
 	public void initialize() {
	       Unit.getItems().addAll(FXCollections.observableArrayList(
	    	        "TEMPERATURA", "MASA","DIVISAS","LONGITUD",/*"AREA","VOLUMEN",*/"TIEMPO"));
		}	// Event Listener on Button[#Convertir].onAction	
	// Event Listener on Button[#Cambiar].onAction
	@FXML
	public void CambiarAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#Unit].onAction
	/**UnitAction cuando se hace algo en Unit, puedes elegir en TextInput y TextOutput. 
	 * 
	 * @param event
	 */
	@FXML
	public void UnitAction(ActionEvent event) {
		TipoDato = Unit.getValue();
		   switch (TipoDato) {
			   case "TEMPERATURA":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius(°C)","Kelvin(°K)","Farenheit(°F)","Rankine(°R)"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius(°C)","Kelvin(°K)","Farenheit(°F)","Rankine(°R)"));
				   break;
			   case "MASA":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						    "Strone(st)", "Libra(lb)", "Onza(oz)","Tonelada(T)", "Kilogramo(kg)", "Gramos(g)","Centigramos(cg)", "Miligramo(mg)", "Microgramo(μg)"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Strone(st)", "Libra(lb)", "Onza(oz)","Tonelada(T)", "Kilogramo(kg)", "Gramos(g)","Centigramos(cg)", "Miligramo(mg)", "Microgramo(μg)"));
				   break;
			   case "DIVISAS":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Dolar Estadounidense(USD)","Peso Mexicano (MXN)","EURO(EUR)","Yen Japones(JPY)","Won Coreano(KRW)","Libra Esterlina(GBP)"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Dolar Estadounidense(USD)","Peso Mexicano (MXN)","EURO(EUR)","Yen Japones(JPY)","Won Coreano(KRW)","Libra Esterlina(GBP)"));
				   break;
			   case "LONGITUD":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Metro(m)","Kilometro(km)","Centimetro(cm)","Decimetro(dm)", "Milimetro(mm)", "Micrometro(μm)", "Nanometro(nm)", "Yarda(yd)", "Pie(ft)", "Pulgada(in)", "Milla(mi)" ));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Metro(m)","Kilometro(km)","Centimetro(cm)","Decimetro(dm)", "Milimetro(mm)", "Micrometro(μm)", "Nanometro(nm)", "Yarda(yd)", "Pie(ft)", "Pulgada(in)", "Milla(mi)" ));
				   break;
			   /*case "AREA":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius","Kelvin","Farenheit","Rankine"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius","Kelvin","Farenheit","Rankine"));
				   break;
			   case "VOLUMEN":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius","Kelvin","Farenheit","Rankine"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Celcius","Kelvin","Farenheit","Rankine"));
				   break;*/
			   case "TIEMPO":
				   TextInput.getSelectionModel().clearSelection();
				   TextInput.getItems().clear();
				   TextOutput.getSelectionModel().clearSelection();
				   TextOutput.getItems().clear();
				   TextInput.getItems().addAll(FXCollections.observableArrayList(
						   "Minutos", "Segundos", "Horas","Días","Años","Meses"));
				   TextOutput.getItems().addAll(FXCollections.observableArrayList(
						   "Minutos", "Segundos", "Horas","Días","Años","Meses"));
				   break;
		   }
	}
	// Event Listener on ComboBox[#TextInput].onAction
	@FXML
	public void TextInputAction(ActionEvent event) {
		DatoEntrada = TextInput.getValue();
		try {
		switch (TipoDato) {
		   case "TEMPERATURA":
			   switch (DatoEntrada) {
			   case "Celcius(°C)":
				   UnidadEntrada = "°C";
				   break; 
			   case "Kelvin(°K)":
				   UnidadEntrada = "°K";
				   break;
			   case "Farenheit(°F)":
				   UnidadEntrada = "°F";
				   break;
			   case"Rankine(°R)":
				   UnidadEntrada = "°R";
				   break;
			   }
			   break;
		   case "MASA":
			   switch (DatoEntrada) {
			   	case "Strone(st)":
					UnidadEntrada = "st";
			   		break; 
			   	case "Libra(lb)":
					UnidadEntrada = "ib";
					break; 
			   	case "Onza(oz)":
					UnidadEntrada = "oz";
					break; 
			   	case "Tonelada(T)":
					UnidadEntrada = "T";
			   		break; 
			   	case "Kilogramo(kg)":
					UnidadEntrada = "kg";
					break; 
			   	case "Gramos(g)":
					UnidadEntrada = "g";
					break; 
			   	case "Centigramos(cg)":
			   		UnidadEntrada = "cg";
			   		break; 
			   	case "Miligramo(mg)":
					UnidadEntrada = "mg";
			   		break; 
			   	case "Microgramo(μg)":
					UnidadEntrada = "μg";
			   		break; 
			   }
			   break;
		   case "DIVISAS":
			   switch (DatoEntrada) {
			   case "Dolar Estadounidense(USD)":
					UnidadEntrada = "USD";
			   		break; 
			   case "Peso Mexicano (MXN)":
					UnidadEntrada = "MXN";
			   		break; 
			   case "EURO(EUR)":
					UnidadEntrada = "EUR";
			   		break; 
			   case "Yen Japones(JPY)":
					UnidadEntrada = "JPY";
			   		break; 
			   case "Won Coreano(KRW)":
					UnidadEntrada = "KRW";
			   		break; 
			   case "Libra Esterlina(GBP)":
					UnidadEntrada = "GBP";
			   		break; 
			   }
			   break;
		   case "LONGITUD":
			   switch (DatoEntrada) {
			   case "Metro(m)":
					UnidadEntrada = "m";
			   		break; 
			   case "Kilometro(km)":
					UnidadEntrada = "km";
			   		break; 
			   case "Centimetro(cm)":
					UnidadEntrada = "cm";
			   		break; 
			   case "Decimetro(dm)":
					UnidadEntrada = "dm";
			   		break; 
			   case "Milimetro(mm)": 
					UnidadEntrada = "mm";
			   		break; 
			   case "Micrometro(μm)":
					UnidadEntrada = "μm";
			   		break; 
			   case "Nanometro(nm)":
					UnidadEntrada = "nm";
			   		break;    
			   case "Yarda(yd)":
					UnidadEntrada = "yd";
			   		break; 
			   case "Pie(ft)":
					UnidadEntrada = "ft";
			   		break; 
			   case "Pulgada(in)":
					UnidadEntrada = "in";
			   		break; 
			   case "Milla(mi)":
					UnidadEntrada = "mi";
			   		break; 
			   }
			   break;
		   case "TIEMPO":
			   switch (DatoEntrada) {
			   case "Minutos":
					UnidadEntrada = "Minutos";
			   		break; 
			   case "Segundos":
					UnidadEntrada = "Segundos";
			   		break; 
			   case "Horas":
					UnidadEntrada = "Horas";
			   		break; 
			   case "Días":
					UnidadEntrada = "Días";
			   		break; 
			   case "Años":
				UnidadEntrada = "Años";
		   		break; 
			   case "Meses":
					UnidadEntrada = "Meses";
			   		break; 
			   }
			   break;
		}
		UnitInput.setText(UnidadEntrada);
		}
		catch(Exception e) {
			//DatoEntrada.("Unidad de Entrada");
			UnitInput.setText("UNIDAD");
		}
	}
	// Event Listener on ComboBox[#TextOutput].onAction
	@FXML
	public void TextOutputAction(ActionEvent event) {
		DatoSalida = TextOutput.getValue();
		try {
		switch (TipoDato) {
		   case "TEMPERATURA":
			   switch (DatoSalida) {
			   case "Celcius(°C)":
				   UnidadEntrada = "°C";
				   break; 
			   case "Kelvin(°K)":
				   UnidadEntrada = "°K";
				   break;
			   case "Farenheit(°F)":
				   UnidadEntrada = "°F";
				   break;
			   case"Rankine(°R)":
				   UnidadEntrada = "°R";
				   break;
			   }
			   break;
		   case "MASA":
			   switch (DatoSalida) {
			   	case "Strone(st)":
					UnidadSalida = "st";
			   		break; 
			   	case "Libra(lb)":
					UnidadSalida = "ib";
					break; 
			   	case "Onza(oz)":
					UnidadSalida = "oz";
					break; 
			   	case "Tonelada(T)":
					UnidadSalida = "T";
			   		break; 
			   	case "Kilogramo(kg)":
					UnidadSalida = "kg";
					break; 
			   	case "Gramos(g)":
					UnidadSalida = "g";
					break; 
			   	case "Centigramos(cg)":
			   		UnidadSalida = "cg";
			   		break; 
			   	case "Miligramo(mg)":
					UnidadSalida = "mg";
			   		break; 
			   	case "Microgramo(μg)":
					UnidadSalida = "μg";
			   		break; 
				
			   }
			   break;
		   case "DIVISAS":
			   switch (DatoSalida) {
			   case "Dolar Estadounidense(USD)":
					UnidadSalida = "USD";
			   		break; 
			   case "Peso Mexicano (MXN)":
					UnidadSalida = "MXN";
			   		break; 
			   case "EURO(EUR)":
				    UnidadSalida = "EUR";
			   		break; 
			   case "Yen Japones(JPY)":
				    UnidadSalida = "JPY";
			   		break; 
			   case "Won Coreano(KRW)":
				    UnidadSalida = "KRW";
			   		break; 
			   case "Libra Esterlina(GBP)":
				    UnidadSalida = "GBP";
			   		break; 
			   }
			   break;
		   case "LONGITUD":
			   switch (DatoSalida) {
			   case "Metro(m)":
				   UnidadSalida = "m";
			   		break; 
			   case "Kilometro(km)":
				   UnidadSalida = "km";
			   		break; 
			   case "Centimetro(cm)":
				   UnidadSalida = "cm";
			   		break; 
			   case "Decimetro(dm)":
				   UnidadSalida = "dm";
			   		break; 
			   case "Milimetro(mm)": 
				   UnidadSalida = "mm";
			   		break; 
			   case "Micrometro(μm)":
				   UnidadSalida = "μm";
			   		break; 
			   case "Nanometro(nm)":
				   UnidadSalida = "nm";
			   		break;    
			   case "Yarda(yd)":
				   UnidadSalida = "yd";
			   		break; 
			   case "Pie(ft)":
				   UnidadSalida = "ft";
			   		break; 
			   case "Pulgada(in)":
				   UnidadSalida = "in";
			   		break; 
			   case "Milla(mi)":
				   UnidadSalida = "mi";
			   		break; 
			   }
			   break;
		   case "TIEMPO":
			   switch (DatoSalida) {
			   case "Minutos":
				   UnidadSalida = "Minutos";
			   		break; 
			   case "Segundos":
				   UnidadSalida = "Segundos";
			   		break; 
			   case "Horas":
				   UnidadSalida = "Horas";
			   		break; 
			   case "Días":
				   UnidadSalida = "Días";
			   		break; 
			   case "Años":
				   UnidadSalida = "Años";
		   		break; 
			   case "Meses":
				   UnidadSalida = "Meses";
			   		break; 
			   }
			   break;
		}
		UnitOutput.setText(UnidadSalida);
}
catch(Exception x){
	//DatoSalida = "Unidad de Salida";
	UnitOutput.setText("UNIDAD");
	}
}
	// Event Listener on TextField[#NumberInput].onAction
	@FXML
	public void NumberInputAction(ActionEvent event) {
		// TODO Autogenerated
	}
	@FXML
	public void ConvertirAction(ActionEvent event) {
		try {
		NumberString = NumberInput.getText();
		Number = Double.parseDouble(NumberString);
		switch (TipoDato) {
		
		   case "TEMPERATURA":
		
		}
		
		Result = String.valueOf(Number);
		NumerOutput.setText(Result);
		}
		catch(Exception a){
			
		}
	}
}
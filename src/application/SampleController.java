package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
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
	public double Number;
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
				   UnidadSalida = "°C";
				   break; 
			   case "Kelvin(°K)":
				   UnidadSalida = "°K";
				   break;
			   case "Farenheit(°F)":
				   UnidadSalida = "°F";
				   break;
			   case"Rankine(°R)":
				   UnidadSalida = "°R";
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
	public double Conversion(double Number, String DatoEntrada, String DatoSalida) {
		double resultado = 0; 
		switch (TipoDato) {
		
		   case "TEMPERATURA":
			   resultado = TemperatureConversion(Number,DatoEntrada,DatoSalida);
			   break;
			case "MASA":
				resultado = MasaConversion(Number,DatoEntrada,DatoSalida);
				break;
			case "DIVISAS":
				resultado = DivisaConversion(Number,DatoEntrada,DatoSalida);
				break;
			case "LONGITUD":
				resultado = LongitudConversion(Number,DatoEntrada,DatoSalida);
				break;
			case "TIEMPO":
				resultado = TiempoConversion(Number,DatoEntrada,DatoSalida);
				break;
		}
		return resultado;
	}
	public double TemperatureConversion(double Number, String DatoEntrada, String DatoSalida) {
		double ValorInicial = Number;
		double ValorConvertido = 0;
		double ValorFinal = 0;

		switch (DatoEntrada) {
		   	 case "Celcius(°C)":
		   		 ValorConvertido = ValorInicial;
		   		 break;
		   	 case "Kelvin(°K)":
		   		ValorConvertido = ValorInicial - 273.15;
		   		break;
		     case "Farenheit(°F)":
		    	 ValorConvertido = (ValorInicial - 32) / 1.8;
		   		break; 
		     case "Rankine(°R)":
		    	 ValorConvertido = (ValorInicial - 491.67) / 1.8;
		   		break; 
   	 }
		switch (DatoSalida) {
		   	 case "Celcius(°C)":
		   		 ValorFinal = ValorConvertido;
		   		 break;
		     case "Kelvin(°K)":
		            ValorFinal = ValorConvertido + 273.15;
		            break;
		        case "Farenheit(°F)":
		        	ValorFinal = ValorConvertido*1.8 + 32;
		            break;
		        case "Rankine(°R)":
		        	ValorFinal = ValorConvertido*1.8 + 491.67;
		            break;
		    }
		return ValorFinal;
	}
	public double DivisaConversion(double Number, String DatoEntrada, String DatoSalida) {
		double ValorInicial = Number;
		double ValorConvertido = 0;
		double ValorFinal = 0;
		double valor = 0;
		String UnidadAPI;
		

		switch (DatoEntrada) {
		   case "EURO(EUR)":
				UnidadEntrada = "EUR";
		   		ValorConvertido = ValorInicial;
		   		break;
		   case "Dolar Estadounidense(USD)":
				UnidadEntrada = "USD";
				UnidadAPI= UnidadEntrada;
				valor = API(UnidadAPI);
		   		 ValorConvertido = ValorInicial/valor;
		   		break; 
		   case "Peso Mexicano (MXN)":
				UnidadEntrada = "MXN";
				UnidadAPI= UnidadEntrada;
				valor = API(UnidadAPI);
		   		 ValorConvertido = ValorInicial/valor;
		   		break; 
 
		   case "Yen Japones(JPY)":
				UnidadEntrada = "JPY";
				UnidadAPI= UnidadEntrada;
				valor = API(UnidadAPI);
		   		 ValorConvertido = ValorInicial/valor;
		   		break; 
		   case "Won Coreano(KRW)":
				UnidadEntrada = "KRW";
				UnidadAPI= UnidadEntrada;
				valor = API(UnidadAPI);
		   		 ValorConvertido = ValorInicial/valor;
		   		break; 
		   case "Libra Esterlina(GBP)":
				UnidadEntrada = "GBP";
				UnidadAPI= UnidadEntrada;
				valor = API(UnidadAPI);
		   		ValorConvertido = ValorInicial/valor;
		   		break; 
   	 }
		switch (DatoSalida) {
		   case "Dolar Estadounidense(USD)":
				UnidadSalida = "USD";
				UnidadAPI= UnidadSalida;
				valor = API(UnidadAPI);
		   		 ValorFinal = ValorConvertido*valor;
		   		break; 
		   case "Peso Mexicano (MXN)":
			   UnidadSalida = "MXN";
				UnidadAPI= UnidadSalida;
				valor = API(UnidadAPI);
		   		 ValorFinal = ValorConvertido*valor;
		   		break; 
		   case "EURO(EUR)":
			   UnidadSalida = "EUR";
			   ValorFinal = ValorConvertido;
		   		break; 
		   case "Yen Japones(JPY)":
			   UnidadSalida = "JPY";
				UnidadAPI= UnidadSalida;
				valor = API(UnidadAPI);
		   		 ValorFinal = ValorConvertido*valor;
		   		break; 
		   case "Won Coreano(KRW)":
			   UnidadSalida = "KRW";
				UnidadAPI= UnidadSalida;
				valor = API(UnidadAPI);
		   		 ValorFinal = ValorConvertido*valor;
		   		break; 
		   case "Libra Esterlina(GBP)":
			   UnidadSalida = "GBP";
				UnidadAPI= UnidadSalida;
				valor = API(UnidadAPI);
		   		 ValorFinal = ValorConvertido*valor;
		   		break; 
		    }
		return ValorFinal;
	}
	public double LongitudConversion(double Number, String DatoEntrada, String DatoSalida) {
		double ValorInicial = Number;
		double ValorConvertido = 0;
		double ValorFinal = 0;
		ValorInicial=Number;
		switch (DatoEntrada) {
		   case "Metro(m)":
			   ValorConvertido = ValorInicial;
		   		break; 
		   case "Kilometro(km)":
			   ValorConvertido = ValorInicial*1000;
		   		break; 
		   case "Centimetro(cm)":
			   ValorConvertido = ValorInicial*.01;
		   		break; 
		   case "Decimetro(dm)":
			   ValorConvertido = ValorInicial*.1;
		   		break; 
		   case "Milimetro(mm)": 
			   ValorConvertido = ValorInicial*.001;
		   		break; 
		   case "Micrometro(μm)":
			   ValorConvertido = ValorInicial*.000001;
		   		break; 
		   case "Nanometro(nm)":
			   ValorConvertido = ValorInicial*.000000001;
		   		break;    
		   case "Yarda(yd)":
			   ValorConvertido = ValorInicial*0.9144;
		   		break; 
		   case "Pie(ft)":
			   ValorConvertido = ValorInicial*0.3048;
		   		break; 
		   case "Pulgada(in)":
			   ValorConvertido = ValorInicial*0.0254;
		   		break; 
		   case "Milla(mi)":
			   ValorConvertido = ValorInicial*1609.34;
		   		break; 
		   }
		switch (DatoEntrada) {
		   case "Metro(m)":
			   ValorFinal = ValorConvertido;
		   		break; 
		   case "Kilometro(km)":
			   ValorFinal = ValorConvertido/1000;
		   		break; 
		   case "Centimetro(cm)":
			   ValorFinal = ValorConvertido/.01;
		   		break; 
		   case "Decimetro(dm)":
			   ValorFinal = ValorConvertido/.1;
		   		break; 
		   case "Milimetro(mm)": 
			   ValorFinal = ValorConvertido/.001;
		   		break; 
		   case "Micrometro(μm)":
			   ValorFinal = ValorConvertido/.000001;
		   		break; 
		   case "Nanometro(nm)":
			   ValorFinal = ValorConvertido/.000000001;
		   		break;    
		   case "Yarda(yd)":
			   ValorFinal = ValorConvertido/0.9144;
		   		break; 
		   case "Pie(ft)":
			   ValorFinal = ValorConvertido/0.3048;
		   		break; 
		   case "Pulgada(in)":
			   ValorFinal = ValorConvertido/0.0254;
		   		break; 
		   case "Milla(mi)":
			   ValorFinal = ValorConvertido/1609.34;
		   		break; 
		   }

		return ValorFinal;
	}		
	public double TiempoConversion(double Number, String DatoEntrada, String DatoSalida) {
		double ValorInicial = Number;
		double ValorConvertido = 0;
		double ValorFinal = 0;
		ValorInicial=Number;
		switch (DatoEntrada) {
		   case "Segundos":
				ValorConvertido = ValorInicial;
		   		break;
		   case "Minutos":
				ValorConvertido = ValorInicial*60;
		   		break; 
		   case "Horas":
				ValorConvertido = ValorInicial*60*60;
		   		break; 
		   case "Días":
				ValorConvertido = ValorInicial*60*60*24;
		   		break; 
		   case "Años":
			   ValorConvertido = ValorInicial*60*60*24*365.242;
	   		break; 
		   case "Meses":
			   ValorConvertido = ValorInicial*60*60*24*30.4368;
		   		break;
		}
		switch (DatoSalida) {
		   case "Segundos":
			   ValorFinal = ValorConvertido;
		   		break;
		   case "Minutos":
			   ValorFinal = ValorConvertido/60;
		   		break; 
		   case "Horas":
			   ValorFinal = ValorConvertido/60/60;
		   		break; 
		   case "Días":
			   ValorFinal = ValorConvertido/60/60/24;
		   		break; 
		   case "Años":
			   ValorFinal = ValorConvertido/60/60/24/365.242;
	   		break; 
		   case "Meses":
			   ValorFinal = ValorConvertido/60/60/24/30.4368;
		   		break;
		}
		return ValorFinal;
	
		
	}
	public double MasaConversion(double Number, String DatoEntrada, String DatoSalida) {
		double ValorInicial = Number;
		double ValorConvertido = 0;
		double ValorFinal = 0;
		ValorInicial=Number;
		   switch (DatoEntrada) {
		   	case "Gramos(g)":
				ValorConvertido = ValorInicial;
				break; 
		   	case "Strone(st)":
				ValorConvertido = ValorInicial*6350.29;
		   		break; 
		   	case "Libra(lb)":
				ValorConvertido = ValorInicial*453.592;
				break; 
		   	case "Onza(oz)":
				ValorConvertido = ValorInicial*28.3495;
				break; 
		   	case "Tonelada(T)":
				ValorConvertido = ValorInicial*1000000;
		   		break; 
		   	case "Kilogramo(kg)":
				ValorConvertido = ValorInicial*1000;
				break; 
		   	case "Centigramos(cg)":
				ValorConvertido = ValorInicial*.01;
		   		break; 
		   	case "Miligramo(mg)":
				ValorConvertido = ValorInicial*.001;
		   		break; 
		   	case "Microgramo(μg)":
				ValorConvertido = ValorInicial*.000001;
		   		break; 
		   }
		   switch (DatoSalida) {
		   	case "Gramos(g)":
		   		ValorFinal = ValorConvertido;
				break; 
		   	case "Strone(st)":
		   		ValorFinal = ValorConvertido/6350.29;
		   		break; 
		   	case "Libra(lb)":
		   		ValorFinal = ValorConvertido/453.592;
				break; 
		   	case "Onza(oz)":
		   		ValorFinal = ValorConvertido/28.3495;
				break; 
		   	case "Tonelada(T)":
		   		ValorFinal = ValorConvertido/1000000;
		   		break; 
		   	case "Kilogramo(kg)":
		   		ValorFinal = ValorConvertido/1000;
				break; 
		   	case "Centigramos(cg)":
		   		ValorFinal = ValorConvertido/.01;
		   		break; 
		   	case "Miligramo(mg)":
		   		ValorFinal = ValorConvertido/.001;
		   		break; 
		   	case "Microgramo(μg)":
		   		ValorFinal = ValorConvertido/.000001;
		   		break; 
		   }
		return ValorFinal;
		
	}
	@FXML
	public void ConvertirAction(ActionEvent event) {
		double Convertido = 0;
		try {
		NumberString = NumberInput.getText();
		Number = Double.parseDouble(NumberString);
		Convertido = Conversion(Number, DatoEntrada, DatoSalida);
		BigDecimal bigDecimal = new BigDecimal(Convertido).setScale(4, RoundingMode.HALF_UP);
		Result = String.valueOf(bigDecimal);
		NumerOutput.setText(Result);
		
		System.out.println(bigDecimal.doubleValue());
	}
		catch(Exception a){
			
		}
	}
	public double API(String UnidadEntrada) {
	        JSONObject jsonObject = new JSONObject();
	        JSONObject ratesObject = new JSONObject();
	        String Currency;
	        double rate;

	        try {
	            URL url = new URL("https://api.frankfurter.app/latest");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            conn.setRequestMethod("GET");
	            conn.connect();

	            int responseCode = conn.getResponseCode();
	            if (responseCode != 200) {
	                throw new RuntimeException("Ocurrio un error:" + responseCode);
	            } 
	            else {
		            StringBuilder informationString = new StringBuilder();
		            Scanner scanner = new Scanner(url.openStream());
		            while (scanner.hasNext()) {
	                informationString.append(scanner.nextLine());
                }
                scanner.close();
                jsonObject = new JSONObject(informationString.toString());
                ratesObject = jsonObject.getJSONObject("rates");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        Currency = UnidadEntrada;
	        rate = ratesObject.getDouble(Currency);
	        return rate;
	    }
}
	package application;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.util.Scanner;
	import org.json.JSONArray;
	import org.json.JSONException;
	import org.json.JSONObject;
	import org.json.JSONString;
	
	public class API {
		public static void main(String[] args) {
			JSONObject jsonObject = new JSONObject();;
			
			try {
				URL url = new URL ("https://api.frankfurter.app/latest");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
					
				int responseCode = conn.getResponseCode();
				if(responseCode != 200) {
					throw new RuntimeException("Ocurrio un error:" + responseCode);
				} else { 
					StringBuilder informationString = new StringBuilder();
					Scanner scanner = new Scanner(url.openStream());
						
					while (scanner.hasNext()) {
						informationString.append(scanner.nextLine());
					} 
					scanner.close();
					System.out.println(informationString);
						
					jsonObject = new JSONObject(informationString.toString());
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		System.out.println(jsonObject.getString("base"));
		System.out.println(jsonObject.getDouble("amount"));
	    //Cash[] = jsonObject.get("rates");
		}
	}
	//https://api.metalpriceapi.com/v1/latest?api_key=cc5acb80f2a111074f265b823927c73e&base=USD&currencies=EUR,MXN,GBP,JPY,KRW,COP,USD
	// {"success":true,"base":"USD","timestamp":1688533220,"rates":{"COP":4148.205,"EUR":0.9194485,"GBP":0.787065,"JPY":144.52053605,"KRW":1300.01255452,"MXN":17.05595781,"USD":1}}
	//{"amount":1.0,"base":"EUR","date":"2023-08-04","rates":{"AUD":1.6694,"BGN":1.9558,"BRL":5.3729,"CAD":1.4648,"CHF":0.9598,"CNY":7.8661,"CZK":24.26,"DKK":7.4514,"GBP":0.86193,"HKD":8.5485,"HUF":391.73,"IDR":16625,"ILS":4.0347,"INR":90.73,"ISK":144.9,"JPY":156.11,"KRW":1435.4,"MXN":18.9566,"MYR":4.9859,"NOK":11.1858,"NZD":1.8009,"PHP":61.073,"PLN":4.4485,"RON":4.953,"SEK":11.7,"SGD":1.4701,"THB":38.081,"TRY":29.544,"USD":1.0946,"ZAR":20.421}}

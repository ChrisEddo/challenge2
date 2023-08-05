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
		}
	}
	//https://api.metalpriceapi.com/v1/latest?api_key=cc5acb80f2a111074f265b823927c73e&base=USD&currencies=EUR,MXN,GBP,JPY,KRW,COP,USD
	// {"success":true,"base":"USD","timestamp":1688533220,"rates":{"COP":4148.205,"EUR":0.9194485,"GBP":0.787065,"JPY":144.52053605,"KRW":1300.01255452,"MXN":17.05595781,"USD":1}}
}

package iut.android.iut_carpool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

public class Test  {

		public String result2;
		public static final String strURL = "http://10.103.50.14/poolcar/script.php";
		
		public void run(){
		

			InputStream is = null;
			String result = "";
			
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		    nameValuePairs.add(new BasicNameValuePair("ville","L"));
		    String error = "";
			// Envoie de la commande http
			try {
				  error = "non ";
				HttpClient httpclient = new DefaultHttpClient();
				  error = "HttpClient ok";
				HttpPost httppost = new HttpPost(strURL);
				  error ="HttpPost ok";
				//httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				 // error ="httppost.setEntity ok";
				HttpResponse response = httpclient.execute(httppost);
				  error ="HttpResponse ok";
				HttpEntity entity = response.getEntity();
				  error ="HttpEntity ok";
				is = entity.getContent();
					System.out.println("is = entity.getContent() ok");

			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
			}

			// Convertion de la requête en string
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						is, "iso-8859-1"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				result = sb.toString();
			} catch (Exception e) {
				Log.e("log_tag", "Error converting result " + e.toString());
			}
			// Parse les données JSON
			try {
				
				String datas = " ";
				JDOM1 file = new JDOM1();
				JSONArray jArray = new JSONArray(result);
				for (int i = 0; i < jArray.length(); i++) {
					JSONObject json_data = jArray.getJSONObject(i);
					// Affichage ID_ville et Nom_ville dans le LogCat
					Log.i("log_tag", "phoneNumber: " + json_data.getInt("phoneNumber")
							+ " \n name: " + json_data.getString("name")
							+ " \n adress: " + json_data.getString("adress")
							+ " \n coordinates: " + json_data.getString("coordinates")
							);				
					datas += "\n\t" + jArray.getJSONObject(i);	
				}
				Toast.makeText(CarPool.getContext(), datas,Toast.LENGTH_LONG).show();
				file.WriteSettings(CarPool.getContext(), datas);
				
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}
			
			}
		
}

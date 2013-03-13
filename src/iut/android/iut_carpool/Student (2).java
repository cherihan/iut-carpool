package iut.android.iut_carpool;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Student {
	// Mettre l'adresse du script PHP
	// Attention localhost ou 127.0.0.1 ne fonctionnent pas. Mettre l'adresse IP
	// local.
	
	public String returnString;

	public void getServerData(){
		Test test = new Test();
		test.run();
		returnString = test.result2;
	
	}
	
}
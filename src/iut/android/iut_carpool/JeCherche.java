package iut.android.iut_carpool;

import android.os.Bundle;
import android.app.Activity;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class JeCherche extends Activity implements OnClickListener {

	EditText nom, adresse, phoneNumber;
	Button ok;

	Student student;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_je_cherche);
		// Show the Up button in the action bar.
		// /getActionBar().setDisplayHomeAsUpEnabled(true);

		nom = (EditText) findViewById(R.id.nom);
		adresse = (EditText) findViewById(R.id.adresse);
		phoneNumber = (EditText) findViewById(R.id.phoneNumber);

		ok = (Button) findViewById(R.id.ok);
		ok.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_je_cherche, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		//OK button is pressed
		case R.id.ok:
			Log.i("Je cherche", "OK");
			
			//get instance of TextFieldChecker class and initialize it with textfields
			EditText[] fields = { nom, adresse, phoneNumber };
			TextFieldChecker check = TextFieldChecker.getInstance(fields);

			//If any of the text fields is empty, show error message
			if (check.isAnyFieldNull() == true) {
				Toast toast = Toast.makeText(getApplicationContext(),
						"Tous les domaines sont obligatoires",
						Toast.LENGTH_LONG);
				toast.show();
			
			//Otherwise save the data
			} else {
				
				//Create student DTO
				student = new Student(phoneNumber.getText().toString(), nom
						.getText().toString(), adresse.getText().toString(),
						null, null, null);
				
				//show toast
				Toast toast = Toast.makeText(getApplicationContext(),
						"Bonne chance",
						Toast.LENGTH_LONG);
				toast.show();
			
				//close this activity
				finish();
			}
			break;
		}
	}
}

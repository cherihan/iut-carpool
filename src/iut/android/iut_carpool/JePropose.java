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

public class JePropose extends Activity implements OnClickListener {

	EditText nom, adresse, phoneNumber, licencePlate, brand, model, color,
			availableSits;
	Button ok;

	Student student;
	Car car;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_je_propose);
		// Show the Up button in the action bar.
		// getActionBar().setDisplayHomeAsUpEnabled(true);

		nom = (EditText) findViewById(R.id.nom);
		adresse = (EditText) findViewById(R.id.adresse);
		phoneNumber = (EditText) findViewById(R.id.phoneNumber);
		licencePlate = (EditText) findViewById(R.id.licencePlate);
		brand = (EditText) findViewById(R.id.brand);
		model = (EditText) findViewById(R.id.model);
		color = (EditText) findViewById(R.id.color);
		availableSits = (EditText) findViewById(R.id.availableSits);

		ok = (Button) findViewById(R.id.ok);
		ok.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_je_propose, menu);
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

			//get instance of TextFieldChecker class and initialize it with textfields
			EditText[] fields = { nom, adresse, phoneNumber, licencePlate,
					brand, model, color, availableSits };
			TextFieldChecker check = TextFieldChecker.getInstance(fields);

			//If any of the text fields is empty, show error message
			if (check.isAnyFieldNull() == true) {
				Toast toast = Toast.makeText(getApplicationContext(),
						R.string.tousObligatoires,
						Toast.LENGTH_LONG);
				toast.show();
			
			//Otherwise save the data
			} else {
				try {
					
					//parse number of seats to valid integer
					int seats = Integer.parseInt(availableSits.getText()
							.toString());

					//Create student DTO
					student = new Student(phoneNumber.getText().toString(), nom
							.getText().toString(),
							adresse.getText().toString(), null, licencePlate
									.getText().toString(), null);

					//Create car DTO
					car = new Car(licencePlate.getText().toString(), brand
							.getText().toString(), model.getText().toString(),
							color.getText().toString(), seats, 0);
					
					//show toast
					Toast toast = Toast.makeText(getApplicationContext(),
							"Bon voyage",
							Toast.LENGTH_LONG);
					toast.show();
					
					//close this activity
					finish();
					
				//if number of seats is not a valid integer, show error message
				} catch (NumberFormatException e) {
					Log.e("Je Propose", e.getMessage());

					Toast toast = Toast.makeText(getApplicationContext(),
							e.getMessage()	,
							Toast.LENGTH_LONG);
					toast.show();
				}
			}
			break;
		}
	}
}

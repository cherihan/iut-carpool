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
		case R.id.ok:

			try{
				int seats = Integer.parseInt(availableSits.getText().toString());
	
				student = new Student(phoneNumber.getText().toString(), nom
						.getText().toString(), adresse.getText().toString(), null,
						licencePlate.getText().toString(), null);
				
				car = new Car(licencePlate.getText().toString(), brand.getText()
						.toString(), model.getText().toString(), color.getText()
						.toString(), seats, 0);
			}catch(NumberFormatException e){
				Log.e("Je Propose", e.getMessage());
				
				Toast toast = Toast.makeText(getApplicationContext(), "Entrez places disponibles", Toast.LENGTH_LONG);
		        toast.show();
			}
			
			
			
			break;
		}

	}

}

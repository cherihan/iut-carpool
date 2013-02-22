package iut.android.iut_carpool;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CarPool extends Activity implements OnClickListener{

	
	Button jeCherche, jePropose;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch);
    
        jeCherche = (Button) findViewById(R.id.jeCherche); 
        jeCherche.setOnClickListener(this);
        
        jePropose = (Button) findViewById(R.id.jePropose); 
        jePropose.setOnClickListener(this);
        
        
        
    
    
    
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_car_pool, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		
		case R.id.jeCherche:
			Log.i("Car Pool", "Je cherche");
			
			Intent jeChe = new Intent(this, JeCherche.class);
	        startActivity(jeChe);
			break;
			
		case R.id.jePropose:
			Log.i("Car Pool", "Je propose");
			
			Intent jePro = new Intent(this, JePropose.class);
	        startActivity(jePro); 
	    	break;
		
		}
		
	}

    
}

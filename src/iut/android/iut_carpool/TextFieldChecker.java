package iut.android.iut_carpool;

import android.widget.EditText;


//This class is for quick validating of textfields
public class TextFieldChecker {
	
	private static EditText[] fields;
	private TextFieldChecker(){}
	
	private static TextFieldChecker instance = new TextFieldChecker();
	
	public static TextFieldChecker getInstance(EditText[] fields){
		TextFieldChecker.fields = fields;
		return instance;
	}
	
	//returns true, if any of the fields is empty. Otherwise returns false.
	public boolean isAnyFieldNull(){
		for(EditText t:fields){
			if (t.getText().toString().equals("")){
				return true;
			}
		}
		return false;
	}
	
	
	
	

	
}

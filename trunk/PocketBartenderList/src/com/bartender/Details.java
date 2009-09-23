package com.bartender;

import com.bartender.dao.DetailDAO;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Details extends Activity {

	private DatabaseAdapter myDatabaseAdapter;
	private long selectedRow;
	private TextView tvDrinkName;
	private TextView tvDrinktype;
	private TextView tvGlass;
	private DetailDAO drinkdetail;
	
	public Details() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.details);
		myDatabaseAdapter = DatabaseAdapter.getInstance(this);
		initComponents();
	}
	
	private void initComponents() {
    	
		selectedRow = getIntent().getLongExtra(
				PocketBartenderList.INTENT_EXTRA_SELECTED_ROW, 0);
		tvDrinkName = (TextView) findViewById(R.id.tvDrinkName);
		tvDrinktype = (TextView) findViewById(R.id.tvDrinkType);
		tvGlass = (TextView) findViewById(R.id.tvGlassType);

		drinkdetail = new DetailDAO();
		drinkdetail.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
		Log.v(getClass().getSimpleName(), "selectedRow=" + selectedRow);
		drinkdetail.setId((int) selectedRow);
		if (selectedRow > 0) {
			drinkdetail.load(this);
		}
		Log.v(getClass().getSimpleName(), "account.getId()=" + drinkdetail.getId());
		if (drinkdetail.getId() > 0) {
			tvDrinkName.setText(drinkdetail.getDrinkName());
			tvDrinktype.setText(drinkdetail.getDrinkType());
			tvGlass.setText(drinkdetail.getGlass());
			
		} 
		
	}
	

}

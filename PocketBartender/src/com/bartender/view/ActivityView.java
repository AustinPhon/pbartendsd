package com.bartender.view;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.bartender.R;
import com.bartender.dao.DatabaseAdapter;
import com.bartender.dao.DetailDAO;
import com.bartender.domain.DetailsDomain;

public class ActivityView extends Activity {
	
	protected DatabaseAdapter myDatabaseAdapter;
	protected long selectedRow;
	protected TextView tvDrinkName;
	protected TextView tvDrinktype;
	protected TextView tvGlass;
	protected TextView tvIng1;
	protected TextView tvIng2;
	protected TextView tvIng3;
	protected TextView tvFullIng;
	protected TextView tvInstructions;
	protected TextView tvInstructions2;
	protected Spinner spinnerDrinkNames;
	protected DetailsDomain drinkdetail;
	protected ImageButton favImageButton;
	protected DetailDAO drinkdao;
	private static final int MENU_NEW_GAME=0;
	
	/**
	 * sets values to domain object
	 */
	protected void setViewItems(){
		
		tvDrinktype.setText(drinkdetail.getDrinkType());
		tvGlass.setText(drinkdetail.getGlass());
		tvIng1.setText(drinkdetail.getIng1());
		tvIng2.setText(drinkdetail.getIng2());
		tvIng3.setText(drinkdetail.getIng3());
		tvFullIng.setText(drinkdetail.getIngredients());
		tvInstructions.setText(drinkdetail.getInstructions());
		tvInstructions2.setText(drinkdetail.getInstructions2());
	}
	
	protected void findAndSetView()
	{
		tvDrinktype = (TextView) findViewById(R.id.tvDrinkType);
		tvGlass = (TextView) findViewById(R.id.tvGlassType);
		tvIng1 = (TextView) findViewById(R.id.tvIng1);
		tvIng2 = (TextView) findViewById(R.id.tvIng2);
		tvIng3 = (TextView) findViewById(R.id.tvIng3);
		tvFullIng = (TextView) findViewById(R.id.tvFullIng);
		tvInstructions = (TextView) findViewById(R.id.tvInstructions);
		tvInstructions2  = (TextView) findViewById(R.id.tvInstructions2);
		favImageButton = (ImageButton)findViewById(R.id.imgFav);
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    menu.add(0, MENU_NEW_GAME, 0, "Save as favorite");
	    return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case MENU_NEW_GAME:
	    	drinkdao.setFavoritesYes(drinkdetail.getId());
	        return true;
	    }
	    return false;
	}



}

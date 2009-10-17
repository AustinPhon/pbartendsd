/**
 * 
 */
package com.bartender.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

import com.bartender.R;
import com.bartender.dao.DrinkListDAO;
import com.bartender.dao.IngredientsDAO;
import com.bartender.domain.ScreenType;


/**
 * @author Darren
 * GETS A SET LIST OF CATEGORIES
 */
public class IngredientsListView extends ListViews {

	protected IngredientsDAO dataDAO = new IngredientsDAO();
	protected final String TYPE_LIQUOR = "Liquor";
	protected final String TYPE_MIXERS = "Mixers";
	protected final String TYPE_GARNISH = "Garnish";
	protected ScreenType ingtype = ScreenType.getInstance();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentListActivity(this);
        intent = new Intent(this, DrinkListView.class);
        ScreenType.getInstance().setScreenType(ScreenType.SCREEN_TYPE_ING);
    }
    
   protected void initComponents() {
    	dataDAO.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
    	Cursor recordscCursor = dataDAO.retrieveAllIngredients(ingtype.getType());
    	startManagingCursor(recordscCursor);
    	String[] from = new String[] { DrinkListDAO.COL_NAME };
		int[] to = new int[] { R.id.tfName};
    	SimpleCursorAdapter records = new SimpleCursorAdapter(this,
				R.layout.item_row, recordscCursor, from, to);
    	
		setListAdapter(records);
	}
   

}

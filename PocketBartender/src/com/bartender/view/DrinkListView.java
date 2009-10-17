package com.bartender.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleCursorAdapter;

import com.bartender.R;
import com.bartender.dao.DrinkListDAO;
import com.bartender.domain.DetailsDomain;
import com.bartender.domain.ScreenType;

public class DrinkListView extends ListViews {
	
	protected DrinkListDAO dataDAO = new DrinkListDAO();
	long selectedRow=-1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCurrentListActivity(this);
        intent = new Intent(this, DetailsView.class);
        
        selectedRow = getIntent().getLongExtra(ListViews.INTENT_EXTRA_SELECTED_ROW, 0);
        
        initComponents();
    }
    
    /**
     * init screen list
     */
    private void initComponents() {
    	drinkdetail = new DetailsDomain();
    	drinkdetail.setId((int) selectedRow);
		
    	dataDAO.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
    	Cursor recordscCursor;
    	if(ScreenType.getInstance().getScreenType() == ScreenType.SCREEN_TYPE_CAT)
    		recordscCursor = dataDAO.retrieveAllDrinkByTypes(selectedRow);
    	else if(ScreenType.getInstance().getScreenType() == ScreenType.SCREEN_TYPE_ING)
    		recordscCursor = dataDAO.retrieveAllDrinksByIng(ScreenType.getInstance().getType(),selectedRow+"");
    	else
    		recordscCursor = dataDAO.retrieveAllDrinks();
    	
    	
    	Log.v(getClass().getSimpleName(), "count=" + recordscCursor.getCount());
    	startManagingCursor(recordscCursor);
    	String[] from = new String[] { DrinkListDAO.COL_NAME };
		int[] to = new int[] { R.id.tfName};
		
    	SimpleCursorAdapter records = new SimpleCursorAdapter(this,
				R.layout.item_row, recordscCursor, from, to);
    	
		setListAdapter(records);	
	}
}


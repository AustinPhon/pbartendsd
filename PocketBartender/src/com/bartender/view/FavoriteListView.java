package com.bartender.view;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.bartender.R;
import com.bartender.dao.CategoryDAO;
import com.bartender.dao.DatabaseAdapter;
import com.bartender.dao.DrinkListDAO;

public class FavoriteListView extends ListViews {
	
	CategoryDAO cat = new CategoryDAO();
	private Intent intent;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_drinks); 
        myDatabaseAdapter = DatabaseAdapter.getInstance(this);
        intent = new Intent(this, DetailsView.class);
        initComponents();
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Log.v(getClass().getSimpleName(), "id=" + id);
		intent.putExtra(INTENT_EXTRA_SELECTED_ROW, id);
		startActivityForResult(intent, INTENT_NEXT_SCREEN);
	}
    
    /**
     * init screen list
     */
    private void initComponents() {
    	DrinkListDAO drink = new DrinkListDAO();
    	drink.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
    	Cursor recordscCursor = drink.retrieveAllDrinks();
    	startManagingCursor(recordscCursor);
    	String[] from = new String[] { DrinkListDAO.COL_ROW_DRINK_NAME };
		int[] to = new int[] { R.id.tvDrinkName};
    	SimpleCursorAdapter records = new SimpleCursorAdapter(this,
				R.layout.item_row, recordscCursor, from, to);
    	
		setListAdapter(records);
	}
}

package com.bartender.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.bartender.R;
import com.bartender.dao.DataDAO;
import com.bartender.dao.DatabaseAdapter;
import com.bartender.dao.DetailDAO;
import com.bartender.domain.ScreenType;

public class HomeScreenView extends Activity implements OnClickListener,OnTouchListener,Runnable {

	/** Called when the activity is first created. */
	private Intent intent;
	private Button btnAll, btnCat, btnIng, btnFav; 
	private DatabaseAdapter myDatabaseAdapter;
	private ProgressDialog pd;
	private DataDAO dataDAO = new DetailDAO();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        initComponents();
        
        if(DatabaseAdapter.sqliteDb== null)
        {
        	pd = ProgressDialog.show(this, null,"Building the database, please be patient.");
        	Thread thread = new Thread(this);
        	thread.start();
        }
        
    }
    
	private void initComponents() {
		
		btnAll = (Button) findViewById(R.id.btnAll);
		btnAll.setOnClickListener(this);
		btnAll.setOnTouchListener(this);
		
		btnCat = (Button) findViewById(R.id.btnCat);
		btnCat.setOnClickListener(this);
		btnCat.setOnTouchListener(this);

		btnFav = (Button) findViewById(R.id.btnFav);
		btnFav.setOnClickListener(this);
		btnFav.setOnTouchListener(this);

		btnIng = (Button) findViewById(R.id.btnIng); 
		btnIng.setOnClickListener(this);
		btnIng.setOnTouchListener(this);

	}
    
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, "Create New").setIcon(android.R.drawable.ic_menu_add);
	    return true;
	}

	/* Handles item selections */
	public boolean onOptionsItemSelected(MenuItem item) {

			ScreenType.getInstance().screenType= -1;
	    	Intent intent = new Intent(this, CreateUpdateView.class);
			startActivity(intent);
			
	    	return true;

	}
	
	  public boolean onTouch(View v, MotionEvent event) {
		    
		  int left=60;
		  	if(v instanceof Button )
		  	{
		  		if(v == btnFav)
		  			left=25;
		  		if(event.getAction() == MotionEvent.ACTION_DOWN)
		  		{
		  			v.setBackgroundResource(R.drawable.button_over);
		  			v.setPadding(left, 0, 0, 10);
		  		}
		  		
		  		else if(event.getAction()== MotionEvent.ACTION_UP)
		  		{
		  			v.setBackgroundResource(R.drawable.button_bg);
		  			v.setPadding(left, 0, 0, 10);
		  		}
		  	}
		  
		    return false;
	    }
    
	  
    public void onClick(View view) {
    	
			if(view==btnAll)
			{
				pd = ProgressDialog.show(this, null,"Building drink list.");
				ScreenType.getInstance().screenType= -1;
				intent = new Intent(this, DrinkListView.class);
				startActivity(intent);
			}
			else if(view==btnCat)
			{	
				intent = new Intent(this, CategoryListView.class);
				startActivity(intent);
			}
			else if(view == btnFav)
			{
				ScreenType.getInstance().screenType= -1;
				intent = new Intent(this, FavoriteListView.class);
				startActivity(intent);
			}
			else if(view == btnIng)
			{
				intent = new Intent(this, IngredientsHomeView.class);
				startActivity(intent);
			}
			
	}

    
    
    private Handler handler = new Handler() {
    
            @Override
            public void handleMessage(Message msg) {
            	pd.dismiss();
            }
        };
        
	/* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    public void run() {
    	 myDatabaseAdapter = DatabaseAdapter.getInstance(this);
         dataDAO.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
         handler.sendEmptyMessage(0);
	    
    }
}
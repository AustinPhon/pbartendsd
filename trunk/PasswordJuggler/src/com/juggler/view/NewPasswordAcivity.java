/**
 * Date: Jan 4, 2010
 * Project: PasswordJuggler
 * User: dmason
 * This software is subject to license of
 * IBBL-TGen
 * http://www.gouvernement.lu/
 * http://www.tgen.org 
 */
package com.juggler.view;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juggler.dao.PasswordDAO;
import com.juggler.dao.PasswordDbHelper;
import com.juggler.utils.Constants;

/**
 * @author dmason
 * @version $Revision$ $Date$ $Author$ $Id$
 */
public class NewPasswordAcivity extends FooterActivity implements OnClickListener {
	
	private Button bNext,bPrev;
	private PasswordDAO passDao;
	private PasswordDbHelper myDatabaseAdapter;
	private EditText pwdconfirm,pwd;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    setContentView(R.layout.settings_frame);
	    
	    View details = (LinearLayout)findViewById(R.id.vDetails);
	    details.setVisibility(View.GONE);
	    View details3 = (LinearLayout)findViewById(R.id.vDetails3);
	    details3.setVisibility(View.GONE);
	    
	    //set up database for use
		passDao = new PasswordDAO();
		myDatabaseAdapter = PasswordDbHelper.getInstance(this);
		passDao.setSQLiteDatabase(myDatabaseAdapter.getDatabase());
	    
	    super.onCreate(savedInstanceState);
	}
	
	/* (non-Javadoc)
	 * @see com.juggler.view.FooterActivity#onResume()
	 */
	@Override
	protected void onResume() {
		initialize();
	    super.onResume();
	}
	
	private void initialize()
	{
		TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
		tvTitle.setText(getString(R.string.newpassword));
		
		bPrev = (Button)findViewById(R.id.butPrev);
		bPrev.setOnClickListener(this);
		
		bNext = (Button)findViewById(R.id.butNext);
	    bNext.setText(getString(R.string.save));
	    bNext.setOnClickListener(this);
	    
	    pwd = (EditText)findViewById(R.id.etNewPassword1);
	    pwdconfirm = (EditText)findViewById(R.id.etNewPassword2);
	    
		//set screen type
		Constants.SCREEN_TYPE=Constants.SETTINGS;
	}

	
	/* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View v) {
    	
    	if(v == bNext)
 	    {
    		//save password
    		passDao.updateRootLogin(pwd.getText().toString(),pwdconfirm.getText().toString());
 	    	finish();
 	    	
 	    }
    	else if(v == bPrev){
    		finish();
    	}
	    
    }
}
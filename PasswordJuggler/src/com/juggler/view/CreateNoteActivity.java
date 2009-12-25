/**
 * Date: Dec 25, 2009
 * Project: PasswordJuggler
 * User: dmason
 * This software is subject to license of
 * IBBL-TGen
 * http://www.gouvernement.lu/
 * http://www.tgen.org 
 */
package com.juggler.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author dmason
 * @version $Revision$ $Date$ $Author$ $Id$
 */
public class CreateNoteActivity extends Activity implements OnClickListener {

	private Button butNext,butPrev;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_note_frame);
        
        initialize();
    }
	
	private void initialize(){
		
		//set title
		TextView tvTitle = (TextView)findViewById(R.id.tvTitle);
		tvTitle.setText("");
		
		butNext= (Button)findViewById(R.id.butNext);
		butNext.setOnClickListener(this);
		
		butPrev= (Button)findViewById(R.id.butPrev);
		butPrev.setOnClickListener(this);
	}

	/* (non-Javadoc)
     * @see android.view.View.OnClickListener#onClick(android.view.View)
     */
    public void onClick(View v) {
    	
    	if(v==butNext)
    	{
    		//TODO:persist data
    		
    		Intent intent = new Intent(this,HomeView.class);
    		startActivity(intent);
    	}
    	else
    	{
    		finish();
    	}
    	
	    
    }
}


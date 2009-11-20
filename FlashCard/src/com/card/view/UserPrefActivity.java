/**
 * Date: Nov 20, 2009
 * Project: FlashCard
 * User: dmason
 * This software is subject to license of
 * IBBL-TGen
 * http://www.gouvernement.lu/
 * http://www.tgen.org 
 */
package com.card.view;

import com.card.R;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

/**
 * @author dmason
 * @version $Revision$ $Date$ $Author$ $Id$
 */
public class UserPrefActivity extends Activity {
	
	  @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.userpref);
	        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    }
}

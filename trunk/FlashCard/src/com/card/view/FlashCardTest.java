/**
 * Date: Nov 16, 2009
 * Project: FlashCard
 * User: dmason
 * This software is subject to license of
 * IBBL-TGen
 * http://www.gouvernement.lu/
 * http://www.tgen.org 
 */
package com.card.view;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.card.R;

/**
 * @author dmason
 * @version $Revision$ $Date$ $Author$ $Id$
 */
public class FlashCardTest extends Activity {
	
	private GestureDetector mGestureDetector;
	private Context context;
	
	@SuppressWarnings("unchecked")
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.card_test_view);  
		//force to be landscape
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		mGestureDetector = new GestureDetector(this, new LearnGestureListener());
		context = getBaseContext();
		
        // Set the listener for Button_Next, a quick and dirty way to create a listener
		Button buttonNext = (Button) findViewById(R.id.Button_next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Get the ViewFlipper from the layout
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);

                // Set an animation from res/anim: 
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(),  R.anim.slide_left));
                vf.showNext();
            }
        });
        
        // Set the listener for Button_Previous, a quick and dirty way to create a listener
        Button buttonPrevious = (Button) findViewById(R.id.Button_previous);
        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Get the ViewFlipper from the layout
                ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);
                // Set an animation from res/anim: 
                vf.setAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.slide_right));
                vf.showPrevious();
        }

        });        

    }
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
	    if (mGestureDetector.onTouchEvent(event))
	        return true;
	    else
	        return false;
	}
	
	protected class LearnGestureListener extends GestureDetector.SimpleOnGestureListener{
	    @Override
	    public boolean onSingleTapUp(MotionEvent ev) {
	        Log.d("onSingleTapUp",ev.toString());
	        return true;
	    }
	    @Override
	    public void onShowPress(MotionEvent ev) {
	        Log.d("onShowPress",ev.toString());
	    }
	    @Override
	    public void onLongPress(MotionEvent ev) {
	        Log.d("onLongPress",ev.toString());
	    }
	    @Override
	    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
	        Log.d("onScroll",e1.toString());
	        return true;
	    }
	    @Override
	    public boolean onDown(MotionEvent ev) {
	        Log.d("onDownd",ev.toString());
	        return true;
	    }
	    @Override
	    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
	        Log.d("d",e1.toString());
	        Log.d("e2",e2.toString());
	        // Get the ViewFlipper from the layout
            ViewFlipper vf = (ViewFlipper) findViewById(R.id.details);

            // Set an animation from res/anim: 
            vf.setAnimation(AnimationUtils.loadAnimation(context,  R.anim.slide_left));
            vf.showNext();
	        return true;
	    }

	}
	

	
}

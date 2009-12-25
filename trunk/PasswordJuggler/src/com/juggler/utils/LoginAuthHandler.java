package com.juggler.utils;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

import com.juggler.view.LoginView;

public class LoginAuthHandler extends CountDownTimer {
	private static Context context; 
	
	public LoginAuthHandler(long millisInFuture, long countDownInterval) {
		super(millisInFuture, countDownInterval);
		// TODO Auto-generated constructor stub
	}

	private static LoginAuthHandler handler=null;
	private boolean didLogin=false;
	
	private static long timeout=5000; // 5 minutes

	public boolean isDidLogin() {
		return didLogin;
	}

	public void setDidLogin(boolean didLogin) {
		this.didLogin = didLogin;
	}

	public static LoginAuthHandler getInstance(Context c) {

		if(handler == null)
		{
			handler = new LoginAuthHandler(timeout,1000);
			context = c;
		}
		return handler;
	}

	public static long getTimeout() {
		return timeout;
	}

	public static void setTimeout(long timeout) {
		LoginAuthHandler.timeout = timeout;
	}

	@Override
	public void onFinish() {
		Intent intent = new Intent(context,LoginView.class);
    	context.startActivity(intent);
		
	}

	@Override
	public void onTick(long millisUntilFinished) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

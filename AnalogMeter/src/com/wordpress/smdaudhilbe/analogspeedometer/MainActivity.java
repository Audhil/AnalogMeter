package com.wordpress.smdaudhilbe.analogspeedometer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.wordpress.smdaudhilbe.analogspeedometer.view.AnalogMeter;

//	http://www.cumulations.com/blogs/5/Understanding-Sweep-angle-in-drawArc-method-of-android

public class MainActivity extends Activity {

	private AnalogMeter analogMeter;
	Handler myHandler = new Handler();
	protected int percent = 0;
	
	Runnable myRunnable = new Runnable() {
		
		@Override
		public void run() {
			
			if(percent <= 100){
				analogMeter.setSweepAngle(percent++);
				analogMeter.invalidate();			
				myHandler.postDelayed(this, 1);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		analogMeter = (AnalogMeter)findViewById(R.id.analogSpeedoMeter);		
		myHandler.postDelayed(myRunnable, 1);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		myHandler.removeCallbacks(myRunnable);
	}
}
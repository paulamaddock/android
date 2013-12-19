package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class LifeCycleTest extends Activity{
	StringBuilder builder = new StringBuilder();
	TextView textView;
	
	private void log(String text) {
		Log.d ("LifeCycleTest", text);
		builder.append(text);
		builder.append('\n');
		textView.setText(builder.toString());
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		textView = new TextView(this);
		textView.setText(builder.toString());
		setContentView(textView);
		log("Created");
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		log("resumed");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		log("paused");
		if (isFinishing()) {
			log("finishing");
		}
	}
}

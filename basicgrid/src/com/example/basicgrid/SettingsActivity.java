package com.example.basicgrid;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class SettingsActivity extends ActionBarActivity {

	ToggleButton toggle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);		
		toggle = (ToggleButton) findViewById(R.id.toggle_sound);
		
		toggle.setChecked(false);		
		
		toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			
		    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		    	
		        if (isChecked) {
		            // The toggle is enabledToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
		        	toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
		        	    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		        	        if (isChecked) {
		        	            // The toggle is enabled
		    					toggle.setBackgroundResource(R.drawable.custom_button_peach_pressed);
		    					startService(new Intent(getBaseContext(), SoundService.class));
		    					
		    					Log.e("on was called","on click");

		        	        } else {
		        	            // The toggle is disabled
		    					toggle.setBackgroundResource(R.drawable.custom_button_peach);
		    					stopService(new Intent(getBaseContext(), SoundService.class));
		        	        	Log.e("off was called","on click");
		        	        }
		        	    }
		        	});
		        } else {
		            // The toggle is disabled
		        }
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

package com.example.basicgrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GameModeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
		setContentView(R.layout.activity_game_mode);
		Button s = (Button) findViewById(R.id.singlePlayer);
		Button m = (Button) findViewById(R.id.multiPlayer);
		Button mt = (Button) findViewById(R.id.multiPlayerTimed);
		s.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),MainActivity.class);
				i.putExtra("mode", 0);
				startActivity(i);
			}});
		
		m.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),MainActivity.class);
				i.putExtra("mode", 2);
				startActivity(i);
			}});
		mt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),MainActivity.class);
				i.putExtra("mode", 1);
				startActivity(i);
			}});
	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game_mode, menu);
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

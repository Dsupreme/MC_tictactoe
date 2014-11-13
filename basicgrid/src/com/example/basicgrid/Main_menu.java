package com.example.basicgrid;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Main_menu extends ActionBarActivity {

	@SuppressLint("InlinedApi") protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();
		setContentView(R.layout.activity_main_menu);
		
		Button newgame = (Button)findViewById(R.id.newgame); 
		newgame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            	Intent gotomain = new Intent(Main_menu.this, MainActivity.class);
            	startActivity(gotomain);
            }
        });
		
		Button exitgame = (Button)findViewById(R.id.exit);
		exitgame.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				new AlertDialog.Builder(Main_menu.this)
			    	.setTitle("Ultimate TicTacToe")
			    	.setMessage("Are you sure you want to exit ?")
			    	.setIcon(R.drawable.logo)
			    	.setCancelable(false)
			    	.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			    		public void onClick(DialogInterface dialog, int id) {
		                    Main_menu.this.finish();
			    		}
			    	})
			    	.setNegativeButton("No", null)
			    	.show();
				}
			});
		}	
}

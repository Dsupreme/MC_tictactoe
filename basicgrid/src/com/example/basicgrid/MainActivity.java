package com.example.basicgrid;

import java.util.HashMap;
import java.util.Random;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

	public final static String EXTRA_MESSAGE = "com.example.basicgrid.MESSAGE";
	private boolean noughtsTurn = false; // Who's turn is it? false=X true=O
	private boolean clicked = false;
	// private char board[][] = new char[3][3];
	private char big_box[][] = new char[3][3];
	private char array_boxes[][][] = new char[9][3][3];
	// private String boxstate[][] = new String [3][3];
	private String[] boxstate = new String[10];
	private int mode;
	TextView player;
	TextView player_not;
	HashMap<String, Integer> map_boxes = new HashMap<String, Integer>();
	HashMap<Integer, String> inverse_map_boxes = new HashMap<Integer, String>();
	static float actualVolume;
	static float maxVolume;
	static float volume;
	boolean loaded = false;
	static MediaPlayer clock;
	MediaPlayer ring;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		clock = MediaPlayer.create(this, R.raw.clock);
		ring = MediaPlayer.create(this, R.raw.pop);
		clock.setLooping(true);
		ring.setLooping(true);
		Intent i = getIntent();
		mode = i.getIntExtra("mode", 0);
		System.out.println("MODE " +mode);
		map_boxes.put("11", 1);
		map_boxes.put("12", 2);
		map_boxes.put("13", 3);
		map_boxes.put("21", 4);
		map_boxes.put("22", 5);
		map_boxes.put("23", 6);
		map_boxes.put("31", 7);
		map_boxes.put("32", 8);
		map_boxes.put("33", 9);
		inverse_map_boxes.put(1, "11");
		inverse_map_boxes.put(2, "12");
		inverse_map_boxes.put(3, "13");
		inverse_map_boxes.put(4, "21");
		inverse_map_boxes.put(5, "22");
		inverse_map_boxes.put(6, "23");
		inverse_map_boxes.put(7, "31");
		inverse_map_boxes.put(8, "32");
		inverse_map_boxes.put(9, "33");

		setboxstate();
		setupOnClickListeners();
		resetButtons();
		playerBarAnimate();

	}
	private void setboxstate() {
		for (int i = 0; i < 10; ++i) {
			/*
			 * for(int j=0;j<3;j++) { boxstate[i][j]=""; }
			 */
			boxstate[i] = "";
		}
	}
	public void newGame(View view) {
		noughtsTurn = false;
		// board = new char[9][9];
		big_box = new char[3][3];
		array_boxes = new char[9][3][3];
		resetButtons();
	}  
    private void resetButtons() {
		TableLayout T1 = (TableLayout) findViewById(R.id.box_11);
		for (int y = 0; y < T1.getChildCount(); y++) {
			if (T1.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T1.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		
		TableLayout T2 = (TableLayout) findViewById(R.id.box_12);
		for (int y = 0; y < T2.getChildCount(); y++) {
			if (T2.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T2.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T3 = (TableLayout) findViewById(R.id.box_13);
		for (int y = 0; y < T3.getChildCount(); y++) {
			if (T3.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T3.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T4 = (TableLayout) findViewById(R.id.box_21);
		for (int y = 0; y < T4.getChildCount(); y++) {
			if (T4.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T4.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T5 = (TableLayout) findViewById(R.id.box_22);
		for (int y = 0; y < T5.getChildCount(); y++) {
			if (T5.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T5.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T6 = (TableLayout) findViewById(R.id.box_23);
		for (int y = 0; y < T6.getChildCount(); y++) {
			if (T6.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T6.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T7 = (TableLayout) findViewById(R.id.box_31);
		for (int y = 0; y < T7.getChildCount(); y++) {
			if (T7.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T7.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T8 = (TableLayout) findViewById(R.id.box_32);
		for (int y = 0; y < T8.getChildCount(); y++) {
			if (T8.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T8.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
		TableLayout T9 = (TableLayout) findViewById(R.id.box_33);
		for (int y = 0; y < T9.getChildCount(); y++) {
			if (T9.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T9.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setText("");
						B.setEnabled(true);
					}
				}
			}
		}
		
	}       
    private boolean checkWin(char[][] box) {
		char winner = '\0';
		if (checkWinner(box, 3, 'X')) {
			winner = 'X';
		} else if (checkWinner(box, 3, 'O')) {
			winner = 'O';
		}

		if (winner == '\0') {
			return false; // nobody won
		} else {
			// display winner
			
			TextView T = (TextView) findViewById(R.id.winner);
			T.setText(winner + " wins");
			return true;
		}
	}
    private boolean checkWinner(char[][] board, int size, char player) {
		// check each column
		for (int x = 0; x < size; x++) {
			int total = 0;
			for (int y = 0; y < size; y++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total >= size) {
				return true; // they win
			}
		}

		// check each row
		for (int y = 0; y < size; y++) {
			int total = 0;
			for (int x = 0; x < size; x++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total >= size) {
				return true; // they win
			}
		}
		// forward diag
		int total = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (x == y && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total >= size) {
			return true; // they win
		}
		// backward diag
		total = 0;
		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				if (x + y == size - 1 && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total >= size) {
			return true; // they win
		}
		return false; // nobody won
	}
	/**
	 * Disables all the buttons in the grid.
	 */
	private void disableButtons() {
		TableLayout T = (TableLayout) findViewById(R.id.box_11);
		for (int y = 0; y < T.getChildCount(); y++) {
			if (T.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
	}	
	private void partialdisableButtons(String enablebox) {
		TableLayout T1 = (TableLayout) findViewById(R.id.box_11);
		for (int y = 0; y < T1.getChildCount(); y++) {
			if (T1.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T1.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T2 = (TableLayout) findViewById(R.id.box_12);
		for (int y = 0; y < T2.getChildCount(); y++) {
			if (T2.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T2.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T3 = (TableLayout) findViewById(R.id.box_13);
		for (int y = 0; y < T3.getChildCount(); y++) {
			if (T3.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T3.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T4 = (TableLayout) findViewById(R.id.box_21);
		for (int y = 0; y < T4.getChildCount(); y++) {
			if (T4.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T4.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T5 = (TableLayout) findViewById(R.id.box_22);
		for (int y = 0; y < T5.getChildCount(); y++) {
			if (T5.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T5.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T6 = (TableLayout) findViewById(R.id.box_23);
		for (int y = 0; y < T6.getChildCount(); y++) {
			if (T6.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T6.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T7 = (TableLayout) findViewById(R.id.box_31);
		for (int y = 0; y < T7.getChildCount(); y++) {
			if (T7.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T7.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T8 = (TableLayout) findViewById(R.id.box_32);
		for (int y = 0; y < T8.getChildCount(); y++) {
			if (T8.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T8.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		TableLayout T9 = (TableLayout) findViewById(R.id.box_33);
		for (int y = 0; y < T9.getChildCount(); y++) {
			if (T9.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T9.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						B.setEnabled(false);
					}
				}
			}
		}
		
		//findViewById()
		int p = getResources().getIdentifier("box_"+enablebox, "id", getPackageName());
		Log.d("adsf", p+"");
		TableLayout T = (TableLayout) findViewById(p);
		
		for (int y = 0; y < T.getChildCount(); y++) {
			if (T.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
	}	
	private void enableButtons() {
		TableLayout T1 = (TableLayout) findViewById(R.id.box_11);
		for (int y = 0; y < T1.getChildCount(); y++) {
			if (T1.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T1.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T2 = (TableLayout) findViewById(R.id.box_12);
		for (int y = 0; y < T2.getChildCount(); y++) {
			if (T2.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T2.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))	
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T3 = (TableLayout) findViewById(R.id.box_13);
		for (int y = 0; y < T3.getChildCount(); y++) {
			if (T3.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T3.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))	
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T4 = (TableLayout) findViewById(R.id.box_21);
		for (int y = 0; y < T4.getChildCount(); y++) {
			if (T4.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T4.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T5 = (TableLayout) findViewById(R.id.box_22);
		for (int y = 0; y < T5.getChildCount(); y++) {
			if (T5.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T5.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T6 = (TableLayout) findViewById(R.id.box_23);
		for (int y = 0; y < T6.getChildCount(); y++) {
			if (T6.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T6.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T7 = (TableLayout) findViewById(R.id.box_31);
		for (int y = 0; y < T7.getChildCount(); y++) {
			if (T7.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T7.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T8 = (TableLayout) findViewById(R.id.box_32);
		for (int y = 0; y < T8.getChildCount(); y++) {
			if (T8.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T8.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
		TableLayout T9 = (TableLayout) findViewById(R.id.box_33);
		for (int y = 0; y < T9.getChildCount(); y++) {
			if (T9.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T9.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					if (R.getChildAt(x) instanceof Button) {
						Button B = (Button) R.getChildAt(x);
						if(B.getText().equals(""))
							B.setEnabled(true);
					}
				}
			}
		}
	}	
	private void setupOnClickListeners() {
		TableLayout T1 = (TableLayout) findViewById(R.id.box_11);
		for (int y = 0; y < T1.getChildCount(); y++) {
			if (T1.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T1.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
				//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(0,x,y));
				}
			}
		}
		TableLayout T2 = (TableLayout) findViewById(R.id.box_12);
		for (int y = 0; y < T2.getChildCount(); y++) {
			if (T2.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T2.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(1,x,y));
				}
			}
		}
		TableLayout T3 = (TableLayout) findViewById(R.id.box_13);
		for (int y = 0; y < T3.getChildCount(); y++) {
			if (T3.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T3.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(2,x,y));
				}
			}
		}
		TableLayout T4 = (TableLayout) findViewById(R.id.box_21);
		for (int y = 0; y < T4.getChildCount(); y++) {
			if (T4.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T4.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(3,x,y));
				}
			}
		}
		TableLayout T5 = (TableLayout) findViewById(R.id.box_22);
		for (int y = 0; y < T5.getChildCount(); y++) {
			if (T5.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T5.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(4,x,y));
				}
			}
		}
		TableLayout T6 = (TableLayout) findViewById(R.id.box_23);
		for (int y = 0; y < T6.getChildCount(); y++) {
			if (T6.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T6.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(5,x,y));
				}
			}
		}
		TableLayout T7 = (TableLayout) findViewById(R.id.box_31);
		for (int y = 0; y < T7.getChildCount(); y++) {
			if (T7.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T7.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(6,x,y));
				}
			}
		}
		TableLayout T8 = (TableLayout) findViewById(R.id.box_32);
		for (int y = 0; y < T8.getChildCount(); y++) {
			if (T8.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T8.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(7,x,y));
				}
			}
		}
		TableLayout T9 = (TableLayout) findViewById(R.id.box_33);
		for (int y = 0; y < T9.getChildCount(); y++) {
			if (T9.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T9.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					//V.setOnClickListener(new PlayOnClick(x, y));
					V.setOnClickListener(new PlayOnClick(8,x,y));
				}
			}
		}
	
	}
    private class PlayOnClick implements View.OnClickListener {

		private int x = 0;
		private int y = 0;
		private int z = 0;

		public PlayOnClick(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public PlayOnClick(int x, int y,int z) {
			this.x = x;
			this.y = y;
			this.z=z;
		}
		@Override
		public void onClick(View view) {
			if (view instanceof Button) {
				Button B = (Button) view;
				clock.pause();
				ring.pause();
				clicked = true;
				// clock.start();
				array_boxes[x][y][z] = noughtsTurn ? 'O' : 'X';
				if (B.getText().equals("")) {
					if (noughtsTurn == true) {

						B.setTextColor(Color.parseColor("#ffce54"));
						B.setText("O");
						B.setBackgroundResource(R.drawable.game_button_pressed);
					} else {
						B.setTextColor(Color.parseColor("#e74c3c"));
						B.setText("X");
						B.setBackgroundResource(R.drawable.game_button_pressed);
					}
					// B.setText(noughtsTurn ? "O" : "X");
					B.setEnabled(false);
					noughtsTurn = !noughtsTurn;
					playerBarAnimate();
								
				String temp= B.getResources().getResourceEntryName(B.getId());
				String gotoboxid = ""+ temp.charAt(3)+temp.charAt(5);
				TextView T = (TextView) findViewById(R.id.winner);
				T.setText(gotoboxid);
				
				// check if anyone has won that box.
				
					if (checkWin(array_boxes[Integer.parseInt(""+temp.charAt(1))-1])&& boxstate[Integer.parseInt(""+temp.charAt(1))]=="") 
					{
				    String big_box_id=inverse_map_boxes.get(Integer.parseInt(""+temp.charAt(1)));
				    big_box[Integer.parseInt(""+big_box_id.charAt(0))-1][Integer.parseInt(""+big_box_id.charAt(1))-1]=B.getText().charAt(0);
					
					boxstate[Integer.parseInt(""+temp.charAt(1))]=B.getText().toString();
					Log.d("boxstate", boxstate[Integer.parseInt(""+temp.charAt(1))]);
					
					String t="";
					for(int i=0;i<10;++i)
					{
						t=t + " "+boxstate[i];
					}
					TextView T1 = (TextView) findViewById(R.id.tv1);
					T1.setText(t);
				    if(checkWin(big_box))
				    {
				       T1.setText(B.getText()+"   WONNNNNNN");
				       Intent intent = new Intent(getApplicationContext(), DisplayMessageActivity.class);
				       String message = B.getText()+ " WON";
				       intent.putExtra(EXTRA_MESSAGE, message);
				       startActivity(intent);
				    }
				}
				
				//Check if destination is already won or not.
				if(boxstate[map_boxes.get(gotoboxid)]=="")
				{
					partialdisableButtons(gotoboxid);
				}
				
				
				else{
					enableButtons();
				}
				//Go to relavant box.
				}
			}
		}
	}
    public void playerBarAnimate() {
		// TODO Auto-generated method stub
		DisplayMetrics display = getBaseContext().getResources().getDisplayMetrics();
		final int width = display.widthPixels;
		int height = display.heightPixels;
		if (!noughtsTurn) {
			player = (TextView) findViewById(R.id.player1);
			player_not = (TextView) findViewById(R.id.player2);
		} else {
			player = (TextView) findViewById(R.id.player2);
			player_not = (TextView) findViewById(R.id.player1);
		}
		if (mode == 0 || mode == 1) {
			Animation slide_in = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.abc_fade_in);
			Animation slide_out = AnimationUtils.loadAnimation(
					getApplicationContext(), R.anim.abc_fade_in);
			slide_in.setDuration(1000);
			slide_out.setDuration(1000);
			player.startAnimation(slide_in);
			player_not.startAnimation(slide_out);
			player.setWidth((int) (width * 0.7));
			player_not.setWidth((int) (width * 0.25));
		} else if(mode==2) {
			System.out.println("MODE " +mode);
			expand(player, width * 0.7, player.getWidth(), 100);
			collapse(player_not, width * 0.25, player_not.getWidth(), 100);
				final Handler handler = new Handler();
				handler.postDelayed(new Runnable() {
					@Override
					public void run() {
						clock.start();
						expand(player_not, width * 0.7, player_not.getWidth(),
								12000);
						collapse(player, width * 0.25, player.getWidth(), 12000);
						handler.postDelayed(new Runnable() {
							@Override
							public void run() {
								if (clicked) {
									clicked = false;
									return;
								} else {
									ring.start();
									Random r = new Random();
									int i = r.nextInt(3);
									int j = r.nextInt(3);
									String brc = new RoboPlayer1(array_boxes,big_box,noughtsTurn).getNextMove(i, j);
									int p = getResources().getIdentifier(brc, "id",
											getPackageName());
									final Button b = (Button) findViewById(p);
									b.performClick();
								}
							}
						}, 12000);
					}
					}
					, 4000);
			}
	}
    public static void expand(final View v, final double targetWidth,
		final double initialWidth, int dur) {
		// v.measure(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime,
					Transformation t) {
				v.getLayoutParams().width = interpolatedTime == 1 ? (int) targetWidth
						: (int) (initialWidth + ((targetWidth - initialWidth) * interpolatedTime));
				v.requestLayout();
			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration(dur);
		v.startAnimation(a);
	}
    public static void collapse(final View v, final double targetWidth,
		final double initialWidth, int dur) {
		Animation a = new Animation() {
			@Override
			protected void applyTransformation(float interpolatedTime,
					Transformation t) {
				v.getLayoutParams().width = interpolatedTime == 1 ? (int) targetWidth
						: (int) (initialWidth - ((initialWidth - targetWidth) * interpolatedTime));
				v.requestLayout();

			}

			@Override
			public boolean willChangeBounds() {
				return true;
			}
		};

		// 1dp/ms
		a.setDuration(dur);
		v.startAnimation(a);
    }
    
    
}

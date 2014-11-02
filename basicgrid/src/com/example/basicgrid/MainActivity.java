package com.example.basicgrid;


//import com.example.NaughtsAndCrosses.R;
//import com.example.NaughtsAndCrosses.MainActivity.PlayOnClick;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends BaseActivity{	

	
	private boolean noughtsTurn = false; // Who's turn is it? false=X true=O
	private char board[][] = new char[3][3];
	private boolean boxstate[][] = new boolean [3][3];
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setboxstate();
        setupOnClickListeners();
        resetButtons();
    }
    private void setboxstate()
    {
    	for(int i=0;i<3;++i)
    	{
    		for(int j=0;j<3;++j)
    		{
    			boxstate[i][j]=false;
    		}
    	}
    }
    public void newGame(View view) {
		noughtsTurn = false;
		board = new char[9][9];
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
    
    
    private boolean checkWin() {

		char winner = '\0';
		if (checkWinner(board, 3, 'X')) {
			winner = 'X';
		} else if (checkWinner(board, 3, 'O')) {
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
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T2 = (TableLayout) findViewById(R.id.box_12);
		for (int y = 0; y < T2.getChildCount(); y++) {
			if (T2.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T2.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T3 = (TableLayout) findViewById(R.id.box_13);
		for (int y = 0; y < T3.getChildCount(); y++) {
			if (T3.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T3.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T4 = (TableLayout) findViewById(R.id.box_21);
		for (int y = 0; y < T4.getChildCount(); y++) {
			if (T4.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T4.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T5 = (TableLayout) findViewById(R.id.box_22);
		for (int y = 0; y < T5.getChildCount(); y++) {
			if (T5.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T5.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T6 = (TableLayout) findViewById(R.id.box_23);
		for (int y = 0; y < T6.getChildCount(); y++) {
			if (T6.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T6.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T7 = (TableLayout) findViewById(R.id.box_31);
		for (int y = 0; y < T7.getChildCount(); y++) {
			if (T7.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T7.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T8 = (TableLayout) findViewById(R.id.box_32);
		for (int y = 0; y < T8.getChildCount(); y++) {
			if (T8.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T8.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
		TableLayout T9 = (TableLayout) findViewById(R.id.box_33);
		for (int y = 0; y < T9.getChildCount(); y++) {
			if (T9.getChildAt(y) instanceof TableRow) {
				TableRow R = (TableRow) T9.getChildAt(y);
				for (int x = 0; x < R.getChildCount(); x++) {
					View V = R.getChildAt(x); // In our case this will be each button on the grid
					V.setOnClickListener(new PlayOnClick(x, y));
				}
			}
		}
	
	}
	

    private class PlayOnClick implements View.OnClickListener {

		private int x = 0;
		private int y = 0;

		public PlayOnClick(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public void onClick(View view) {
			if (view instanceof Button) {
				Button B = (Button) view;
				board[x][y] = noughtsTurn ? 'O' : 'X';
				B.setText(noughtsTurn ? "O" : "X");
				B.setEnabled(false);
				noughtsTurn = !noughtsTurn;
				int butid=B.getId();
				//B.getid
				String temp= B.getResources().getResourceEntryName(B.getId());
				String gotoboxid = ""+ temp.charAt(3)+temp.charAt(5);
				//System.out.println(gotoboxid);
				TextView T = (TextView) findViewById(R.id.winner);
				T.setText(gotoboxid);
				partialdisableButtons(gotoboxid);
				// check if anyone has won
				if (checkWin()) {
					
					disableButtons();
				}
			}
		}
	}
    
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            mMenuDrawer.toggleMenu();
        default:
            return super.onOptionsItemSelected(item);
        }
    }
}

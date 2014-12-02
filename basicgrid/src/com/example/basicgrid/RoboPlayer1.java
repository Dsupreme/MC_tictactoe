package com.example.basicgrid;

import java.util.Random;


public class RoboPlayer1 {
	char[][][] board = new char[9][3][3];
	char[][] big_box = new char[3][3];
	boolean turnO;
	/**
	 * @param args
	 */

	char checkWin(char[][] box) {
		if (checkWinner(box, 3, 'X')) {
			return 'X';
			
		} else if (checkWinner(box, 3, 'O')) {
			 return 'O';
		}
		else {
			return '\0';
		}
	}

	boolean checkWinner(char[][] board, int size, char player) {
		// check each column
		for (int x = 0; x < 3; x++) {
			int total = 0;
			for (int y = 0; y < 3; y++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total == size) {
				return true; // they win
			}
		}

		// check each row
		for (int y = 0; y < 3; y++) {
			int total = 0;
			for (int x = 0; x < 3; x++) {
				if (board[x][y] == player) {
					total++;
				}
			}
			if (total == size) {
				return true; // they win
			}
		}

		// forward diag
		int total = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (x == y && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total == size) {
			return true; // they win
		}

		// backward diag
		total = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (x + y == 2 && board[x][y] == player) {
					total++;
				}
			}
		}
		if (total == size) {
			return true; // they win
		}

		return false; // nobody won
	}
	
	int[] getMoveToWin(char[][] board, int size, char player) {
		// check each column
		int total = 0, _x = -1, _y = -1;
		for (int x = 0; x < 3; x++) {
			total = 0;
			for (int y = 0; y < 3; y++) {
				if (board[x][y] == player) {
					total++;
				}
				else if(board[x][y]=='\0'){
					_x = x;
					_y = y;
				}
			}
			if (total == size && _x!=-1 && _y!=-1) {
				int[] arr = {_x, _y};
				return arr; // they win
			}
		}

		// check each row
		for (int y = 0; y < 3; y++) {
			total = 0;
			for (int x = 0; x < 3; x++) {
				if (board[x][y] == player) {
					total++;
				}
				else if(board[x][y]=='\0'){
					_x = x;
					_y = y;
				}
			}
			if (total == size && _x!=-1 && _y!=-1) {
				int[] arr = {_x, _y};
				return arr; // they win
			}
		}
		// forward diag
		total = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (x == y && board[x][y] == player) {
					total++;
				}
					else if(x==y && board[x][y]=='\0'){
						_x = x;
						_y = y;
					}
				}
				if (total == size && _x!=-1 && _y!=-1) {
					int[] arr = {_x, _y};
					return arr; // they win
				}
			}
		// backward diag
		total = 0;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (x + y == 2 && board[x][y] == player) {
					total++;
				}
				else if(x + y == 2 && board[x][y]=='\0'){
					_x = x;
					_y = y;
				}
			}
			if (total == size && _x!=-1 && _y!=-1) {
				int[] arr = {_x, _y};
				return arr; // they win
			}
		}
		int[] arr = {_x, _y};
		return arr;
	}


	void copyBoard(char[][][] temp, char[][] bb) {
					
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					board[i][j][k] = temp[i][k][j];
		for (int j = 0; j < 3; j++)
			for (int k = 0; k < 3; k++)
				big_box[j][k] = bb[j][k];
	}

	String playGame(int b, int x, int y) {
		//check won?
		
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				if(board[b][i][j]!='\0' || checkWinner(board[b],3,'O') || checkWinner(board[b],3,'X')) 
					continue;            
				 if (board[b][i][j] == '\0'){	
					if (turnO)
						board[b][i][j] = 'O';
					else
						board[b][i][j] = 'X';				
					
					//System.out.println((turnO? 'O': 'X') + " b:" + b +" i:" + i + " j:" + j);
					
					if(checkWinner(board[b],3, 'O')){
							System.out.println("COMP WIN" + "b"+(b+1)+"r"+(i+1)+"c"+(j+1));
							return "b"+(b+1)+"r"+(i+1)+"c"+(j+1);
					}
					else{
						board[b][i][j]='\0';
					}
											}
			}
		}
		Random r = new Random();
		int i = r.nextInt(3);
		int j = r.nextInt(3);
		System.out.println("Time for random move at "+ (b+1));
		boolean isWon = (checkWinner(board[b],3,'O')||checkWinner(board[b],3,'X'));
		
		
		if(!isWon){
			System.out.println("Board " + (b+1) +" not won");
			while(board[b][i][j]!='\0'){
				i = r.nextInt(3);
				j = r.nextInt(3);
			}
			return "b"+(b+1)+"r"+(i+1)+"c"+(j+1);
		}
		else{
			
			System.out.println("Board " +(b+1)+ "  won");
			//Go to random board
			for(int k=0; k<9; k++){
				if(k!=b){
					if(checkWinner(board[k],3,'O')==false && checkWinner(board[k],3,'X')==false){
						System.out.println(k+" khaali hai!!!!!!!!" );
						for(int l=0; l<3; l++){
							for(int m=0; m<3; m++)
								System.out.print(board[k][l][m] + "  ");
							System.out.println();
						}
					if(checkWinner(board[k],2,'O')==true){
						int[] arr1 = getMoveToWin(board[k],2,'O');
						i=arr1[0];
						j=arr1[1];
						System.out.println("YOUHOOA");
						return "b"+(k+1)+"r"+(i+1)+"c"+(j+1);
					}
					}
				}
			}
			int nb = b;
			while((board[nb][i][j]!='\0' || isWon))
			{
				int _i=i, _j=j;
				while(i==_i && j==_j){
					_i = r.nextInt(3);
					_j = r.nextInt(3);
				}
				i=_i;				
				j=_j;
			if (i == 0 && j == 0)
				nb=0;
				
			else if (i == 0 && j == 1)
				nb=1;
			
			else if (i == 0 && j == 2)
				nb=2;
				
			else if (i == 1 && j == 0)
				nb=3;
			
			else if (i == 1 && j == 1)
				nb=4;
				
			else if (i == 1 && j == 2)
				nb=5;
				
			else if (i == 2 && j == 0)
				nb=6;
				
			else if (i == 2 && j == 1)
				nb=7;
				
			else if (i == 2 && j == 2)
				nb=8;			
			System.out.println("NEW B " +(nb+1));
			if(checkWinner(board[nb],3,'O')==false && checkWinner(board[nb],3,'X')==false){
				isWon = false;
			}
			if(isWon==false && checkWinner(board[nb],2,'O')==true){
				for(int l=0; l<3; l++){
					for(int m=0; m<3; m++)
						System.out.print(board[nb][l][m] + "  ");
					System.out.println();
				}
				int[] arr = getMoveToWin(board[nb], 2, 'O');
				i = arr[0];
				j = arr[1];
				System.out.println("Next move to win cell : b"+ (nb+1)+" i"+(i+1)+" j"+(j+1));
			
			}
			
		}
		return "b"+(nb+1)+"r"+(i+1)+"c"+(j+1);
		}
	}

	
	private int makeRandomMovesOnBoard(char[][][] board2, int b, boolean turn) {
		// TODO Auto-generated method stub
		if(checkWin(big_box)!='\0')
			if(checkWin(big_box)=='O')
				return 1;
			else if(checkWin(big_box)=='X') return 0;
		for(int i=0; i<3; i++)
			for(int j=0; j<3; j++)
				if(board2[b][i][j]=='\0'){
					board2[b][i][j] = turn ? 'O': 'X';
		
					if(checkWinner(board[b],3,'O'))
						big_box[i][j]= 'O';
					else if(checkWinner(board[b],3,'X'))
						big_box[i][j]= 'X';
				
					if (i == 0 && j == 0)
						b=0;
						
					if (i == 0 && j == 1)
						b=1;
					
					if (i == 0 && j == 2)
						b=2;
						
					if (i == 1 && j == 0)
						b=3;
					
					if (i == 1 && j == 1)
						b=4;
						
					if (i == 1 && j == 2)
						b=5;
						
					if (i == 2 && j == 0)
						b=6;
						
					if (i == 2 && j == 1)
						b=7;
						
					if (i == 2 && j == 2)
						b=8;
					return makeRandomMovesOnBoard(board2, b, !turn);
				}
				if(checkWinner(board[b],3,'O'))
					return 1;
				else return 0;
	}

	String getNextMove(int x, int y) {
		// TODO Auto-generated method stub
		int b = 0;
		if (x == 0 && y == 0)
			b=0;
			
		if (x == 0 && y == 1)
			b=1;
		
		if (x == 0 && y == 2)
			b=2;
			
		if (x == 1 && y == 0)
			b=3;
		
		if (x == 1 && y == 1)
			b=4;
			
		if (x == 1 && y == 2)
			b=5;
			
		if (x == 2 && y == 0)
			b=6;
			
		if (x == 2 && y == 1)
			b=7;
			
		if (x == 2 && y == 2)
			b=8;
		return playGame(b,x,y);
	}

	public RoboPlayer1(char[][][] temp, char[][] bb, boolean turn) {
		

		board = new char[9][3][3];
		big_box = new char[3][3];
		turnO = turn;
		copyBoard(temp, bb);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

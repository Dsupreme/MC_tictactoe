package com.example.basicgrid;

import java.util.HashMap;



public class RoboPlayer {
	static char[][][] board = new char[9][3][3];
	static char[][] big_box = new char[3][3];
	static boolean turnO;
	static int countWins = 0;
	static int maxCount = 0;
	static int arr[] = new int[3];
	HashMap<String, Integer> map = new HashMap<String, Integer>();
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

	void copyBoard(char[][][] temp, char[][] bb) {
		countWins = 0;
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 3; j++)
				for (int k = 0; k < 3; k++)
					board[i][j][k] = temp[i][k][j];
		for (int j = 0; j < 3; j++)
			for (int k = 0; k < 3; k++)
				big_box[j][k] = bb[j][k];
		
	}

	int playGame(int b, int x, int y, boolean better_move) {		// TODO Auto-generated method stub
		if (checkWin(big_box)=='O' || checkWin(big_box)=='X') {
			if(checkWin(big_box)=='O' && !turnO)
				countWins++;
			return countWins;
		}
		if (checkWinner(board[b], 3, 'O') && better_move ) {
			big_box[x][y] = 'O';
			return -1;
		} else if (checkWinner(board[b], 3, 'X') && better_move) {
			big_box[x][y] = 'X';
			return -1;
		}
		// play
		/*
		for(int i=0; i<9; i++){
		for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 3; k++)
				System.out.print(board[b][j][k] + " ");
			System.out.print("\t");
		}
		System.out.println();
		}
		System.out.println("--------");
		System.out.flush();
		*/
		maxCount=0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (board[b][i][j] == '\0') {
					if (turnO)
						board[b][i][j] = 'O';
					else
						board[b][i][j] = 'X';
					if (checkWinner(board[b], 3, 'O') && better_move) {
						big_box[x][y] = 'O';
						return -1;
					} else if (checkWinner(board[b], 3, 'X') && better_move) {
						big_box[x][y] = 'X';
						return -1;
					}
					int count = new RoboPlayer(board, big_box, !turnO).getNextMove(i, j);
					if (count > maxCount) {
						maxCount = count;
						arr[0]=b;
						arr[1]=i;
						arr[2]=j;
						
					} else {
						big_box[x][y] = '\0';
						board[b][i][j] = '\0';
					}
				}
		countWins = countWins + maxCount;
		return countWins;
	}

	int getNextMove(int x, int y) {
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
		int cw=playGame(b, x, y,true);
		while(cw==-1){
			cw = getNextMove(x+1, y+1);
		}
		return cw;
	}

	public RoboPlayer(char[][][] temp, char[][] bb, boolean turn) {
		turnO = turn;
		copyBoard(temp, bb);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
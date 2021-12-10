package aoc2021;

public class Day4GiantSquid {

	public static void puzzleOne(String[] args) {
		int feedback = 0;
		

		int[] scoreBoard = new int[(args.length-1)/25];
		boolean[] isBingo = new boolean[(args.length-1)/25];
		int latestBoard = 0;

		//copies args into matrix
		int[][][] iBingoBoard = new int[(args.length-1)/25][5][5];
		boolean[][][] bBingoBoard = new boolean[(args.length-1)/25][5][5];
		for (int i = 0; i < args.length-1; i++) {
			iBingoBoard[i/25][(i/5)%5][i%5] = Integer.parseInt(args[i+1]);
			bBingoBoard[i/25][(i/5)%5][i%5] = false;
		}
		
		//copies number rolled to int array
		String[] tempNumber = args[0].split(",");
		int[] number = new int[tempNumber.length];
		for (int i = 0; i < tempNumber.length; i++) {
			number[i] = Integer.parseInt(tempNumber[i]);
		}
		
		//roll numbers and check the boards
		int ber = 0;
		while (latestBoard == 0) {
			int num = number[ber];
			for (int i = 0; i < args.length-1; i++) {
				if (!isBingo[i/25]) {
					if (iBingoBoard[i/25][(i/5)%5][i%5] == num) {
						bBingoBoard[i/25][(i/5)%5][i%5] = true;
						//checks for bingos
						/*if ((i/5)%5 == i%5 && 
								outsBoard[i/25][0][0] &&
									outsBoard[i/25][1][1] &&
									outsBoard[i/25][2][2] &&
									outsBoard[i/25][3][3] &&
									outsBoard[i/25][4][4] ) {
								for (int r = 0; r < 5; r++) {
									for (int c = 0; c < 5; c++) {
										if(!outsBoard[i/25][r][c]) {
											clearBoard[i/25] += bingoBoard[i/25][r][c];
										}
									}
								}
								clearBoard[i/25] *= num;
								winningBoard = i/25;
								isBingo[i/25] = true;
						}
						else if ((i/5)%5 == 4 - (i%5) && 
								outsBoard[i/25][0][4] && 
									outsBoard[i/25][1][3] && 
									outsBoard[i/25][2][2] && 
									outsBoard[i/25][3][1] && 
									outsBoard[i/25][4][0] ) {
								for (int r = 0; r < 5; r++) {
									for (int c = 0; c < 5; c++) {
										if(!outsBoard[i/25][r][c]) {
											clearBoard[i/25] += bingoBoard[i/25][r][c];
										}
									}
								}
								clearBoard[i/25] *= num;
								winningBoard = i/25;
								isBingo[i/25] = true;
						}
						else*/ if (bBingoBoard[i/25][(i/5)%5][0] &&
								bBingoBoard[i/25][(i/5)%5][1] &&
								bBingoBoard[i/25][(i/5)%5][2] &&
								bBingoBoard[i/25][(i/5)%5][3] &&
								bBingoBoard[i/25][(i/5)%5][4] ) {
							for (int r = 0; r < 5; r++) {
								for (int c = 0; c < 5; c++) {
									if(!bBingoBoard[i/25][r][c]) {
										scoreBoard[i/25] += iBingoBoard[i/25][r][c];
									}
								}
							}
							scoreBoard[i/25] *= num;
							latestBoard = i/25;
							isBingo[i/25] = true;
						}
						else if (bBingoBoard[i/25][0][i%5] && 
								bBingoBoard[i/25][1][i%5] && 
								bBingoBoard[i/25][2][i%5] && 
								bBingoBoard[i/25][3][i%5] && 
								bBingoBoard[i/25][4][i%5] ) {
							for (int r = 0; r < 5; r++) {
								for (int c = 0; c < 5; c++) {
									if(!bBingoBoard[i/25][r][c]) {
										scoreBoard[i/25] += iBingoBoard[i/25][r][c];
									}
								}
							}
							scoreBoard[i/25] *= num;
							latestBoard = i/25;
							isBingo[i/25] = true;
						}
					}
				}
			}
			ber++;
		}
		
		//find the winning clear board
		for (int i = 0; i < (args.length-1)/25; i++) {
			if (latestBoard < scoreBoard[i]) {
				latestBoard = i;
			}
		}
		
		feedback = scoreBoard[latestBoard];
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int feedback = 0;
		

		int[] scoreBoard = new int[(args.length-1)/25];
		boolean[] isBingo = new boolean[(args.length-1)/25];
		int latestBoard = 0;
		int numberOfBingo = 0;

		//copies args into matrix
		int[][][] iBingoBoard = new int[(args.length-1)/25][5][5];
		boolean[][][] bBingoBoard = new boolean[(args.length-1)/25][5][5];
		for (int i = 0; i < args.length-1; i++) {
			iBingoBoard[i/25][(i/5)%5][i%5] = Integer.parseInt(args[i+1]);
			bBingoBoard[i/25][(i/5)%5][i%5] = false;
		}
		
		//copies number rolled to int array
		String[] tempNumber = args[0].split(",");
		int[] number = new int[tempNumber.length];
		for (int i = 0; i < tempNumber.length; i++) {
			number[i] = Integer.parseInt(tempNumber[i]);
		}
		
		//roll numbers and check the boards
		int ber = 0;
		while (numberOfBingo != (args.length-1)/25) {
			int num = number[ber];
			for (int i = 0; i < args.length-1; i++) {
				if (!isBingo[i/25]) {
					if (iBingoBoard[i/25][(i/5)%5][i%5] == num) {
						bBingoBoard[i/25][(i/5)%5][i%5] = true;
						//checks for bingos
						if (bBingoBoard[i/25][(i/5)%5][0] &&
								bBingoBoard[i/25][(i/5)%5][1] &&
								bBingoBoard[i/25][(i/5)%5][2] &&
								bBingoBoard[i/25][(i/5)%5][3] &&
								bBingoBoard[i/25][(i/5)%5][4] ) {
							for (int r = 0; r < 5; r++) {
								for (int c = 0; c < 5; c++) {
									if(!bBingoBoard[i/25][r][c]) {
										scoreBoard[i/25] += iBingoBoard[i/25][r][c];
									}
								}
							}
							isBingo[i/25] = true;
							scoreBoard[i/25] *= num;
							latestBoard = i/25;
							numberOfBingo++;
						}
						else if (bBingoBoard[i/25][0][i%5] && 
								bBingoBoard[i/25][1][i%5] && 
								bBingoBoard[i/25][2][i%5] && 
								bBingoBoard[i/25][3][i%5] && 
								bBingoBoard[i/25][4][i%5] ) {
							for (int r = 0; r < 5; r++) {
								for (int c = 0; c < 5; c++) {
									if(!bBingoBoard[i/25][r][c]) {
										scoreBoard[i/25] += iBingoBoard[i/25][r][c];
									}
								}
							}
							isBingo[i/25] = true;
							scoreBoard[i/25] *= num;
							latestBoard = i/25;
							numberOfBingo++;
						}
					}
				} else {
					i = i + 25 - (i%25);
				}
			}
			ber++;
		}
		
		feedback = scoreBoard[latestBoard];
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		for(String s : args) {
			System.out.println(s);
		}
		System.out.print("First to bingo board: ");puzzleOne(args);
		System.out.print("Last to bingo board:  ");puzzleTwo(args);
	}

}

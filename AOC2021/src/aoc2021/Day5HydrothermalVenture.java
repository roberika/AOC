package aoc2021;

public class Day5HydrothermalVenture {

	public static void puzzleOne(String[] args) {
		int feedback = 0;
		
		//turns args to more easily congestible coor array
		int[] coor = new int[args.length/3*4];
		for (int i = 0; i < coor.length; i += 4) {
			String[] tempArgs = args[(int) (i*0.75)].split(",");
			coor[i] = Integer.parseInt(tempArgs[0]);
			coor[i+1] = Integer.parseInt(tempArgs[1]);
			tempArgs = args[(int) (i*0.75 + 2)].split(",");
			coor[i+2] = Integer.parseInt(tempArgs[0]);
			coor[i+3] = Integer.parseInt(tempArgs[1]);
		}
		
		//the map
		int row = 0;
		for (int i = 1; i < coor.length; i += 2) if (coor[i] > row) row = coor[i];
		int column = 0;
		for (int i = 0; i < coor.length; i += 2) if (coor[i] > column) column = coor[i];
		int[][] map = new int[row+1][column+1];
		
		for (int i = 0; i < coor.length; i += 4) {
			int start = 0, end = 0;
			if (coor[i] == coor[i+2]) {
				if (coor[i+1] < coor[i+3]) {
					start = coor[i+1];
					end = coor[i+3];
				} else {
					start = coor[i+3];
					end = coor[i+1];
				}
				for (int pos = start; pos <= end; pos++) {
					map[coor[i]][pos]++;
				}
			} else if (coor[i+1] == coor[i+3]) {
				if (coor[i] < coor[i+2]) {
					start = coor[i];
					end = coor[i+2];
				} else {
					start = coor[i+2];
					end = coor[i];
				}
				for (int pos = start; pos <= end; pos++) {
					map[pos][coor[i+1]]++;
				}
			}
		}
		
		for (int i = 0; i < column*row; i++) {
			if (map[i%column][i/column] > 1) {
				feedback++;
			}
		}
		
		System.out.println(feedback);
	}

	public static void puzzleTwo(String[] args) {
		int feedback = 0;
		
		//turns args to more easily congestible coor array
		int[] coor = new int[args.length/3*4];
		for (int i = 0; i < coor.length; i += 4) {
			String[] tempArgs = args[(int) (i*0.75)].split(",");
			coor[i] = Integer.parseInt(tempArgs[0]);
			coor[i+1] = Integer.parseInt(tempArgs[1]);
			tempArgs = args[(int) (i*0.75 + 2)].split(",");
			coor[i+2] = Integer.parseInt(tempArgs[0]);
			coor[i+3] = Integer.parseInt(tempArgs[1]);
		}
		
		//the map
		int row = 0;
		for (int i = 1; i < coor.length; i += 2) if (coor[i] > row) row = coor[i];
		int column = 0;
		for (int i = 0; i < coor.length; i += 2) if (coor[i] > column) column = coor[i];
		row++; column++;
		int[][] map = new int[row][column];
		
		for (int i = 0; i < coor.length; i += 4) {
			int start = 0, end = 0;
			if (coor[i] == coor[i+2]) {
				if (coor[i+1] < coor[i+3]) {
					start = coor[i+1];
					end = coor[i+3];
				} else {
					start = coor[i+3];
					end = coor[i+1];
				}
				for (int pos = start; pos <= end; pos++) {
					map[coor[i]][pos]++;
				}
			} else if (coor[i+1] == coor[i+3]) {
				if (coor[i] < coor[i+2]) {
					start = coor[i];
					end = coor[i+2];
				} else {
					start = coor[i+2];
					end = coor[i];
				}
				for (int pos = start; pos <= end; pos++) {
					map[pos][coor[i+1]]++;
				}
			} else if (coor[i] - coor[i+1] == coor[i+2] - coor[i+3]) {
				int length = 0;
				if (coor[i+1] < coor[i+3]) {
					length = coor[i+2] - coor[i];
					start = coor[i];
					end = coor[i+1];
				} else {
					length = coor[i] - coor[i+2];	
					start = coor[i+2];
					end = coor[i+3];
				}
				for (int pos = 0; pos <= length; pos++) {
					map[start+pos][pos+end]++;
				}
			} else if (coor[i] - coor[i+3] == coor[i+2] - coor[i+1]) {
				int length = 0;
				if (coor[i+3] < coor[i+1]) {
					length = coor[i+2] - coor[i];
					start = coor[i];
					end = coor[i+1];
				} else {
					length = coor[i] - coor[i+2];
					start = coor[i+2];
					end = coor[i+3];
				}
				for (int pos = 0; pos <= length; pos++) {
					map[start+pos][-pos+end]++;
				}
			}
		}
		
		for (int i = 0; i < column*row; i++) {
			if (map[i%column][i/column] > 1) {
				feedback++;
			}
		}
		
		System.out.println(feedback);
	}
	

	public static void main(String[] args) {
		System.out.print("Overlapping vents (estimate): ");puzzleOne(args);
		System.out.print("Overlapping vents (precise) : ");puzzleTwo(args);
	}

}

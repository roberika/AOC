package aoc2021;

import java.util.ArrayList;

public class Day9SmokeBasin {

	static Integer[][] map;
	static String[][] map2nd;
	static int LEFT = 0, UP = 1, RIGHT = 2, DOWN = 3, NONE = 4;
	
	
	public static void loadMap(String[] args) {
		map = new Integer[args.length][args[0].length()];
		map2nd = new String[args.length][args[0].length()];
		for (int r = 0; r < args.length; r++) {
			String[] s = args[r].split("");
			for (int c = 0; c < s.length; c++) {
				map[r][c] = Integer.parseInt(s[c]);
				map2nd[r][c] = ".";
			}
		}
	}
	
	public static boolean checkAdjacent(int posy, int posx, int i) {
		if (map2nd[posy][posx] == "x") {
			return false;
		}
		int left = posx - 1, right = posx + 1;
		int up = posy - 1, down = posy + 1;
		boolean result = true;
		if (i != 0 && left > -1 && map[posy][left] != null && map[posy][posx] >= map[posy][left]) {
			if (map2nd[posy][left] == ".") {
				result = false;
			}
		} 
		if (i != 1 && up > -1 && map[up][posx] != null && map[posy][posx] >= map[up][posx]) {
			if (map2nd[up][posx] == ".") {
				result = false;
			}
		} 
		if (i != 2 && right < map[posy].length && map[posy][right] != null && map[posy][posx] >= map[posy][right]) {
			if (map2nd[posy][right] == ".") {
				result = false;
			}
		} 
		if (i != 3 && down < map.length && map[down][posx] != null && map[posy][posx] >= map[down][posx]) {
			if (map2nd[down][posx] == ".") {
				result = false;
			}
		}
		if (result) {
			map2nd[posy][posx] = "x";
		}
		return result;
	}
	
	public static int getStrip(int posy, int posx, int i) {
		//direction (i is where you're going)
		int size = 0;
		int behind = (i+2)%4, toLeft = (i+3)%4, toRight = (i+1)%4;
		switch (i) {
		case 0 : posx--; break;
		case 1 : posy--; break;
		case 2 : posx++; break;
		case 3 : posy++; break;
		}
		if (posy < 0 || posy > map.length-1 || posx < 0 || posx > map[posy].length-1 || map2nd[posy][posx] == "x") {
			return 0;
		}
		if (checkAdjacent(posy, posx, behind)) {
			size = 1 + getStrip(posy, posx, i) + getStrip(posy, posx, toLeft) + getStrip(posy, posx, toRight);
		}
		return size;
	}
	
	public static int getBasinSize(int posy, int posx) {
		int size = 0;
		if (checkAdjacent(posy,posx,4)) {
			size = 1 + getStrip(posy,posx,0) + getStrip(posy,posx,1) + getStrip(posy,posx,2) + getStrip(posy,posx,3);
		}
		return size;
	}
	
	public static int getSize(int posy, int posx) {
		int size = 0;
		for (int a = 0; a < map2nd.length; a++) {
			for (int b = 0; b < map2nd[a].length; b++) {
				map2nd[a][b] = ".";
			}
		}
		if (adjacentIsLower(posy,posx,NONE)) {
			//center
			getSurroundingSize(posy,posx,LEFT);
			getSurroundingSize(posy,posx,RIGHT);
			getSurroundingSize(posy,posx,UP);
			getSurroundingSize(posy,posx,DOWN);
			int i = 0;
			for (String[] a : map2nd) {
				for (String b : map2nd[i]) {
					if (b == "x") {
						size++;
					}
				}
				i++;
			}
		}
		return size;
	}
	
	public static void getSurroundingSize(int posy, int posx, int forward) {
		int behind = (forward + 2) % 4;
		int leftward = (forward + 3) % 4;
		int rightward = (forward + 1) % 4;
		
		switch (forward) {
		case 0 : posx--; break;
		case 1 : posy--; break;
		case 2 : posx++; break;
		case 3 : posy++; break;
		}
		
		if (posy < 0 || posx < 0 || posy > map.length-1 || posx > map[posy].length-1) {
			
		} else if (fuckThisShit(posy,posx,behind)) {
			//other tiles
			getSurroundingSize(posy,posx,forward);
			getSurroundingSize(posy,posx,leftward);
			getSurroundingSize(posy,posx,rightward);
		}
	}
	
	public static boolean fuckThisShit(int posy, int posx, int excludeDirection) {
		if (map2nd[posy][posx] == "x" || map[posy][posx] == 9) {
			boolean result = false;
			return result;
		}
		boolean result = true;
		if (result) {
			map2nd[posy][posx] = "x";
		}
		
		return result;
	}
	
	public static boolean adjacentIsLower(int posy, int posx, int excludeDirection) {
		if (map2nd[posy][posx] == "x" || map[posy][posx] == 9) {
			boolean result = false;
			return result;
		}
		boolean result = true;
		//check left, up, right, down
		if ((excludeDirection != LEFT && posx-1 >= 0 && map[posy][posx-1] != 9 && (map[posy][posx] >= map[posy][posx-1] && map2nd[posy][posx-1] != "x"))){
			result = false;
		}
		if ((excludeDirection != UP && posy-1 >= 0 && map[posy-1][posx] != 9 && (map[posy][posx] >= map[posy-1][posx] && map2nd[posy-1][posx] != "x"))) {
			result = false;
		}
		if ((excludeDirection != RIGHT && posx+1 <= map[posy].length-1 && map[posy][posx+1] != 9 && (map[posy][posx] >= map[posy][posx+1] && map2nd[posy][posx+1] != "x"))) {
			result = false;
		}
		if ((excludeDirection != DOWN && posy+1 <= map.length-1 && map[posy+1][posx] != 9 && (map[posy][posx] >= map[posy+1][posx] && map2nd[posy+1][posx] != "x"))) {
			result = false;
		}
		
		if (result) {
			map2nd[posy][posx] = "x";
		}
		
		return result;
	}
	
	public static void puzzleOne(String[] args) {
		int feedback = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				if (adjacentIsLower(r,c,NONE)) {
					feedback += map[r][c] + 1;
					map2nd[r][c] = ".";
				}
			}
		}
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int feedback = 0;
		ArrayList<Integer> largestBasins = new ArrayList<Integer>();
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				int basinSize = getSize(r,c);
				System.out.printf("%4s",(basinSize==0)?".":(basinSize));
				largestBasins.add(basinSize);
			}
			System.out.println("\n");
		}
		largestBasins.sort(null);
		while (largestBasins.size() > 3) {
			largestBasins.remove(0);
		}
		feedback = largestBasins.get(0) * largestBasins.get(1) * largestBasins.get(2);
		System.out.println(largestBasins.get(0) + " " + largestBasins.get(1) + " " + largestBasins.get(2));
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		/*Integer[][] i = {{1,2,1,3},{2,1,2,4,8,2},{2,9,2,3,3,2},{13,9,2},{2,9,21,1,2,2}};
		map = i.clone();
		for (int r = 0; r < i.length; r++) {
			for (int c = 0; c < i[r].length; c++) {
				if (checkAdjacent(r,c)) {
					System.out.print("*");
				} else System.out.print("'");
			}
			System.out.println();
		}*/
		loadMap(args);
		System.out.print("Depth increment (with SNS): \n");puzzleOne(args);
		System.out.print("Depth increment (with ANS): \n");puzzleTwo(args);
		
	}

}

package aoc2021;

public class Day8SevenSegmentSearch {

	public static String[] SADifference(String[] sA1, String[] sA2){
		String[] tA = new String[sA1.length];
		for (int c = 0; c < tA.length; c++) {
			String[] s = new String[1];
			s[0] = sA1[c];
			if (!contain(sA2,s) && !(sA1[c] == null || sA1[c].isBlank() || sA1[c].isEmpty())) {
				tA[c] = sA1[c];
			}
		}
		String[] nntA = new String[sA1.length-sA2.length];
		int i = 0;
		for (int c = 0; c < tA.length; c++) {
			if (tA[c] != null) {
				nntA[i] = tA[c];
				i++;
			}
		}
		return tA;
	}
	
	public static boolean contain(String[] sA1, String[] sA2) {
		boolean[] contain = new boolean[sA2.length];
		boolean conclusion = true;
		for (int i = 0; i < sA2.length; i++) {
			contain[i] = true;
			boolean doesNotHaveIt = true;
			for (String t : sA1) {
				if (sA2[i] == null || sA2[i].equalsIgnoreCase(t)) {
					doesNotHaveIt = false;
					break;
				}
			}
			if (doesNotHaveIt) {
				contain[i] = false;
			}
		}
		for (boolean b : contain) {
			conclusion = conclusion && b;
		}
		return conclusion;
	}
	
	public static int check1478(String s) {
		int i = Integer.parseInt(s);
		if (i == 1 || i == 4 || i == 7 || i == 8) {
			return 1;	
		}
		return 0;
	}
	
	public static void puzzleOne(String[] args) {
		int feedback = 0;
		String[] result = new String[args.length/15];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
		}
		String[] temp = new String[7];
		
		for (int code = 0; code < args.length/15; code++) {
			String[][] digit = new String[10][7];
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];
				switch (s.length()){
				case 2 : digit[1] = s.split(""); break;
				case 4 : digit[4] = s.split(""); break;
				case 3 : digit[7] = s.split(""); break;
				case 7 : digit[8] = s.split(""); break;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];			
				
				switch (s.length()){
				case 5 : {
					if (contain(s.split(""),digit[1])) {
						digit[3] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[4],digit[1]))) {
						digit[5] = s.split(""); break;
					} else {
						digit[2] = s.split(""); break;
					}
				} 
				case 6 : {
					if (contain(s.split(""),digit[4])) {
						digit[9] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[8],digit[7]))) {
						digit[6] = s.split(""); break;
					} else {
						digit[0] = s.split(""); break;
					}
				}
				}
			}
			
			for (int i = 11; i < 15; i++) {
				String s = args[(code*15)+i];
				for (int c = 0; c < 10; c++) {
					if (digit[c] != null && contain(digit[c],s.split("")) && contain(s.split(""),digit[c])) {
						result[code] += c;
						feedback += check1478(c+"");
						break;
					}
				}
			}
		}
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int feedback = 0;
		String[] result = new String[args.length/15];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
		}
		String[] temp = new String[7];
		
		for (int code = 0; code < args.length/15; code++) {
			String[][] digit = new String[10][7];
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];
				switch (s.length()){
				case 2 : digit[1] = s.split(""); break;
				case 4 : digit[4] = s.split(""); break;
				case 3 : digit[7] = s.split(""); break;
				case 7 : digit[8] = s.split(""); break;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];			
				
				switch (s.length()){
				case 5 : {
					if (contain(s.split(""),digit[1])) {
						digit[3] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[4],digit[1]))) {
						digit[5] = s.split(""); break;
					} else {
						digit[2] = s.split(""); break;
					}
				} 
				case 6 : {
					if (contain(s.split(""),digit[4])) {
						digit[9] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[8],digit[7]))) {
						digit[6] = s.split(""); break;
					} else {
						digit[0] = s.split(""); break;
					}
				}
				}
			}
			
			for (int i = 11; i < 15; i++) {
				String s = args[(code*15)+i];
				for (int c = 0; c < 10; c++) {
					if (digit[c] != null && contain(digit[c],s.split("")) && contain(s.split(""),digit[c])) {
						result[code] += c;
						break;
					}
				}
			}
		}
		for (String s : result) {
			feedback += Integer.parseInt(s);
		}
		System.out.println(feedback);
	}
	
	public static void puzzleThree(String[] args) {
		int feedback = 0;
		String[] result = new String[args.length/15];
		for (int i = 0; i < result.length; i++) {
			result[i] = "";
		}
		String[] temp = new String[7];
		
		for (int code = 0; code < args.length/15; code++) {
			String[][] digit = new String[10][7];
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];
				switch (s.length()){
				case 2 : digit[1] = s.split(""); break;
				case 4 : digit[4] = s.split(""); break;
				case 3 : digit[7] = s.split(""); break;
				case 7 : digit[8] = s.split(""); break;
				}
			}
			
			for (int i = 0; i < 10; i++) {
				String s = args[(code*15)+i];			
				
				switch (s.length()){
				case 5 : {
					if (contain(s.split(""),digit[1])) {
						digit[3] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[4],digit[1]))) {
						digit[5] = s.split(""); break;
					} else {
						digit[2] = s.split(""); break;
					}
				} 
				case 6 : {
					if (contain(s.split(""),digit[4])) {
						digit[9] = s.split(""); break;
					} else if (contain(s.split(""),SADifference(digit[8],digit[7]))) {
						digit[6] = s.split(""); break;
					} else {
						digit[0] = s.split(""); break;
					}
				}
				}
			}
			
			for (int i = 11; i < 15; i++) {
				String s = args[(code*15)+i];
				for (int c = 0; c < 10; c++) {
					if (digit[c] != null && contain(digit[c],s.split("")) && contain(s.split(""),digit[c])) {
						result[code] += c;
						break;
					}
				}
			}
		}
		for (String s : result) {
			System.out.println(" "+s);
		}
	}
	
	public static void main(String[] args) {
		//puzzleThree(args);
		System.out.print("Number of 1s,4s,7s, and 8s: ");puzzleOne(args);
		System.out.print("Total of decrypted numbers: ");puzzleTwo(args);
	}

}

package aoc2021;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.UnaryOperator;

public class Day6Lanternfish {

	public static void puzzleOneAlt(String[] args) {
		int days = 80,feedback = 0;
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		String temp = args[0];
		args = temp.split(",");
		
		for (String s : args) {
			fishSchool.add(Integer.parseInt(s));
		}
		for (int d = 0; d < days; d++) {
			fishSchool.replaceAll(e -> e-1);
			for (int i = 0; i < fishSchool.size(); i++) {
				if (fishSchool.get(i) == -1) {
					fishSchool.add(6);
					fishSchool.add(8);
				}
			}
			fishSchool.removeIf(e -> e == -1);
			
		}
		feedback = fishSchool.size();
		feedback = fishSchool.size();
		System.out.println(feedback);
	}
	
	public static void puzzleOne(String[] args) {
		int days = 80,feedback = 0;
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		String temp = args[0];
		args = temp.split(",");
		
		for (String s : args) {
			fishSchool.add(Integer.parseInt(s));
		}
		for (int d = 0; d < days; d++) {
			int cap = fishSchool.size();
			for (int i = cap-1; i >= 0; i--) {
				if (fishSchool.get(i) == 0) {
					fishSchool.remove(i);
					fishSchool.add(6);
					fishSchool.add(8);
				} else {
					int t = fishSchool.get(i);
					fishSchool.remove(i);
					fishSchool.add(t-1);
				}
			}/*
			System.out.print("After "+(d+1)+": ");
			for (Integer i : fishSchool) {
				System.out.print(i+" ");
			}
			System.out.println();*/
		}
		feedback = fishSchool.size();
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int days = 256; long feedback = 0;
		
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		String temp = args[0];
		args = temp.split(",");
		
		int[] kidX = new int[6];
		
		for (String s : args) {
			fishSchool.add(Integer.parseInt(s));
		}
		
		for (Integer i : fishSchool) {
			if (i == 1) {
				kidX[0]++;
			} else if (i == 2) {
				kidX[1]++;
			} else if (i == 3) {
				kidX[2]++;
			} else if (i == 4) {
				kidX[3]++;
			} else if (i == 5) {
				kidX[4]++;
			} else if (i == 6) {
				kidX[5]++;
			}
		}
		
		ArrayList<Integer> kidsOfX = new ArrayList<Integer>();
		kidsOfX.add(1);
		
		for (int d = 0; d < days; d++) {
			kidsOfX.replaceAll(e -> e-1);
			for (int i = 0; i < kidsOfX.size(); i++) {
				if (kidsOfX.get(i) == -1) {
					kidsOfX.add(6);
					kidsOfX.add(8);
				}
			}
			kidsOfX.removeIf(e -> e == -1);
			
			if (days-1 == d) {
				kidX[0] *= kidsOfX.size();
			} else if (days-2 == d) {
				kidX[1] *= kidsOfX.size();
			} else if (days-3 == d) {
				kidX[2] *= kidsOfX.size();
			} else if (days-4 == d) {
				kidX[3] *= kidsOfX.size();
			} else if (days-5 == d) {
				kidX[4] *= kidsOfX.size();
			} else if (days-6 == d) {
				kidX[5] *= kidsOfX.size();
			}
		}
		
		feedback = kidX[0] + kidX[1] + kidX[2] + kidX[3] + kidX[4] + kidX[5];
		System.out.println(feedback);
	}
	
	public static void puzzleHelper(String[] args) {
		int days = 256; long feedback = 0;
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		fishSchool.add(1);
		
		for (int d = 0; d < days%180; d++) {
			fishSchool.replaceAll(e -> e-1);
			for (int i = 0; i < fishSchool.size(); i++) {
				if (fishSchool.get(i) == -1) {
					fishSchool.add(6);
					fishSchool.add(8);
				}
			}
			fishSchool.removeIf(e -> e == -1);
		}
		
		ArrayList<Integer> part1 = new ArrayList<Integer>();
		for (int i = 0; i < fishSchool.size()/2; i++) {
			part1.add(fishSchool.get(i));
		}
		ArrayList<Integer> part2 = new ArrayList<Integer>();
		for (int i = fishSchool.size()/2; i < fishSchool.size(); i++) {
			part2.add(fishSchool.get(i));
		}
		
		for (int d = 0; d < days-180; d++) {
			part1.replaceAll(e -> e-1);
			for (int i = 0; i < part1.size(); i++) {
				if (part1.get(i) == -1) {
					part1.add(6);
					part1.add(8);
				}
			}
			part1.removeIf(e -> e == -1);
		}
		
		for (int d = 0; d < days-180; d++) {
			part2.replaceAll(e -> e-1);
			for (int i = 0; i < part2.size(); i++) {
				if (part2.get(i) == -1) {
					part2.add(6);
					part2.add(8);
				}
			}
			part2.removeIf(e -> e == -1);
		}
		
		feedback = part1.size() + part2.size();
		System.out.println(feedback);
	}
	
	public static void mashPit(String[] args) {
		int days = 256; long feedback = 0;
		
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		String temp = args[0];
		args = temp.split(",");
		
		int[][] kidX = new int[2][6];
		
		for (String s : args) {
			fishSchool.add(Integer.parseInt(s));
		}
		
		for (Integer i : fishSchool) {
			if (i == 1) {
				kidX[0][0]++;
			} else if (i == 2) {
				kidX[0][1]++;
			} else if (i == 3) {
				kidX[0][2]++;
			} else if (i == 4) {
				kidX[0][3]++;
			} else if (i == 5) {
				kidX[0][4]++;
			} else if (i == 6) {
				kidX[0][5]++;
			}
		}
		
		ArrayList<Integer> kidsOfX = new ArrayList<Integer>();
		kidsOfX.add(1);
		
		for (int d = 0; d < 180; d++) {
			kidsOfX.replaceAll(e -> e-1);
			for (int i = 0; i < kidsOfX.size(); i++) {
				if (kidsOfX.get(i) == -1) {
					kidsOfX.add(6);
					kidsOfX.add(8);
				}
			}
			kidsOfX.removeIf(e -> e == -1);
		}
		System.out.println("CLEAR");
		
		ArrayList<Integer> part1 = new ArrayList<Integer>();
		for (int i = 0; i < kidsOfX.size()/2; i++) {
			part1.add(kidsOfX.get(i));
		}
		ArrayList<Integer> part2 = new ArrayList<Integer>();
		for (int i = kidsOfX.size()/2; i < kidsOfX.size(); i++) {
			part2.add(kidsOfX.get(i));
		}
		System.out.println("CLEAR");
		
		for (int d = 0; d < days-180; d++) {
			part1.replaceAll(e -> e-1);
			for (int i = 0; i < part1.size(); i++) {
				if (part1.get(i) == -1) {
					part1.add(6);
					part1.add(8);
				}
			}
			part1.removeIf(e -> e == -1);
			if (days-1-180 == d) {
				kidX[1][0] += part1.size();
			} else if (days-2-180 == d) {
				kidX[1][1] += part1.size();
			} else if (days-3-180 == d) {
				kidX[1][2] += part1.size();
			} else if (days-4-180 == d) {
				kidX[1][3] += part1.size();
			} else if (days-5-180 == d) {
				kidX[1][4] += part1.size();
			} else if (days-6-180 == d) {
				kidX[1][5] += part1.size();
			}
		}
		System.out.println("CLEAR");
		
		for (int d = 0; d < days-180; d++) {
			part2.replaceAll(e -> e-1);
			for (int i = 0; i < part2.size(); i++) {
				if (part2.get(i) == -1) {
					part2.add(6);
					part2.add(8);
				}
			}
			part2.removeIf(e -> e == -1);
			if (days-1-180 == d) {
				kidX[1][0] += part2.size();
			} else if (days-2-180 == d) {
				kidX[1][1] += part2.size();
			} else if (days-3-180 == d) {
				kidX[1][2] += part2.size();
			} else if (days-4-180 == d) {
				kidX[1][3] += part2.size();
			} else if (days-5-180 == d) {
				kidX[1][4] += part2.size();
			} else if (days-6-180 == d) {
				kidX[1][5] += part2.size();
			}
		}
		System.out.println("CLEAR");
		
		feedback = kidX[0][0]*kidX[1][0] + 
				kidX[0][1]*kidX[1][1] + 
				kidX[0][2]*kidX[1][2] + 
				kidX[0][3]*kidX[1][3] + 
				kidX[0][4]*kidX[1][4] + 
				kidX[0][5]*kidX[1][5];
		System.out.println(feedback);
		System.out.println("CLEAR");
	}
	
	public static long[] valueOfEachFishAfter180Days() {
		long[] resultsOfEx1 = new long[9];
		ArrayList<Integer> ex1 = new ArrayList<Integer>();
		ex1.add(1);
		for (int d = 0; d <= 180; d++) {
			ex1.replaceAll(e -> e-1);
			for (int i = 0; i < ex1.size(); i++) {
				if (ex1.get(i) == -1) {
					ex1.add(6);
					ex1.add(8);
				}
			}
			ex1.removeIf(e -> e == -1);
			
			if (d == 180) {
				resultsOfEx1[0] = ex1.size();
			} else if (d == 179) {
				resultsOfEx1[1] = ex1.size();
			} else if (d == 178) {
				resultsOfEx1[2] = ex1.size();
			} else if (d == 177) {
				resultsOfEx1[3] = ex1.size();
			} else if (d == 176) {
				resultsOfEx1[4] = ex1.size();
			} else if (d == 175) {
				resultsOfEx1[5] = ex1.size();
			} else if (d == 174) {
				resultsOfEx1[6] = ex1.size();
			} else if (d == 173) {
				resultsOfEx1[7] = ex1.size();
			} else if (d == 172) {
				resultsOfEx1[8] = ex1.size();
			}
		}
		return resultsOfEx1;
	}

	public static void mashPitExtra(String[] args) {
		//untested for above 359
		int days = 256; long feedback = 0;
		ArrayList<Integer> fishSchool = new ArrayList<Integer>();
		String temp = args[0];
		args = temp.split(",");
		
		long[] fish180DayValue = valueOfEachFishAfter180Days();
		long[] fishXXXDayValue = new long[9];
		for (int i = 0; i < fishXXXDayValue.length; i++) {
			fishXXXDayValue[i] = 1;
		}
		for (int d = 0; d < days/180; d++) {
			for (int i = 0; i < fishXXXDayValue.length; i++) {
				fishXXXDayValue[i] *= fish180DayValue[i];
			}
		}
		
		for (String s : args) {
			fishSchool.add(Integer.parseInt(s));
		}
		
		for (int d = 0; d < days%180; d++) {
			fishSchool.replaceAll(e -> e-1);
			for (int i = 0; i < fishSchool.size(); i++) {
				if (fishSchool.get(i) == -1) {
					fishSchool.add(6);
					fishSchool.add(8);
				}
			}
			fishSchool.removeIf(e -> e == -1);
		}
		
		for (Integer i : fishSchool) {
			feedback += fishXXXDayValue[i];
		}
		System.out.println(feedback);
	}
	
	
	public static void main(String[] args) {
		System.out.print("The fishes after  80 days: ");puzzleOneAlt(args);
		System.out.print("The fishes after 256 days: ");mashPitExtra(args);
	}

}

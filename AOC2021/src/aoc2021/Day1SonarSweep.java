package aoc2021;

public class Day1SonarSweep {

	public static void puzzleOne(String[] args) {
		int feedback = 0;
		for (int i = 0; i < args.length-1; i++) {
			if (Integer.parseInt(args[i]) < Integer.parseInt(args[i+1])) {
				feedback++;
			}
		}
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int feedback = 0;
		for (int i = 0; i < args.length-3; i++) {
			if (Integer.parseInt(args[i]) < Integer.parseInt(args[i+3])) {
				feedback++;
			}
		}
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		System.out.print("Depth increment (single): ");        puzzleOne(args);
		System.out.print("Depth increment (block of three): ");puzzleTwo(args);
	}

}


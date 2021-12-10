package aoc2021;

public class Day2Dive {

	public static void puzzleOne(String[] args) {
		int horizontal = 0, depth = 0, feedback = 0;
		for (int i = 0; i < args.length; i += 2) {
			int arg = Integer.parseInt(args[i+1]);
			switch (args[i]){
				case "forward" : horizontal += arg; break;
				case "up"      : depth      -= arg; break;
				case "down"    : depth      += arg; break;
			}
		}
		feedback = horizontal * depth;
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int horizontal = 0, depth = 0, aim = 0, feedback = 0;
		for (int i = 0; i < args.length; i += 2) {
			int arg = Integer.parseInt(args[i+1]);
			switch (args[i]){
				case "forward" : horizontal += arg;
				                 depth      += aim * arg; break;
				case "up"      : aim        -= arg; break;
				case "down"    : aim        += arg; break;
			}
		}
		feedback = horizontal * depth;
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		System.out.print("Depth increment (with SNS): ");puzzleOne(args);
		System.out.print("Depth increment (with ANS): ");puzzleTwo(args);
	}

}

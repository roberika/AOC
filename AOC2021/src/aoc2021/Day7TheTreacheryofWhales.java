package aoc2021;

import java.util.ArrayList;

public class Day7TheTreacheryofWhales {

	public static void puzzleOne(String[] arg) {
		int feedback = 0, med = 0;;
		
		String temp = arg[0];
		arg = temp.split(",");
		ArrayList<Integer> args = new ArrayList<Integer>();

		for (int i = 0; i < arg.length; i++) {
			args.add(Integer.parseInt(arg[i]));
		}
		
		args.sort(null);
		med = args.get(args.size()/2);
		
		for (Integer i : args) {
			feedback += Math.abs(med - i);
		}
		
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] arg) {
		int feedback = 0, mean = 0;;
		
		String temp = arg[0];
		arg = temp.split(",");
		ArrayList<Integer> args = new ArrayList<Integer>();

		for (int i = 0; i < arg.length; i++) {
			args.add(Integer.parseInt(arg[i]));
			mean += Integer.parseInt(arg[i]);
		}
		
		args.sort(null);
		mean /= args.size();
		
		for (Integer i : args) {
			double t = Math.abs(mean-i);
			feedback += ((t*t+t)/2);
		}
		//feedback = (double)((int)feedback);
		feedback = (feedback - (feedback % 1));
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		System.out.print("");puzzleOne(args);
		System.out.print("");puzzleTwo(args);
	}

}

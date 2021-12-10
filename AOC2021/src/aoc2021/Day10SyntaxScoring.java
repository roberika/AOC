package aoc2021;

import java.util.ArrayList;

public class Day10SyntaxScoring {

	public static void puzzleOne(String[] args) {
		long feedback = 0;
		for (String block : args) {
			long fixCost = 0;
			ArrayList<String> line = new ArrayList<String>();
			for (String s : block.split("")) {
				line.add(s);
			}
			for (int i = 1; i < line.size(); i++) {
				if (i == line.size()) {
					break;
				}
				if ((line.get(i-1).equals("(") && line.get(i).equals(")")) ||
						(line.get(i-1).equals("[") && line.get(i).equals("]")) ||
						(line.get(i-1).equals("{") && line.get(i).equals("}")) ||
						(line.get(i-1).equals("<") && line.get(i).equals(">"))) {
					line.remove(i); line.remove(i-1); i = (i-3 < 0)?0:(i-3);
				}
			}
			for (String s : line) {
				//System.out.print(s);
				if (s.equals(")")) {
					fixCost = 3; break;
				} else if (s.equals("]")) {
					fixCost = 57; break;
				} else if (s.equals("}")) {
					fixCost = 1197; break;
				} else if (s.equals(">")) {
					fixCost = 25137; break;
				}
			}
			feedback += fixCost;
			//System.out.println();
		}
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		long feedback = 0;
		ArrayList<Long> why = new ArrayList<Long>();
		for (String block : args) {
			long fixCost = 0;
			ArrayList<String> line = new ArrayList<String>();
			for (String s : block.split("")) {
				line.add(s);
			}
			for (int i = 1; i < line.size(); i++) {
				if ((line.get(i-1).equals("(") && line.get(i).equals(")")) ||
						(line.get(i-1).equals("[") && line.get(i).equals("]")) ||
						(line.get(i-1).equals("{") && line.get(i).equals("}")) ||
						(line.get(i-1).equals("<") && line.get(i).equals(">"))) {
					line.remove(i); line.remove(i-1); i = (i-3 < 0)?0:(i-3);
				}
			}
			for (int i = line.size(); i > 0; i--) {
				String s = line.get(i-1);
				//System.out.print(s);
				if (s.equals(")") || s.equals("]") || s.equals("}") || s.equals(">")) {
					fixCost = 0; break;
				}
				if (s.equals("(")) {
					fixCost = (fixCost * 5) + 1;
				} else if (s.equals("[")) {
					fixCost = (fixCost * 5) + 2;
				} else if (s.equals("{")) {
					fixCost = (fixCost * 5) + 3;
				} else if (s.equals("<")) {
					fixCost = (fixCost * 5) + 4;
				}
			}
			if (fixCost != 0) why.add(fixCost);
			//System.out.printf("%13s%n",fixCost+"X");
		}
		why.sort(null);
		feedback = why.get((why.size()-1)/2);
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		System.out.print("Litter contest: ");puzzleOne(args);
		System.out.print("Broken contest: ");puzzleTwo(args);
	}

}

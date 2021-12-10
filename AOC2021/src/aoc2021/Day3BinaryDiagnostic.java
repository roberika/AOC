package aoc2021;

public class Day3BinaryDiagnostic {
	
	public static void puzzleOne(String[] args) {
		int gammaRate = 0, epsilonRate = 0, feedback = 0;
		String sGR = "", sER = "";
		int bitLength = args[0].length();
		for (int endBit = 0; endBit < bitLength; endBit++) {
			int on = 0;
			for (int i = 0; i < args.length; i++) {
				if (args[i].charAt(endBit) == '1') {
					on++; 
				}
			}
			if (on < args.length - on) {
				sGR += "0"; sER += "1"; 
			} else {
				sGR += "1"; sER += "0";
			}
		}
		gammaRate = Integer.parseInt(sGR,2);
		epsilonRate = Integer.parseInt(sER,2);
		feedback = gammaRate * epsilonRate;
		System.out.println(feedback);
	}
	
	public static void puzzleTwo(String[] args) {
		int oxyGenRate = 0, coScrubRate = 0, feedback = 0;
		String sOR = "", sCR = "";
		int bitLength = args[0].length();
		for (int flip = 0; flip < 2; flip++) {
			String[] args2 = args.clone();
			int nullCount = 0;
			for (int endBit = 0; endBit < bitLength; endBit++) {
				int off = 0;
				for (int i = 0; i < args2.length; i++) {
					if (args2[i] != null && args2[i].charAt(endBit) == '1') {
						off++;
					}
				}
				if (!(nullCount >= args2.length-1)) {
					if (off < args2.length - off - nullCount) {
						off = flip;
					} else if (off >= args2.length - off - nullCount) {
						off = (flip + 1) % 2;
					}
					for (int i = 0; i < args2.length; i++) {
						if (args2[i] != null && args2[i].regionMatches(endBit, String.valueOf(off), 0, 1)) {
							args2[i] = null;
							nullCount++;
						}
					}
				}
			}
			for (int i = 0; i < args2.length; i++) {
				if (args2[i] != null && flip == 1) {
					sOR = args2[i];
				} else if (args2[i] != null && flip == 0) {
					sCR = args2[i];
				}
			}
		}
		oxyGenRate = Integer.parseInt(sOR,2);
		coScrubRate = Integer.parseInt(sCR,2);
		feedback = oxyGenRate * coScrubRate;
		System.out.println(feedback);
	}
	
	public static void main(String[] args) {
		System.out.print("Power consumption on general       : ");puzzleOne(args);
		System.out.print("Power consumption on air management: ");puzzleTwo(args);
	}

}

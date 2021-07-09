class Q5_GenericPatternDemo {
	// in: <'*', 3> out: "***"
	static String repeatChar(char ch, int n) {
		StringBuilder buff = new StringBuilder();
		for (int i=0; i < n; i++)
			buff.append(ch);
		return buff.toString();
	}

	// in: <'(', 2, ')', 2> out: "((  ))"
	static String genLine(char left, int nleft, char right, int nright, char space, int width) {
		if (nleft < 1 || nright < 1)
			return null;		// If it gets less than 0, it will end the loop in the main method by returning a null.
		int nblanks = width - (nleft + nright);
		if (nblanks < 0)
			return null;

		String left_str = repeatChar(left, nleft);
		String right_str = repeatChar(right, nright);
		String mid_blank = repeatChar(space, nblanks);

		return left_str + mid_blank + right_str; 
	}

	public static void main(String[] args) {
		String line;

		if (args.length < 4) {
			System.err.println("usage java Q5_GenericPatternDemo <left_char> <space_char> <right_char> <width>");
			return;
		}

		final char LEFT_PIXEL = args[0].charAt(0);
		final char SPACE_PIXEL = args[1].charAt(0);
		final char RIGHT_PIXEL = args[2].charAt(0);
		final int WIDTH = Integer.parseInt(args[3]);

		int i = 0;
		for (int round = 0; round < 2; round++) {
			// Even rounds: the upper-half pattern.
			// Odd rounds: the lower-half pattern.
			i = (round % 2 == 0) ? i + 1 : i - 1;		// ++ on even rounds, -- on odd rounds
			while ((line = genLine(LEFT_PIXEL, i, RIGHT_PIXEL, i, SPACE_PIXEL, WIDTH)) != null) {
				System.out.println(line);
				i = (round % 2 == 0) ? i + 1 : i - 1;   // ++ on even rounds, -- on odd rounds
			}
		}
	}
}

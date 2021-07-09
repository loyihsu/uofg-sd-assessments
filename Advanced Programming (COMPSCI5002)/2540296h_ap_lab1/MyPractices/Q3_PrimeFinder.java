import java.util.ArrayList;
import java.util.HashMap;

class Q3_PrimeFinder {
	static boolean isPrime(int max) {
		for (int x = 2; x <= (int)Math.sqrt(max); x++) {
			if (max % x == 0) {
				return false; // early termination
			}
		}
		return true; // not divisible by any number <= sqrt(n)
	}

	// It finds the prime numbers, print them on screen, and store them in an ArrayList, which can potentially be used later.
	static ArrayList<Integer> findPrimes(int min, int max) {
		ArrayList<Integer> prime = new ArrayList<>();

		for (int i = min; i <= max; i++) {
			if (i <= 1)
				continue;	// i is not prime number
			if (isPrime(i)) {
				prime.add(i);
				System.out.println(i);
			}
		}

		return prime;
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: java Q3_PrimeFinder <min-range> <max-range>");
			return;
		}

		int minRange = (args.length == 1) ? 2 : Integer.parseInt(args[0]);
		int maxRange = (args.length == 1) ? Integer.parseInt(args[0]) : Integer.parseInt(args[1]);
		ArrayList<Integer> list = findPrimes(minRange, maxRange);
	}
}

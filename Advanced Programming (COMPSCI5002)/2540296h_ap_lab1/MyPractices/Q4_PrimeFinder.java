import java.util.ArrayList;

class Q4_PrimeFinder {
	static boolean isPrime(int max) {
		for (int x = 2; x <= (int)Math.sqrt(max); x++) {
			if (max % x == 0) {
				return false; // early termination
			}
		}
		return true; // not divisible by any number <= sqrt(n)
	}

	// It finds the prime numbers and store them in an ArrayList to be used later.
	static ArrayList<Integer> findPrimes(int min, int max) {
		ArrayList<Integer> prime = new ArrayList<>();

		for (int i = min; i<= max; i++) {
			if (i <= 1)
				continue;	// i is not prime number
			if (isPrime(i)) {
				prime.add(i);
			}
		}

		return prime;
	}

	// Takes a list from the findPrimes method.
	// It is designed to take an Integer as the difference between the prime numbers.
	// It will not return anything and will print the result in the console.
	static void findPrimePairsByDiff(ArrayList<Integer> listOfPrimes, int difference) {
		if (listOfPrimes.size() < 2) { return; }	// List too small.
		for (int idx = 1; idx < listOfPrimes.size(); idx++) {
			for (int jdx = 1; jdx < difference; jdx++) {
				// Because every prime number is at least 1 number away from each other,
				// we go back n-1 to n-difference will catch all the possible ones.
				// (No need to go through everything from 0 to n-1)
				if (idx - jdx >= 0) {	// Protect the possibility to go out of bounds.
					if (listOfPrimes.get(idx) - listOfPrimes.get(idx-jdx) == difference) {
						System.out.println("(" + listOfPrimes.get(idx-jdx) + ", " + listOfPrimes.get(idx) + ")");
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: java Q4_PrimeFinder <min-range> <max-range>");
			return;
		}

		int minRange = (args.length == 1) ? 2 : Integer.parseInt(args[0]);
		int maxRange = (args.length == 1) ? Integer.parseInt(args[0]) : Integer.parseInt(args[1]);
		ArrayList<Integer> list = findPrimes(minRange, maxRange);

		System.out.println("Twin Primes: ");	// Difference is 2 by definition
		findPrimePairsByDiff(list, 2);
		System.out.println("Cousin Primes: ");	// Difference is 4 by definition
		findPrimePairsByDiff(list, 4);
		System.out.println("Sexy Primes: ");	// Difference is 6 by definition
		findPrimePairsByDiff(list, 6);
	}
}

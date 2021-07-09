import java.util.HashMap;
import java.util.HashSet;

class Q6_PrimeFinder {
	static boolean isPrime(int max) {
		for (int x = 2; x <= (int)Math.sqrt(max); x++) {
			if (max % x == 0) {
				return false; // early termination
			}
		}
		return true; // not divisible by any number <= sqrt(n)
	}

	// It finds the prime numbers and store them in an  to be used later.
	static HashSet<Integer> findPrimes(int min, int max) {
		HashSet<Integer> prime = new HashSet<>();

		for (int i = min; i<= max; i++) {
			if (i <= 1)
				continue;	// i is not prime number
			if (isPrime(i)) {
				prime.add(i);
			}
		}
		return prime;
	}

	// Takes a set from the findPrimes method.
	// It scans each item and calculate with all the items smaller than the current item,
	// and record the differences into a HashMap to keep track of the occurrence.
	// It finally prints out the results from the HashMap.
	static void findPrimeGaps(HashSet<Integer> primes) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int prime1: primes) {
			for (int prime2: primes) {
				if (prime1 > prime2) {
					int gap = prime1 - prime2;
					Integer previousCount = (map.get(gap) == null) ? 0 : map.remove(gap);
					map.put(gap, previousCount+1);
				}
			}
		}
		for (int item: map.keySet()) {
			System.out.println(item + "    "  + map.get(item));
		}
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("usage: java Q6_PrimeFinder <min-range> <max-range>");
			return;
		}

		int minRange = (args.length == 1) ? 2 : Integer.parseInt(args[0]);
		int maxRange = (args.length == 1) ? Integer.parseInt(args[0]) : Integer.parseInt(args[1]);
		HashSet<Integer> list = findPrimes(minRange, maxRange);

		System.out.println("Prime Gaps: ");
		findPrimeGaps(list);
	}
}

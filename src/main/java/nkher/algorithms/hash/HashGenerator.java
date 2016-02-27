package nkher.algorithms.hash;

import java.util.function.BiFunction;
import java.util.function.Function;


/***
 * Code reference from : https://github.com/Baqend/Orestes-Bloomfilter/blob/master/src/main/java/orestes/bloomfilter/HashProvider.java
 * 
 * @author nameshkher
 *
 */
public class HashGenerator {
		
	/***
	 * A function the perform rejection sampling on the hash value so that we get a valid index for out BitMap.
	 * The code is referenced from the link given above.
	 * @param random
	 * @param m
	 * @return
	 */
	public static int rejectionSample(int random, int m) {
		random = Math.abs(random);
		if (random > (2147483647 - 2147483647 % m) || random == Integer.MIN_VALUE) {
			return -1;
		}
		else {
			return random % m;
		}
	}
	
	public static int rejectionSampleMurmur(BiFunction<byte[], Integer, Integer> hashFunction, byte[] data, int m) {
		int hash = -1;
		int seed = 0;
		while (hash == -1) {
			seed = hashFunction.apply(data, seed);
			hash = rejectionSample(seed, m);
		}
		return hash;
	}
	
	public static int rejectionSampleFNV(Function<byte[], Integer> hashFunction, byte[] data, int m) {
		int hash = -1;
		int seed = 0;
		while (hash == -1) {
			seed = hashFunction.apply(data);
			hash = rejectionSample(seed, m);
		}
		return hash;
	}
}	

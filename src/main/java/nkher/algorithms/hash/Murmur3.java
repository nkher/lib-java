package nkher.algorithms.hash;

import java.util.Random;

/***
 * References : 
 * 	1. https://en.wikipedia.org/wiki/MurmurHash
 *  2. https://github.com/Baqend/Orestes-Bloomfilter/blob/master/src/main/java/orestes/bloomfilter/HashProvider.java
 * 
 * @author nameshkher
 *
 */
public class Murmur3 extends HashMethod {
	
	private static final int c1 = 0xcc9e2d51;
	private static final int c2 = 0x1b873593;
	private static final int r1 = 15;
	private static final int r2 = 13;
	private static final int m = 5;
	private static final int n = 0xe6546b64;
	
	private static final Random r = new Random();
	
	public Murmur3() {
		setHashFunctionName("murmur3");
	}
	
	public int hash_32(byte[] data) {
		int seed = r.nextInt();
		return hash_32(data, data.length, seed);
	}
	
	private int hash_32(byte[] data, int len, int seed) {
		
		int hash = seed;
		
		int fourByteProcessingEnd = len/4;
						
		// start processing 4 byte chunks of data
		int i = 0;
		for (i=0; i<fourByteProcessingEnd; i++) {
			int k = data[(i*4) + 0] & 0xFF; 
			k |= data[(i*4) + 1] & 0xFF << 8;
			k |= data[(i*4) + 2] & 0xFF << 16;
			k |= data[(i*4) + 3] & 0xFF << 24;			
			
			// Mix the key and the hash
			k = mixKey(k);
			hash = mixHash(hash, k);
		}
		
		// process remaining bytes of data
		i = 4 * fourByteProcessingEnd + 1; // next byte from where processing should start
		while (i < len) {
			int remainingBytes = data[i] & 0xFF;
			remainingBytes = mixKey(remainingBytes);
			hash = hash ^ remainingBytes;
			i++;
		}
		
		// last part
		hash = hash ^ len;
		
		hash = hash ^ (hash >> 16);
		hash = hash * 0x85ebca6b;
		hash = hash ^ (hash >> 13);
		hash = hash * 0xc2b2ae35;
		hash = hash ^ (hash >> 16);
		
		return hash;
	}
	
	private int mixKey(int k) {
		k = k * c1;
		k = Integer.rotateLeft(k, r1);
		k = k * c2;
		return k;
	}
	
	private int mixHash(int h, int k) {
		h = h ^ k;
		h = Integer.rotateLeft(h, r2);
		h = h * m + n;
		return h;
	}
}

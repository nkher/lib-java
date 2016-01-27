package nkher.datastructures.bloomfilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Bool;

import nkher.Interfaces.MyBloomFilter;
import nkher.algorithms.hash.FNV;
import nkher.algorithms.hash.HashGenerator;
import nkher.algorithms.hash.HashMethod;
import nkher.algorithms.hash.Murmur3;
import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.map.BitMap;


/***
 * Some pieces of code taken from : 
 * https://github.com/Baqend/Orestes-Bloomfilter/blob/master/src/main/java/orestes/bloomfilter/FilterBuilder.java
 * 
 * @author nameshkher
 *
 * @param <T>
 */

public class BloomFilter<T> implements MyBloomFilter<T> {

	/** SERIAL ID GENERATED */
	private static final long serialVersionUID = 2328139686555028763L;
	
	private int numberOfExpectedElements;
	private double expectedFalsePositiveProbability;
	private int capacity;
	private int size;
	private int numberOfHashFunctions;
	private BitMap bloomDS;
	private HashMethod[] hashMethods;
	
	public BloomFilter() {
		initHashMethods(); // initializing hash methods
		numberOfHashFunctions = hashMethods.length;
		// still to decide on default expected elements and false positive probability
		bloomDS = new BitMap(); //  initializing the underlying bitmap		
	}
	
	public BloomFilter(int expectedElements, double falsePositiveProbability) {
		initHashMethods();
		expectedFalsePositiveProbability = falsePositiveProbability;
		numberOfExpectedElements = expectedElements;
		numberOfHashFunctions = hashMethods.length;
		capacity = optimialSize(expectedElements, falsePositiveProbability);
		bloomDS = new BitMap(capacity);
	}
	
	public BloomFilter(BloomFilter<T> other) {
		this(other.numberOfExpectedElements, other.expectedFalsePositiveProbability);
		bloomDS = other.bloomDS.clone();
	}
	
	/***
	 * A utility function to initialize our hash methods. 
	 * We use two methods for this BloomFilter. 1. FNV and 2. Murmur3. </br>
	 */
	private void initHashMethods() {
		hashMethods = new HashMethod[2];
		hashMethods[0] = new Murmur3();
		hashMethods[1] = new FNV();
	}

	@Override
	public boolean addBytes(byte[] bytes) {
		boolean inserted = false;
		int[] hashes = hashes(bytes);
		for (int index : hashes) {
			if (bloomDS.get(index) == 0) {
				inserted = true;
				bloomDS.set(index);
			}
		}
		if (inserted) {
			size++;
		}
		return inserted;
	}

	@Override
	public boolean add(T element) {
		byte[] data = element.toString().getBytes();
		return addBytes(data);
	}

	@Override
	public List<Boolean> addList(DynamicArray<T> elements) {
		List<Boolean> result = new ArrayList<>();
		for (T elem : elements) {
			result.add(add(elem));
		}
		return result;
	}

	@Override
	public void clear() {
		bloomDS.clear();
		this.size = 0;
	}

	@Override
	public boolean contains(byte[] data) {
		int[] hashes = hashes(data);
		for (int index : hashes) {
			if (bloomDS.get(index) == 0) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean contains(T element) {
		byte[] data = element.toString().getBytes();
		return contains(data);
	}

	@Override
	public List<Boolean> contains(DynamicArray<T> elements) {
		List<Boolean> result = new ArrayList<>();
		for (T elem : elements) {
			result.add(contains(elem));
		}
		return result;
	}

	@Override
	public MyBloomFilter<T> clone() {
		if (null == bloomDS) {
			throw new NullPointerException("BloomFilter not initialized.");
		}
		return new BloomFilter<>(this);
	}

	@Override
	public int capacity() {
		return this.capacity;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public int numberOfHashFunctionsUsed() {
		return this.numberOfHashFunctions;
	}

	@Override
	public double falsePositiveProbability() {
		return expectedFalsePositiveProbability;
	}
	
	public int numberOfExpectedElements() {
		return numberOfExpectedElements;
	}
	
	private int optimialSize(int n, double p) {
		return (int) Math.ceil(-1 * (n * Math.log(p)) / Math.pow(Math.log(2), 2));
	}
	
	public BitMap getUnerlyingBloomDS() {
		return this.bloomDS;
	}
	
	private int[] hashes(byte[] data) {
		int[] hashes = new int[2];
		
		/*** Calculating two hashes FNV and Murmur3 **/
		hashes[0] = HashGenerator.rejectionSample(FNV::hash_32, data, this.capacity);
		hashes[1] = HashGenerator.rejectionSample(Murmur3::hash_32, data, this.capacity);
		//System.out.println(Arrays.toString(hashes));
		return hashes;
	}
}

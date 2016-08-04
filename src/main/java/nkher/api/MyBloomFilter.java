package nkher.api;

import java.io.Serializable;
import java.util.List;

import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.lists.BitMap;

public interface MyBloomFilter<E> extends Serializable, Cloneable, MyCollection<E> {
		
	/***
	 * A method that adds the bytes of an element into the BloomFilter.</br>
	 * @param bytes byte[] to be added to the {@link nkher.datastructures.bloomfilter.BloomFilter}
	 * @return True is returned if the byte[] data is added successfully else false
	 */
	boolean addBytes(byte[] bytes);

	/***
	 * A method to check if the data represented by the raw bytes is present in the BloomFilter.</br>
	 * @param data <code>true</code> if the byte data is present in the bloom filter
	 * @return True is returned if the bloomfilter contains the byte[] data.
	 */
	boolean contains(byte[] data);
	
	/***
	 * A method to check if an array of elements are present in the BloomFilter. It returns a list of 
	 * booleans where the size of the array is equal to the list. </br>
	 * 
	 * @param elements The {@link DynamicArray} of elements to be checked
	 * @return List of boolean values indicating if each element is present or not. The size is equal to the input elements {@link DynamicArray}
	 */
	List<Boolean> contains(DynamicArray<E> elements);
	
	/***
	 * A method to clone the existing BloomFilter and return a new copy of it.
	 *
	 * @return A newly cloned copy of the bloomfilter.
	 */
	MyBloomFilter<E> clone();
	
	/***
	 * A method to return the capacity of the BloomFilter. This returns a size that is calculated once the
	 * number of expected elements and desired false probability are passed in by the client. When none of these
	 * parameters are passed the BloomFilter uses default values. </br>
	 * 
	 * @return Capacity of the bloomfilter.
	 */
	int capacity();
	
	/***
	 * A method to return the size of the BloomFilter. This returns the number of elements that are actually
	 * present in the BloomFilter. </br>
	 * 
	 * @return Size of the bloomfilter.
	 */
	public int size();
	
	/***
	 * A method to return the number of Hash Functions used for inserting / retrieving the elements from the BloomFilter.</br>
	 *
	 * @return Number of hash functions used by the bloomfilter.
	 */
	int numberOfHashFunctionsUsed();
	
	/***
	 * A method to get the false positive probability of a BloomFilter.
	 *
	 * @return False probability of the bloom filter
	 */
	double falsePositiveProbability();
	
	/***
	 * Returns the number of expected elements to be filled in the BloomFilter which is set by the client. 
	 * Otherwise it returns the default value.
	 * 
	 * @return Number of expected elements to be filled in the bloomfilter
	 */
	int numberOfExpectedElements();

	/***
	 * A method to return the underlying BitMap data structure that stores the actual data.
	 *
	 * @return Returns the underlying {@link BitMap} data structure of the Bloomfilter.
	 */
	BitMap getUnerlyingBloomDS();

	/***
	 * Adds the content of {@link DynamicArray} into the {@link nkher.datastructures.bloomfilter.BloomFilter}
	 *
	 * @param elements
	 * @return
     */
	List<Boolean> addList(DynamicArray<E> elements);
}

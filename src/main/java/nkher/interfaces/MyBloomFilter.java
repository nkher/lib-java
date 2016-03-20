package nkher.interfaces;

import java.io.Serializable;
import java.util.List;

import javax.lang.model.element.Element;

import nkher.datastructures.lists.DynamicArray;
import nkher.datastructures.lists.BitMap;

public interface MyBloomFilter<T> extends Serializable, Cloneable, MyCollection<T> {
		
	/***
	 * A method that adds the bytes of an element into the BloomFilter.</br>
	 * @param bytes
	 * @return
	 */
	boolean addBytes(byte[] bytes);
	
	
	/***
	 * A method that adds an element into the BloomFilter. The element is converted
	 * into raw bytes and then added to the BloomFilter.</br>
	 * 
	 * @param element
	 * @return
	 */
	boolean add(T element);
	
	/***
	 * A method that adds an Array of elements to the BloomFilter. Internally adds each element
	 * to the BloomFilter by converting them into raw bytes.</br>
	 * 
	 * @param elements {@link List} of {@link Element}'s for insertion into the BloomFilter 
	 * @return  {@link List} of {@link Boolean} values indicating true or false whether which values are
	 * inserted and which are not from the list that was passed for insertion. This list must be equal to
	 * the incoming insertion list 
	 */
	List<Boolean> addList(DynamicArray<T> elements);
	
	/***
	 * A method to check if the data represented by the raw bytes is present in the BloomFilter.</br>
	 * @param bytes <code>true</code> if the byte data is present in the bloom filter
	 * @return
	 */
	boolean contains(byte[] data);
	
	/***
	 * A method to check if an array of elements are present in the BloomFilter. It returns a list of 
	 * booleans where the size of the array is equal to the list. </br>
	 * 
	 * @param elements
	 * @return
	 */
	List<Boolean> contains(DynamicArray<T> elements);
	
	/***
	 * A method to clone the existing BloomFilter and return a new copy of it.
	 * @return
	 */
	MyBloomFilter<T> clone();
	
	/***
	 * A method to return the capacity of the BloomFilter. This returns a size that is calculated once the
	 * number of expected elements and desired false probability are passed in by the client. When none of these
	 * parameters are passed the BloomFilter uses default values. </br>
	 * 
	 * @return
	 */
	int capacity();
	
	/***
	 * A method to return the size of the BloomFilter. This returns the number of elements that are actually
	 * present in the BloomFilter. </br>
	 * 
	 * @return
	 */
	public int size();
	
	/***
	 * A method to return the number of Hash Functions used for inserting / retrieving the elements from the BloomFilter.</br>
	 * @return
	 */
	int numberOfHashFunctionsUsed();
	
	/***
	 * A method to get the false positive probability of a BloomFilter.
	 * @return
	 */
	double falsePositiveProbability();
	
	/***
	 * Returns the number of expected elements to be filled in the BloomFilter which is set by the client. 
	 * Otherwise it returns the default value.
	 * 
	 * @return
	 */
	int numberOfExpectedElements();
	
	/***
	 * A method to return the underlying BitMap data structure that stores the actual data.
	 * @return
	 */
	BitMap getUnerlyingBloomDS();
}

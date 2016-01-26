package nkher.Interfaces;

import java.io.Serializable;
import java.util.List;

import nkher.datastructures.lists.DynamicArray;

public interface MyBloomFilter<T> extends Serializable {
		
	/***
	 * A method that adds the bytes of an element into the BloomFilter.</br>
	 * @param bytes
	 * @return
	 */
	public boolean addBytes(byte[] bytes);
	
	
	/***
	 * A method that adds an element into the BloomFilter. The element is converted
	 * into raw bytes and then added to the BloomFilter.</br>
	 * 
	 * @param element
	 * @return
	 */
	public boolean addElement(T element);
	
	/***
	 * A method that adds an Array of elements to the BloomFilter. Internally adds each element
	 * to the BloomFilter by converting them into raw bytes.</br>
	 * 
	 * @param elements
	 * @return
	 */
	public List<Boolean> addAllElements(DynamicArray<T> elements);

	/***
	 * A method to clear the BloomFilter and remove all the elements from it.</br>
	 */
	public void clear();
	
	/***
	 * A method to check if the data represented by the raw bytes is present in the BloomFilter.</br>
	 * @param bytes
	 * @return
	 */
	public boolean checkFilter(byte[] bytes);
	
	/***
	 * A method to check if the element is present in the BloomFilter.</br>
	 * 
	 * @param element
	 * @return
	 */
	public boolean checkFilter(T element);
	
	/***
	 * A method to check if an array of elements are present in the BloomFilter. It returns a list of 
	 * booleans where the size of the array is equal to the list. </br>
	 * 
	 * @param elements
	 * @return
	 */
	public List<Boolean> checkAllElements(DynamicArray<T> elements);
	
	/***
	 * A method to clone the existing BloomFilter and return a new copy of it.
	 * @return
	 */
	public MyBloomFilter<T> clone();
	
	/***
	 * A method to return the size of the BloomFilter. This returns the number of elements that are actually
	 * present in the BloomFilter. </br>
	 * 
	 * @return
	 */
	public int size();
	
	/***
	 * A method that returns the Expected Capacity of the BloomFilter. This is the capacity which we set at the start
	 * of the BloomFilter.</br>
	 * 
	 * @return
	 */
	public int expectedCapacity();
	
	/***
	 * A method to return the number of Hash Functions used for inserting / retrieving the elements from the BloomFilter.</br>
	 * @return
	 */
	public int numberOfHashFunctionsUsed();
	
	/***
	 * A method to get the false positive probability of a BloomFilter.
	 * @return
	 */
	public int falsePositiveProbability();
}

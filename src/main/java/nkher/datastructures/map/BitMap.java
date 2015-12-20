package nkher.datastructures.map;

import nkher.exception.DataStructureEmptyException;

public class BitMap {
	
	public static final int DEFAULT_SIZE = 100;
	
	private long data[]; // 64 bit data
	private int bitCount; // the total number of bits
	private int size; // returns the size of the data array (long)
	private int numberOfElements;
	
	private long mask;
	
	/***
	 * Default constructor for the bit map
	 */
	public BitMap() {
		this(DEFAULT_SIZE);
	}
	
	public BitMap(int size) {
		this.size = size;
		data = new long[size];
		clearDataArray();
		setBitCount(size);
	}
	
	private void clearDataArray() {
		for (int i=0; i<size; i++) {
			data[i] = 0;
		}
	}
	
	private void setBitCount(int size) {
		bitCount = (size << 6);
	}
	
	public void set(int bit) {
		int ind = getIndex(bit); 
		mask = getMask(bit);
		data[ind] |= mask;
		numberOfElements++;
	}
	
	public void unset(int bit) {
		int ind = getIndex(bit);
		mask = getMask(bit);
		data[ind] &= (~mask); // for clearing off the bit we take complement of the mask
		numberOfElements--;
	}
	
	public int get(int bit) {
		int ind = getIndex(bit);
		mask = getMask(bit);
		return ( (data[ind] & mask) == 0 ) ? 0 : 1;
	}
	
	private int getIndex(int bit) {
		return (bit / Long.SIZE); // get the index to be updated
	}
	
	private long getMask(int bit) {
		int position = bit % Long.SIZE; // bit position in the long
		long mask = 1L;
		return mask <<= position;
	}
	
	public int getBitCount() {
		return bitCount;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		if (data == null) {
			throw new NullPointerException();
		}
		if (size == 0) {
			throw new DataStructureEmptyException("Bit Map is empty");
		}
		clearDataArray();
		this.numberOfElements = 0;
	}
	
	public int getNumberOfElements() {
		return this.numberOfElements;
	}
	
	// to be implemented
	public String toString() {
		return null;
	}
}

package nkher.datastructures.tries;

import java.security.InvalidParameterException;
import java.util.List;

import nkher.Interfaces.MyTrie;
import nkher.datastructures.lists.DynamicArray;

public abstract class Trie implements MyTrie {

	protected static final int COUNT_ONE = 1;
	protected int size; 
	
	/*** CONCRETE METHOD IMPLEMENTATIONS */
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (this.size == 0);
	}
	
	protected void checkValidKey(String key) {
		if (null == key) { throw new NullPointerException("Passed key is null ! Please check."); }
		if (key.length() == 0) { 
			System.out.println("Inserting paramter with 0 length. Nothing inserted. Trie not modified."); 
		}
	}
	
	protected void checkValidKeysList(List<String> keys) {
		if (null == keys) { throw new NullPointerException("Passed parameter is null !"); }
		if (keys.size() == 0) { throw new InvalidParameterException("List passed is empty."); }
	}
	
	@Override
	public void buildTrie(List<String> keys) {
		checkValidKeysList(keys);
		for (String key : keys) {
			insert(key);
		}
	}
	
	public void buildTrie(DynamicArray<String> keys) {
		if (null == keys) { throw new NullPointerException("Passed parameter is null !"); }
		if (keys.size() == 0) { throw new InvalidParameterException("List passed is empty."); }
		for (String key : keys) {
			insert(key);
		}
	}
	

	/** ABSTRACT METHODS - TO BE IMPLEMENTED BY CONCRETE METHODS */
	
	@Override
	public abstract void insert(String key);

	@Override
	public abstract boolean contains(String key);

	@Override
	public abstract List<String> prefixSearch(String prefixKey);
	
	@Override
	public abstract boolean containsPrefix(String prefixKey);

	@Override
	public abstract boolean removeKey(String key) ;
	
}

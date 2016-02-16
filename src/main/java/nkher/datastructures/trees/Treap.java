package nkher.datastructures.trees;

import nkher.Interfaces.MyTreap;

public class Treap<K, V> implements MyTreap<K, V> {

	@Override
	public void insert(K key, V val) {		
	}

	@Override
	public void remove(K key) {		
	}

	@Override
	public boolean exists(K key) {
		return false;
	}

	@Override
	public K minKey() {
		return null;
	}

	@Override
	public V minVal() {
		return null;
	}

	@Override
	public K maxKey() {
		return null;
	}

	@Override
	public V maxVal() {
		return null;
	}

	@Override
	public void clear() {		
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

}

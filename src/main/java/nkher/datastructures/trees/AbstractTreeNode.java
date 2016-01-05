package nkher.datastructures.trees;

/***
 * An abstract implementation of the data structure that represents a basic form of a Node of any
 * Tree Data Structure used in this library. All other tree nodes extend from this class and define
 * their own specifications by adding members or methods to it. It is a node that contains a <Key, Value>
 * pair and left and right children attached to it. This class is intentionally kept abstract so that
 * no instances for the class can be created by the client.
 * 
 * @author nameshkher
 *
 */
public abstract class AbstractTreeNode<K extends Comparable<K>, V> {
	
	protected K key; // field that determines the order of insertion
	protected V value;
	
	public K key() {
		return this.key;
	}
	
	public V value() {
		return this.value;
	}
	
	public void setKey(K key) {
		this.key = key;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public abstract AbstractTreeNode<K, V> left();
	
	public abstract AbstractTreeNode<K, V> right();

}

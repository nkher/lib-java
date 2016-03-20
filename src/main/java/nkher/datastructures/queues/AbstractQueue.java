package nkher.datastructures.queues;

public abstract class AbstractQueue<T> {
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final int k_SCALE_FACTOR = 3; // will increase storage by 3 times
	public static final int k_REDUCE_FACTOR = 2; // will reduce the storage by 2 times
	
	protected Object data[];
	
}

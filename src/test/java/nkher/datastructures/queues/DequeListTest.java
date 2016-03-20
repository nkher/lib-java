package nkher.datastructures.queues;

import org.junit.Assert;
import org.junit.Test;

public class DequeListTest {
	
	private static final int NUMBER_FIVE = 5;
	private static final int NUMBER_SIX = 6;
	
	@Test
	public void testEnqueueOperationForDequeueList() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		Assert.assertEquals(deque.size(), NUMBER_FIVE);
		Assert.assertEquals(deque.head(), new Integer(1));
	}
	
	@Test
	public void testEnqueueAtHeadOperationForDequeueList() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		Assert.assertEquals(deque.head(), new Integer(1));
		
		/* Inserting the the head of the dequeue */
		deque.enqueueAtHead(0);
		Assert.assertEquals(deque.head(), new Integer(0));
		
		Assert.assertEquals(deque.size(), NUMBER_SIX);
	}
	
	
	private DequeList<Integer> getIntegerDequeueWith5Elements() {
		DequeList<Integer> deque = new DequeList<>();
		deque.enqueue(1);
		deque.enqueue(2);
		deque.enqueue(3);
		deque.enqueue(4);
		deque.enqueue(5);
		return deque;
	}
}

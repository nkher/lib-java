package nkher.datastructures.queues;

import nkher.datastructures.util.Constants;
import nkher.exception.DataStructureEmptyException;

import org.junit.Assert;
import org.junit.Test;

public class DequeListTest {
	
	@Test
	public void testEnqueueAndDequeueOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		
		/* Asserting the size of the deque */
		Assert.assertEquals(deque.size(), Constants.NUMBER_FIVE);
		
		int size = deque.size();
		
		/* Assert each element has been inserted in the correct order */
		for (int i=0; i<Constants.dataLen; i++) {
			Assert.assertEquals(deque.dequeue().intValue(), Constants.data[i]);
			Assert.assertEquals(deque.size(), (size-(i+1)));
		}
	}
	
	@Test
	public void testEnqueueAtHeadOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		Assert.assertEquals(deque.head(), new Integer(1));
		
		/* Inserting the the head of the dequeue */
		deque.enqueueAtHead(0);
		/* Asserting that we have the correct element at the head of the deque */
		Assert.assertEquals(deque.head(), new Integer(0));
		
		Assert.assertEquals(deque.size(), Constants.NUMBER_SIX);
	}
	
	@Test(expected = DataStructureEmptyException.class)
	public void testDequeueOperationForEmptyDeque() {
		DequeList<Integer> deque = new DequeList<Integer>();
		/* Performing dequeue() on an empty deque */
		deque.dequeue();
	}
	
	@Test
	public void testDeququeAtTailOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		int size = deque.size();
		
		int elementAtTail = Constants.data[4];
		Assert.assertEquals(deque.deqeueAtTail().intValue(), elementAtTail);
		
		/* Asserting the size */
		int newSize = size-1;
		Assert.assertEquals(deque.size(), newSize);
	}
	
	@Test(expected = DataStructureEmptyException.class)
	public void testDeququeAtTailOperationForEmprtyDeque() {
		DequeList<Integer> deque = new DequeList<Integer>();
		/* Performing dequeue() on an empty deque */
		deque.deqeueAtTail();
	}
	
	@Test
	public void testHeadOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		int elementAtHead = Constants.data[0];
		Assert.assertEquals(deque.head().intValue(), elementAtHead);
	}
	
	@Test
	public void testTailOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		int elementAtTail = Constants.data[4];
		Assert.assertEquals(deque.tail().intValue(), elementAtTail);
	}
	
	@Test
	public void testClearOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		deque.clear();
		Assert.assertTrue(deque.isEmpty());	
	}
	
	@Test
	public void testContainsOperation() {
		DequeList<Integer> deque = getIntegerDequeueWith5Elements();
		for (int i=0; i<Constants.dataLen; i++) {
			Assert.assertTrue(deque.contains(Constants.data[i]));
		}
	}
		
	private DequeList<Integer> getIntegerDequeueWith5Elements() {
		DequeList<Integer> deque = new DequeList<>();
		for (int i=0; i<Constants.dataLen; i++) {
			deque.enqueue(Constants.data[i]);
		}
		return deque;
	}
}

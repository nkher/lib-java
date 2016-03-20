package nkher.datastructures.queues;

import nkher.datastructures.util.Constants;

import org.junit.Assert;
import org.junit.Test;

public class CircularBufferTest {
	
	private CircularBuffer<Integer> circularBuffer;
	
	@Test
	public void testEnqueueAndDequeueOperation() {
		circularBuffer = getCircularBufferWith5ElementsAndCapacity5();
		/* Asserting the size */
		Assert.assertEquals(circularBuffer.size(), Constants.dataLen);
		
		int size = circularBuffer.size();
		
		/* Asserting each element within the buffer */
		for (int i=0; i<Constants.dataLen; i++) {
			Assert.assertEquals(circularBuffer.dequeue().intValue(), Constants.data[i]);
			Assert.assertEquals(circularBuffer.size(), (size-(i+1)));
		}
	}
	
	@Test
	public void testEnqueueOperationForOverrideCondition() {
		circularBuffer = getCircularBufferWith5ElementsAndCapacity5();
		/* Asserting the size */
		Assert.assertEquals(circularBuffer.size(), Constants.dataLen);
		
		int previousHead = circularBuffer.head().intValue();
		
		/* Writing data for overriding the current data at the head */
		circularBuffer.enqueue(Constants.NUMBER_SIX);
		
		Assert.assertFalse(circularBuffer.head().intValue() == previousHead);
		Assert.assertEquals(Constants.NUMBER_TWO, circularBuffer.peek().intValue());
	}
	
	@Test
	public void testClearOperation() {
		circularBuffer = getCircularBufferWith5ElementsAndCapacity5();
		/* Asserting the size */
		Assert.assertEquals(circularBuffer.size(), Constants.dataLen);
		
		/* Clear the circular buffer */
		circularBuffer.clear();
		Assert.assertEquals(circularBuffer.size(), Constants.NUMBER_ZERO);
	}
	
	private CircularBuffer<Integer> getCircularBufferWith5ElementsAndCapacity5() {
		CircularBuffer<Integer> circularBuffer = new CircularBuffer<>(5);
		for (int i=0; i<Constants.dataLen; i++) {
			circularBuffer.enqueue(Constants.data[i]);
		}
		return circularBuffer;
	}
}

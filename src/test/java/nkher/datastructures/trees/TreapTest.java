package nkher.datastructures.trees;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import nkher.datastructures.trees.Treap.TreapNode;

public class TreapTest {
	
	// Data Structure under test
	private Treap<Integer, Integer> treap;
	
	private ArrayList<TreapNode<Integer, Integer>> nodes;
	private Random rand = new Random();
	
	@Before
	public void setup() {
		treap = new Treap<>();
	}
	
	@Test
	public void testTreapInsertionWithTenRandomNodes() {
		insertTenRandomRecordsIntoTreap();
		System.out.println(treap.inorder().toString());
		System.out.println(treap.root());
		Assert.assertTrue(validateTreapForBSTProperty());
	}
	
	@Test
	public void testTreapInsertionWithTenStaticNodes() {
		insertTenStaticRecordsIntoTreap();
		System.out.println(treap.inorder().toString());
		System.out.println(treap.root());
		System.out.println(treap.root().left());
		System.out.println(treap.root().right());
		Assert.assertTrue(validateTreapForBSTProperty());
	}
	
	private boolean validateTreapForBSTProperty() {
		return validateTreapForBSTPropertyHelper(treap.root(), Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private boolean validateTreapForBSTPropertyHelper(TreapNode<Integer, Integer> node, int min, int max) {
		
		if (node == null) {
			return true;
		}
		
		if (node.key() <= min || node.key() >= max) {
			return false;
		}
		
		return validateTreapForBSTPropertyHelper(node.left(), min, node.value()) && 
				validateTreapForBSTPropertyHelper(node.right(), node.value(), max);
	}
	
	private void insertTenStaticRecordsIntoTreap() {
		
		treap.insertWithPriority(50, 50, 15);
		treap.insertWithPriority(30, 30, 5);
		treap.insertWithPriority(70, 70, 10); 
		treap.insertWithPriority(20, 20, 2);
		treap.insertWithPriority(40, 40, 4);
		treap.insertWithPriority(80, 80, 12);
	}
	
	private void insertTenRandomRecordsIntoTreap() {
		
		for (int i=0; i<10; i++) {
			int key = rand.nextInt(100);
			int value = rand.nextInt(100);
			treap.insert(new TreapNode<>(key, value));
		}
	}
	
	

}

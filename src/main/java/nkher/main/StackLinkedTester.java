package nkher.main;

import nkher.algorithms.sorting.Sorting;
import nkher.datastructures.stacks.StackLinked;

public class StackLinkedTester {

	public static void main(String[] args) {
		
		StackLinked<String> stack = new StackLinked<String>();
		
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		
		stack.push("namesh");
		System.out.println(stack.pop());
		
		stack.push("sarika");
		System.out.println("Peek is -> " + stack.peek());
		
		
		stack.push("namesh");
		stack.push("eshan");
		stack.push("utsav");
		stack.push("amit");
		stack.push("anshima");
		
		
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		
		System.out.println("peeking -> " + stack.peek());
		System.out.println("peeking -> " + stack.peek());
		System.out.println("peeking -> " + stack.peek());
		
		System.out.println("popping -> " + stack.pop());
		System.out.println("popping -> " + stack.pop());
		System.out.println("popping -> " + stack.pop());
		
		stack.push("atima");
		stack.push("shivani");
		
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		stack.reverse();
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		
		stack.sort(Sorting.ORDER_DESC);
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		
		stack.sort(Sorting.ORDER_ASC);
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
		
		stack.clear();
		
		System.out.println("stack -> " + stack.toString() + ", size -> " + stack.size());
	}

}

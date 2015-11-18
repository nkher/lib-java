package nkher.main;

import java.util.Stack;

import nkher.datastructures.stacks.StackArray;

public class StackTester {

	public static void main(String[] args) {
		StackArray<Integer> stack = new StackArray<Integer>();
		System.out.println(stack.size());
		System.out.println(stack.toString());
		stack.push(9);
		stack.push(99);
		stack.push(999);
		stack.push(9999);
		stack.push(99999);
		
		
		
		System.out.println("Here : " + stack.toString());
		
		stack.reverse();
		
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		System.out.println(stack.size());
		
		stack.push(1000);
		
		System.out.println(stack.size());
		System.out.println(stack.toString());
		
		stack.pop();stack.pop();stack.pop();
		System.out.println(stack.toString());
		
		stack.pop();
		System.out.println(stack.toString());
		
		// stack.pop();
		Stack<Integer> s = new Stack<Integer>();
	}

}

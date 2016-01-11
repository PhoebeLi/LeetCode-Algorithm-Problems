package java_exercise;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	/*
	 * mplement the following operations of a queue using stacks.

	 * push(x) -- Push element x to the back of queue.
	 * pop() -- Removes the element from in front of queue.
	 * peek() -- Get the front element.
	 * empty() -- Return whether the queue is empty.
	 */

	Stack<Integer> converter = new Stack<Integer>();
	Stack<Integer> s = new Stack<Integer>();
	
	
	
	public void push(int x) {
        if (s.empty()) {
			s.push(x);
			
			
		} else {
			while(!s.empty()) {
				converter.push(s.pop());
			}
			converter.push(x);
			
			while(!converter.empty()) {
				s.push(converter.pop());
			}
		}
    }

    // Removes the element from in front of queue.
    public void pop() {
        s.pop();
    }

    // Get the front element.
    public int peek() {
        return s.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (s.empty());
    }

}

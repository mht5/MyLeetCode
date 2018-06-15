package leetcode;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * @author mhts
 *
 */
public class ImplementQueueUsingStacks {
	static Stack<Integer> in=new Stack<Integer>();
	static Stack<Integer> out=new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
    	in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(out.isEmpty()){
        	inToOut();
        }
        if(!out.isEmpty()){
        	out.pop();
        }
    }

    // Get the front element.
    public int peek() {
		if(out.isEmpty()){
			inToOut();
		}
        if(!out.isEmpty()){
			return out.get(out.size()-1);
		}
		return 0;
    }

    // Return whether the queue is empty.
    public boolean empty() {
		return in.isEmpty() && out.isEmpty();
    }
    
    public static void inToOut(){
    	while(!in.isEmpty()){
    		out.push(in.pop());
    	}
    }
}

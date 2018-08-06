package my.czhhu.algo.stack;

import java.util.Stack;

/**
 * reverse stack only use push and pop
 * 
 */
public class ReverseStack {
	static void reverse(Stack<String> s) {
		if (s.isEmpty())
			return;
		String tmp = s.pop();
		reverse(s);
		insertAtBottem(s, tmp);
	}

	static void insertAtBottem(Stack<String> s, String data) {
		if (s.isEmpty()) {
			s.push(data);
			return;
		}
		String tmp = s.pop();
		insertAtBottem(s, data);
		s.push(tmp);
	}

	public static void main(String[] args) {
		Stack<String> s = new Stack<>();
		s.push("1");
		s.push("2");
		s.push("3");
		System.out.println(s);
		reverse(s);

		System.out.println(s);

	}

}

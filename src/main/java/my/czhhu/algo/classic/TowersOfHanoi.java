package my.czhhu.algo.classic;

public class TowersOfHanoi {
	static void run(int n, char frompeg, char topeg, char auxpeg) {

		if (n == 0) {
			return;
		}
		run(n - 1, frompeg, auxpeg, topeg);
		System.out.println("move " + n + " disk from " + frompeg + " to " + topeg);
		run(n - 1, auxpeg, topeg, frompeg);
	}

	/*
	 * static void printStack(Stack<Integer> s, StringBuilder sb) { if (s.isEmpty())
	 * { return; } int a = s.pop(); printStack(s, sb); sb.append(a);
	 * 
	 * }
	 */

	public static void main(String[] args) {
		run(3, '1', '2', '3');
		/*
		 * Stack<Integer> s = new Stack<Integer>(); s.push(1); s.push(2); s.push(3);
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * printStack(s, sb); System.out.println(sb.toString());
		 */
	}

}

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

	public static void main(String[] args) {
		run(3, '1', '2', '3');

	}

}

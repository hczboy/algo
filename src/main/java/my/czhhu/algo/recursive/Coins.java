package my.czhhu.algo.recursive;

public class Coins {

	static int coins(int n, int denom) {

		int ndenom = 0;

		switch (denom) {
		case 25:
			ndenom = 10;
			break;
		case 10:
			ndenom = 5;
			break;
		case 5:
			ndenom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += coins(n - i * denom, ndenom);
		}
		return ways;

	}

	public static void main(String[] args) {
		System.out.println(coins(10, 10));
	}

}

package G_Mod;

import java.util.Scanner;

/**
 * 计算(a^b)%k的值
 * 样例输入：
2
2 10 9
3 18132 17
 * 样例输出：
7
13
 * @author majin
 *
 */
public class Modulo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int times = scan.nextInt();
		for (int i = 0; i < times; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int k = scan.nextInt();
			System.out.println(mod(a, b, k));
		}
	}

	/**
	 * 利用公式：(a * b) % k = ((a % k) * (b % k)) % k
	 * 
	 * @param a
	 * @param b
	 * @param k
	 * @return (a^b)%k
	 */
	private static int mod(int a, int b, int k) {
		if (b == 0) {
			return 1;
		} else if (b == 1) {
			return a % k;
		}

		if (b % 2 == 0) {
			return mod((a * a) % k, b / 2,k);
		} else {
			return (a * mod(a, b - 1, k)) % k;
		}
	}

}

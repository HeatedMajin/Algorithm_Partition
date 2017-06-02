package F_YinziFenjie;

import java.util.Scanner;

/**
 * 给出一个正整数n的所有正整数因子分解式
 * 如：12
 * 12
 * 6 * 2
 * 4 * 3
 * 3 * 2 *2
 * @author majin
 *
 */
public class YiniFenjie {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		if (num > 1) {
			split("", num, num);
		}
	}

	private static void split(String str, int num, int max) {
		if (num == 1) {
			System.out.println(str.substring(0,str.lastIndexOf("*")));
		} else {
			int i = num;
			if (num > max) {
				i = max;
			}
			for (; i > 1; --i) {
				if (num % i == 0) {
					split(str+i+"*", num/i, i);
				}
			}
		}
	}

}

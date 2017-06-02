package H_ZOJ1633_BigString;

import java.util.Scanner;

/**
 * A="^__^"(4个) B="T.T"(三个),以A、B为基础创建无限长的字符串，规则如下：
 * 1）C=B+A
 * 2)A=B,B=C
 * 要求给出任意位置n的字符
 * 样例输入：
4
1
2
4
8
 * 样例输出：
T
.
^
T
 * @author majin
 *
 */
public class BigString {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[100];
		calcFabo(arr);
		//		String str = generateString(88);
		int times = scan.nextInt();
		for (int i = 0; i < times; i++) {
			int num = scan.nextInt();
			//			System.out.println(str.charAt(num - 1));
			String base = "T.T^__^";
			while (num > 7) {//num - 最大的小于他的fibo
				int index = 0;
				while (index < 99 && arr[index] < num) {
					index++;
				}
				num = num - arr[index-1];
			}
			System.out.println(base.charAt(num-1));
		}
	}

	private static void calcFabo(int[] arr) {
		arr[1] = 3;
		arr[2] = 4;
		for (int i = 3; i <= 99; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
	}

	//直接求出这个无限长的串，让串的长度小于2^63-1，失败！！
	private static String generateString(int deep) {
		String result = "";
		String A = "^__^";
		String B = "T.T";
		for (int i = 0; i < 10; i++) {
			result = B + A;
			A = B;
			B = result;
			System.out.println(result);
		}

		return result.toString();
	}
}

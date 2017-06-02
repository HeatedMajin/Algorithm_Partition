package H_ZOJ1633_BigString;

import java.util.Scanner;

/**
 * A="^__^"(4��) B="T.T"(����),��A��BΪ�����������޳����ַ������������£�
 * 1��C=B+A
 * 2)A=B,B=C
 * Ҫ���������λ��n���ַ�
 * �������룺
4
1
2
4
8
 * ���������
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
			while (num > 7) {//num - ����С������fibo
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

	//ֱ�����������޳��Ĵ����ô��ĳ���С��2^63-1��ʧ�ܣ���
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

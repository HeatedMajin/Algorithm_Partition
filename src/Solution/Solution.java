package Solution;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * ʹ�÷���˼��ⷽ��
 * ��������8*x^4+7*x^3+2*x^2+3*x+6=y
 	����x����[0,100]֮���ҵ����̵Ľ���
 	�������룺
 	2
 	100
 	-4
 	���������
 	1.6152
 	No solution!
 *
 */
public class Solution {
	//�ж�l�ұ��ǲ����н�
	private static boolean solve(double l, double y) {
		double x = l;
		if (y - (8 * x * x * x * x + 7 * x * x * x + 2 * x * x + 3 * x + 6) > 0) {
			return true;
		} else {
			return false;
		}
	}

	final static double accuracy = 1 * Math.pow(1, -6);

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int times = scan.nextInt();
		for (int i = 0; i < times; i++) {
			double y = scan.nextDouble();
			if (y < 6 || y > 807020306) {
				System.out.println("no solution!");
			} else {
				double l = 0;
				double r = 100;
				while (r - l > accuracy) {
					double m = (l + r) / 2;
					if (solve(m, y)) {
						l = m;
					} else {
						r = m;
					}
				}
				DecimalFormat format = new DecimalFormat("#.00");
			//	System.out.println(l);
				System.out.println(format.format(l));
			}
		}
	}

}

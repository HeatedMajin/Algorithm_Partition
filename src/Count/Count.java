package Count;

/**
 * ʹ�÷���˼������������
 * ����������
 * ������������a��b������1��a~b֮����ֵĴ�����
 * �磺1024~1032
 * ��ô1024 1025 1026 1027 1028 1029 1030 1031 1032
 * ��Ÿ�������ʮ��1
 * ��������
 1 10
 44 497
 346 542
 1199 1748
 1496 1403
 1004 503
 1714 190
 1317 854
 1976 494
 1001 1960
 0 0

 * ���
 2
 185
 40
 666
 113
 105
 1133
 512
 1375
 512
 1375
 1256
 * @author majin
 *
 */
public class Count {
	//nλ����1�ĸ����ֽ������n-1λ����1�ĸ���+����
	//�磺f��12��=f��10-1��+f��12-10��+3
	//f(132)=f(100-1)+f(132-100)+33
	//f(232)=2*f(100-1)+f(232-200)+100
	private static long count(long a) {
		if (1 < a && a < 10)
			return 1;
		else if (a == 0)
			return 0;

		long maxBit = 0;//���λ
		long maxValue = 1;//��¼���λ�������������maxValue(232)=100
		long temp = a;
		while (temp != 0) {
			temp /= 10;
			if (temp != 0) {
				maxValue *= 10;
				maxBit = temp;
			}
		}

		long first = 0;
		long second = 0;
		long thrid = 0;
		if (maxBit == 1) {
			//���λ����1�������ɺ����������
			first = count(maxValue - 1);
			second = count(a - maxValue);
			thrid = a - maxValue + 1;

		} else {
			//���λ����1�����������λ������
			first = maxBit * count(maxValue - 1);
			second = count(a - maxBit * maxValue);
			thrid = maxValue;

		}
		return first + second + thrid;
	}

	//countѹ������
	private static long count_press(long a) {
		if (1 < a && a < 10)
			return 1;
		else if (a == 0)
			return 0;

		long maxBit = a;//���λ
		long maxValue = 1;//��¼���λ�������������maxValue(232)=100
		while (maxBit >= 10) {
			maxBit /= 10;
			maxValue *= 10;
		}

		if (maxBit == 1) {
			//���λ����1�������ɺ����������
			return count(maxValue - 1) + count(a - maxValue) + (a - maxValue + 1);
		} else {
			//���λ����1�����������λ������
			return maxBit * count(maxValue - 1) + count(a - maxBit * maxValue) + maxValue;
		}
	}

	public static void main(String[] args) {
		long starttime = 0;
		long endtime = 0;

		starttime = System.currentTimeMillis();
		System.out.println(count_press(200000000));
		endtime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (endtime-starttime) + "ms");

		//		System.out.println(count(2000));
		//		System.out.println(count_press(20));

		starttime = System.currentTimeMillis();
		System.out.println(count_fool(200000000));
		endtime = System.currentTimeMillis();
		System.out.println("��ʱ��" + (  endtime-starttime) + "ms");
	}

	private static long count_fool(long a) {
		int count = 0;
		int temp = 0;
		for (int i = 1; i <= a; i++) {//����1~a��������
			temp = i;
			while (temp != 0) {//���������������λ
				if (temp % 10 == 1) {
					++count;
				}
				temp /= 10;
			}
		}
		return count;
	}

}

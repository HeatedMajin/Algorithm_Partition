package E_HalfNumber;

import java.util.Scanner;

/**
����һ����Ȼ��n����n��ʼ�������β���������set(n)�е������¡�
(1) n��set(n)��
(2) ��n����߼���һ����Ȼ����������Ȼ�����ܳ��������ӵ�����һ�룻
(3) ���˹�����д���ֱ�������������Ȼ��Ϊֹ��
���磬set(6)={6,16,26,126,36,136}��������set(6)����6 ��Ԫ�ء�
ע��������Ƕ��ؼ���
�������
���ڸ�������Ȼ��n����̼��������set(n)�е�Ԫ�ظ�����
����
��������ֻ��1 �У���������n��(0<n<1000)
���
�������н���ʱ������������������ֻ��1 �У�����������set(n)�е�Ԫ�ظ�����
��������
6
�������
6
 * @author majin
 * 
 * <a href='https://wenku.baidu.com/view/a564661677232f60ddcca150.html'>�ö���</a>
 */
public class HalfNumber {

	public static void main(String[] args) {
		long startTime = 0;
		long endTime = 0;

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		/*//ԭʼ
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer(num));
		endTime = System.currentTimeMillis();
		System.out.println("�������е�ʱ����" + (endTime - startTime) + "ms");
		
		//�Ľ�һ��
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer2(num));
		endTime = System.currentTimeMillis();
		System.out.println("�������е�ʱ����" + (endTime - startTime) + "ms");
		*/
		//�Ľ�����
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer3(num));
		endTime = System.currentTimeMillis();
		System.out.println("�������е�ʱ����" + (endTime - startTime) + "ms");

		//�Ľ�����
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer4(num));
		endTime = System.currentTimeMillis();
		System.out.println("�������е�ʱ����" + (endTime - startTime) + "ms");
	}

	/**
	 * ��ȫ���ն��壺$f(n)=1+\sum\limits_{i=1}^{i=n/2}{f(i)}$
	 */
	private static int halfNumer(int num) {
		int count = 1;
		if (num > 1) {
			for (int i = 1; i <= num / 2; i++) {
				count += halfNumer(i);
			}
		}
		return count;
	}

	/**
	 * ���м���ʽ����
	 * ���Ѿ�������Ľ������¼
	 */
	static int arr[] = new int[10000];

	private static int halfNumer2(int num) {
		int count = 1;
		if (arr[num] != 0) {
			return arr[num];
		}
		if (num > 1) {
			for (int i = 1; i <= num / 2; i++) {
				count += halfNumer(i);
			}
		}
		arr[num] = count;
		return count;
	}

	static int arr3[] = new int[10000];

	/**
	 * ���й۲죺����������һ��ż��
	 * ���й�ʽ��f(n)=f(n-1) (n % 2 == 1)
	 */
	private static int halfNumer3(int num) {
		if(num==1){
			return 1;
		}
		int count = 1;
		if (arr3[num] != 0) {
			return arr3[num];
		}
		for (int i = 1; i <= num / 2; i++) {
			count += halfNumer(i);
		}
		arr3[num] = count;
		if (num % 2 == 1) {
			arr3[num - 1] = count;
		} else {
			arr3[num + 1] = count;
		}
		return count;
	}

	static int arr4[] = new int[10000];

	/**
	 * ���й۲죺����������һ��ż��
	 * ���й�ʽ��f(n)=f(n-1) (n % 2 == 1)
	 * ���й۲����ż��ʱ����һ���������ܼ���n/2��ֻ����������ϼ���һ��f(n/2)
	 * f(n) = f(n-1)+f(n/2) ( n % 2 == 0)
	 */
	private static int halfNumer4(int num) {
		if (num == 1) {
			return 1;
		}
		//get arr
		if (arr4[num] != 0) {
			return arr4[num];
		}
		//calc
		int count = 1;
		if (num % 2 == 0) {//ou
			count = halfNumer(num - 1) + halfNumer(num>>1);
			//set arr
			arr4[num + 1] = count;
		} else { //ji
			for (int i = 1; i <= num / 2; i++) {
				count += halfNumer(i);
			}
			//set arr
			arr4[num - 1] = count;
		}
		//set arr
		arr4[num] = count;
		return count;
	}
}

package E_HalfNumber;

import java.util.Scanner;

/**
给定一个自然数n，由n开始可以依次产生半数集set(n)中的数如下。
(1) n∈set(n)；
(2) 在n的左边加上一个自然数，但该自然数不能超过最近添加的数的一半；
(3) 按此规则进行处理，直到不能再添加自然数为止。
例如，set(6)={6,16,26,126,36,136}。半数集set(6)中有6 个元素。
注意半数集是多重集。
编程任务：
对于给定的自然数n，编程计算半数集set(n)中的元素个数。
输入
输入数据只有1 行，给出整数n。(0<n<1000)
输出
程序运行结束时，将计算结果输出。输出只有1 行，给出半数集set(n)中的元素个数。
样例输入
6
样例输出
6
 * @author majin
 * 
 * <a href='https://wenku.baidu.com/view/a564661677232f60ddcca150.html'>好东西</a>
 */
public class HalfNumber {

	public static void main(String[] args) {
		long startTime = 0;
		long endTime = 0;

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		/*//原始
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer(num));
		endTime = System.currentTimeMillis();
		System.out.println("花费运行的时间是" + (endTime - startTime) + "ms");
		
		//改进一次
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer2(num));
		endTime = System.currentTimeMillis();
		System.out.println("花费运行的时间是" + (endTime - startTime) + "ms");
		*/
		//改进二次
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer3(num));
		endTime = System.currentTimeMillis();
		System.out.println("花费运行的时间是" + (endTime - startTime) + "ms");

		//改进三次
		startTime = System.currentTimeMillis();
		System.out.println(halfNumer4(num));
		endTime = System.currentTimeMillis();
		System.out.println("花费运行的时间是" + (endTime - startTime) + "ms");
	}

	/**
	 * 完全按照定义：$f(n)=1+\sum\limits_{i=1}^{i=n/2}{f(i)}$
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
	 * 进行记忆式搜索
	 * 对已经计算过的结果做记录
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
	 * 进行观察：奇数等于上一个偶数
	 * 即有公式：f(n)=f(n-1) (n % 2 == 1)
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
	 * 进行观察：奇数等于上一个偶数
	 * 即有公式：f(n)=f(n-1) (n % 2 == 1)
	 * 进行观察二：偶数时，上一个奇数不能加上n/2，只是在其基础上加了一个f(n/2)
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

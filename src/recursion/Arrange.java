package recursion;

import java.util.Scanner;

//输出1~n全排列，n由用户读入
//如：输入3
//输出：123、132、213、231、321、312

public class Arrange {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int[] arr = new int[input + 1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		arrange(arr, 1);

	}

	//第n个数往后的全排列
	private static void arrange(int[] arr,int n) {
		if (n == arr.length) {
			for (int index = 1; index < arr.length; index++) {
				System.out.print(arr[index]);
			}
			System.out.println();
		} else {
			for (int i = n; i<arr.length; i++) {
				swap(arr, n, i);
				arrange(arr, n + 1);
				swap(arr, i, n);
			}
		}
	}

	private static void swap(int[] arr, int i, int i2) {
		int temp = arr[i2];
		arr[i2] = arr[i];
		arr[i] = temp;
	}

}

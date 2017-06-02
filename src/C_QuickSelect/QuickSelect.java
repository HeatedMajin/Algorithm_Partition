package C_QuickSelect;

import java.util.Scanner;

/**
 * 对于给定n个元素的数组，要求从中找第k小的元素
 * 样例输入：
2
6 2
3 5 2 9 1 7
4 3
1 2 4 3
 * 输入说明：
 * 第一行要进行几次数组的选择
 * 接下来一行 n k
 * 下一行 n个元素
输出：
2
3
 * @author majin
 *
 */
public class QuickSelect {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int times = scan.nextInt();
		for (int i = 0; i < times; i++) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			int arr[] = new int[n];
			for (int arrIndex = 0; arrIndex < n; arrIndex++) {
				arr[arrIndex] = scan.nextInt();
			}
			quickSelect(arr, 0, n-1, k);
			System.out.println(arr[k]);
		}
	}

	//使用快排的思想
	private static void quickSelect(int[] arr, int start, int end, int k) {
		int temp = arr[start];
		int keng = start;
		int l = start + 1;
		int r = end;
		while (l < r) {
			while (l < r && temp < arr[r]) {
				--r;
			}
			if (l < r) {
				arr[keng] = arr[r];
				keng = r;
			}
			while (l < r && temp > arr[r]) {
				++l;
			}
			if (l < r) {
				arr[keng] = arr[l];
				keng = l;
			}
		}
		arr[keng] = temp;
		if (keng == k) {
			return;
		} else if (k < keng) {
			quickSelect(arr, start, keng-1, k);
		} else if (k > keng) {
			quickSelect(arr, keng+1, end, k);
		}
	}

}

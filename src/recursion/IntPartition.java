package recursion;

import java.util.Scanner;

//整数的划分，用户输入要划分的数
//输入4
/*
输出 
3+1
2+2，2+1+1
1+1+1+1
*/
public class IntPartition {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		partition("", num, num);
	}

	private static void partition(String cur, int num, int max) {
		if (num > 1) {
			int i =num;
			if(num>max){
				i=max;
			}
			for (; i >= 1; --i) {
				partition(cur + i + "+", num - i, i);
			}
		} else if(num==1){
			String str = cur + 1 + "+";
			System.out.println(str.substring(0, str.lastIndexOf("+")));
		}else{
			System.out.println(cur.substring(0, cur.lastIndexOf("+")));
		}
	}

}

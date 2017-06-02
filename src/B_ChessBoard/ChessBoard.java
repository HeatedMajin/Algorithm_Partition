package B_ChessBoard;

import java.util.Scanner;

/**
 * ���̸������⣺����һ������2^k����һ������λ��
 * ʹ��L�͵Ŀ����������̣����ǣ����������������û�п���ص�
 * �����һ��Ϊk���ڶ���Ϊ������λ��
 * �������룺
 * 2
 * 0 1
 * ���������
2 0 3 3
2 2 1 3
4 1 1 5
4 4 5 5
 * 
 * @author majin
 *
 */

public class ChessBoard {
	private static int[][] arr;
	private static int flag = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int k = scan.nextInt();
		int x = scan.nextInt();
		int y = scan.nextInt();
		arr = new int[1 << k][1 << k];
		fullChessBoard(0, 0, x, y, 1 << k);
		for (int i = 0; i < 1 << k; i++) {
			for (int j = 0; j < 1 << k; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	private static void fullChessBoard(int tx, int ty, int dx, int dy, int size) {
		if (size == 1)
			return;
		int csize = size / 2;
		int t = flag++;
		//������Ͻǵ�������
		if (dx < tx + csize && dy < ty + csize) {
			//����������Ͻ�ʱ
			fullChessBoard(tx, ty, dx, dy, csize);
		} else {
			arr[tx + csize - 1][ty + csize - 1] = t;
			fullChessBoard(tx, ty, tx + csize - 1, ty + csize - 1, csize);
		}

		//������Ͻǵ�������
		if (dx < tx + csize && dy >= ty + csize) {
			//����������Ͻ�ʱ
			fullChessBoard(tx, ty+csize, dx, dy, csize);
		} else {
			arr[tx + csize - 1][ty + csize] = t;
			fullChessBoard(tx, ty+csize, tx + csize - 1, ty + csize, csize);
		}

		//������½ǵ�������
		if (dx >= tx + csize && dy < ty + csize) {
			//����������½�ʱ
			fullChessBoard(tx+csize, ty, dx, dy, csize);
		} else {
			arr[tx + csize][ty + csize - 1] = t;
			fullChessBoard(tx+csize, ty, tx + csize, ty + csize - 1, csize);
		}

		//������½ǵ�������
		if (dx >= tx + csize && dy >= ty + csize) {
			//����������½�ʱ
			fullChessBoard(tx+csize, ty+csize, dx, dy, csize);
		} else {
			arr[tx + csize][ty + csize] = t;
			fullChessBoard(tx+csize, ty+csize, tx + csize, ty + csize, csize);
		}
	}
}

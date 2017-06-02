package A_MatchTable;

//安排比赛的日程表，n个选手，每个选手与另外的n-1个选手比一次，一个选手一天只比一次
//给出一个比赛日程表，（i，j）表示第i个选手在第j天遇到的对手
//例：
/*
 2个选手
 1 2
 2 1
 
 4个选手
 1 2 3 4
 2 1 4 3
 3 4 1 2
 4 3 2 1
 
 8个选手
 1 2 3 4 5 6 7 8
 2 1 4 3 6 5 8 7
 3 4 1 2 7 8 5 6 
 4 3 2 1 8 7 6 5
 5 6 7 8 1 2 3 4
 6 5 8 7 2 1 4 3
 7 8 5 6 3 4 1 2
 8 7 6 5 4 3 2 1
 
 */
public class MatchTable {
	private static int[][] arr=new int[100][100];

	public static void main(String[] args) {
		int x = 8;//2^3 = 8
		
		//init 
		for (int i = 0; i <x; i++) {
			arr[0][i] = i+1;
		}

		for (int r = 1; r < x; r = r * 2) {
			for (int i = 0; i < x; i += 2*r) {
				copy(r, i + r, 0, i, r);//左上->右下
				copy(r, i, 0, i + r, r);//右上->左下
			}
		}
		for (int dx = 0; dx < x; dx++) {
			for (int dy = 0; dy < x; dy++) {
				System.out.print(arr[dx][dy]+" ");
			}
			System.out.println();
		}
	}

	private static void copy(int tox, int toy, int fromx, int fromy, int row) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				arr[tox+i][toy+j]=arr[fromx+i][fromy+j];
			}
		}
	}

}

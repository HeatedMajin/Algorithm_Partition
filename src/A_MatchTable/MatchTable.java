package A_MatchTable;

//���ű������ճ̱�n��ѡ�֣�ÿ��ѡ���������n-1��ѡ�ֱ�һ�Σ�һ��ѡ��һ��ֻ��һ��
//����һ�������ճ̱���i��j����ʾ��i��ѡ���ڵ�j�������Ķ���
//����
/*
 2��ѡ��
 1 2
 2 1
 
 4��ѡ��
 1 2 3 4
 2 1 4 3
 3 4 1 2
 4 3 2 1
 
 8��ѡ��
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
				copy(r, i + r, 0, i, r);//����->����
				copy(r, i, 0, i + r, r);//����->����
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

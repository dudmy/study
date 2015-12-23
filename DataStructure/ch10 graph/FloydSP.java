package chapter10;

/*
 * 10.11 Floyd의 최단 경로 프로그램
 */
public class FloydSP {

	final int MAX_VERTICES = 7; // 정점의 수
	final int INF = 1000; // 무한대 (연결이 없는 경우)
	
	int[][] A;
	int[][] weight = {	// 네트워크의 인접 행렬
			{0, 7, INF, INF, 3, 10, INF},
			{7, 0, 4, 10, 2, 6, INF},
			{INF, 4, 0, 2, INF, INF, INF},
			{INF, 10, 2, 0, 11, 9, 4},
			{3, 2, INF, 11, 0, INF, 5},
			{10, 6, INF, 9, INF, 0, INF},
			{INF, INF, INF, 4, 5, INF, 0}
	};
	
	public FloydSP() {
		A = new int[MAX_VERTICES][MAX_VERTICES];
	}
	
	void floyd(int n) {
		for (int i = 0; i < n; i ++) // 초기화
			for (int j = 0; j < n; j++)
				A[i][j] = weight[i][j];
		
		for (int k = 0; k < n; k++)						// i 에서 j로 가기위해 거치는 정점 k
			for (int i = 0; i < n; i++)					// 출발 정점 i
				for (int j = 0; j < n; j++)				// 도착 정점 j
					if (A[i][k] + A[k][j] < A[i][j])	// k를 거치는 경로가 더 짧을 경우
						A[i][j] = A[i][k] + A[k][j];	// 가중치를 더 짧은 경로로 변경
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(A[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		FloydSP f = new FloydSP();
		f.floyd(f.MAX_VERTICES);
	}
	
}

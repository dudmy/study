package chapter10;

/*
 * 10.10 최단 경로 Dkjkstra 프로그램
 * 
 * 하나의 시작 정점으로부터 모든 다른 정점까지의 최단 경로를 찾는 알고리즘
 */
public class DijkstraSP {

	final int MAX_VERTICES = 7; // 정점의 수
	final int INF = 1000; // 무한대 (연결이 없는 경우)
	
	int[][] weight = {	// 네트워크의 인접 행렬
			{0, 7, INF, INF, 3, 10, INF},
			{7, 0, 4, 10, 2, 6, INF},
			{INF, 4, 0, 2, INF, INF, INF},
			{INF, 10, 2, 0, 11, 9, 4},
			{3, 2, INF, 11, 0, INF, 5},
			{10, 6, INF, 9, INF, 0, INF},
			{INF, INF, INF, 4, 5, INF, 0}
	};
	
	int[] distance;		// 시작 정점으로부터의 최단 경로 거리
	boolean[] found;	// 방문한 정점 표시
	
	public DijkstraSP() {
		distance = new int[MAX_VERTICES];
		found = new boolean[MAX_VERTICES];
	}
	
	// 최단 경로인 정점 구하기
	int choose(int n) {
		int min = 9999;
		int minpos = -1;
		
		for (int i = 0; i < n; i++) {
			if (distance[i] < min && !found[i]) {
				min = distance[i];
				minpos = i;
			}
		}
		return minpos;
	}
	
	void shortest_path(int start, int n) {
		for (int i = 0; i < n; i++) // 초기화
			distance[i] = weight[start][i];
		found[start] = true; // 시작 정점 방문 표시
		distance[start] = 0;

		int u;
		for (int i = 0; i < n-2; i++) { // 마지막 정점은 돌지 않아도 구해진다
			u = choose(n);
			found[u] = true;
			for (int w = 0; w < n; w++)
				if (!found[w]) {
					if (distance[u] + weight[u][w] < distance[w])
						distance[w] = distance[u] + weight[u][w]; // 새로운 경로 값으로 변경
				}
		}
		
		for (int i = 0; i < n; i++)
			System.out.print(distance[i] + " ");
	}
	
	public static void main(String[] args) {
		DijkstraSP d = new DijkstraSP();
		d.shortest_path(0, d.MAX_VERTICES);
	}
	
}

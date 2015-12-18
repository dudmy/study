package chapter10;

/*
 * 10.9 Prim의 최소 비용 신장 트리 프로그램
 */
public class PrimMST {
	
	final int MAX_VERTICES = 7;
	final int INF = 1000;
	
	boolean[] selected;
	int[] dist; // 현재까지 알려진 신장트리 정점 집합에서 정점까지의 거리
	int[][] weight = {
			{0, 29, INF, INF, INF, 10, INF},
			{29, 0, 16, INF, INF, INF, 15},
			{INF, 16, 0, 12, INF, INF, INF},
			{INF, INF, 12, 0, 22, INF, 18},
			{INF, INF, INF, 22, 0, 27, 25},
			{10, INF, INF, INF, 27, 0, INF},
			{INF, 15, INF, 18, 25, INF, 0}
	};
	
	public PrimMST() {
		selected = new boolean[MAX_VERTICES];
		dist = new int[MAX_VERTICES];
	}
	
	// 최소 dist[v] 값을 갖는 정점을 반환
	int get_min_vertex(int n) {
		int v = 0;
		for (int i = 0; i < n; i++)
			if (!selected[i]) { // 선택 안된 정점 하나 찾고
				v = i;
				break;
			}
		for (int i = 0; i < n; i++)
			if (!selected[i] && (dist[i] < dist[v])) // 선택 안된 정점 중 가장 작은 값
				v = i;
		return v; // 이 정점이 방문할 정점
	}
	
	void prim(int s, int n) {
		for (int i = 0; i < n; i++)
			dist[i] = INF;
		dist[s] = 0;
		int u;
		for (int i = 0; i < n; i++) {
			u = get_min_vertex(n);
			selected[u] = true; // 해당 정점 방문 표시
			if (dist[u] == INF)
				return;
			System.out.println(u);
			for (int v = 0; v < n; v++)
				if (weight[u][v] != INF) // 인접 정점 찾기
					if (!selected[v] && weight[u][v] < dist[v]) // 인접 정점을 dist에 표시하기
						dist[v] = weight[u][v];
		}
	}

	public static void main(String[] args) {
		PrimMST p = new PrimMST();
		p.prim(0, p.MAX_VERTICES);
	}
	
}

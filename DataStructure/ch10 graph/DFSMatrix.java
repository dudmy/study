package chapter10;

/*
 * 10.1 인접 배열로 표현된 그래프에 대한 깊이 우선 탐색 프로그램
 */
public class DFSMatrix extends AdjacencyMatrix {

	int[] visited;
	
	public DFSMatrix() {
		visited = new int[MAX_VERTICES];
	}
	
	// 인접 행렬로 표현된 그래프에 대한 깊이 우선 탐색
	void dfs_mat(int v) {
		visited[v] = 1;						// 정점 v의 방문 표시
		System.out.println(v);				// 방문한 정점 출력
		for (int w = 0; w < g.n; w++) {		// 인접 정점 탐색
			if (g.adj_mat[v][w] == 1 && visited[w] != 1)
				dfs_mat(w);					// 정점 w에서 DFS 새로 시작
		}
	}
	
	public static void main(String[] args) {
		DFSMatrix d = new DFSMatrix();
		
		for (int i = 0; i < 4; i++)
			d.insert_vertex(i);
		d.insert_edge(0, 1);
		d.insert_edge(1, 0);
		d.insert_edge(0, 3);
		d.insert_edge(3, 0);
		d.insert_edge(1, 2);
		d.insert_edge(2, 1);
		d.insert_edge(1, 3);
		d.insert_edge(3, 1);
		d.insert_edge(2, 3);
		d.insert_edge(3, 2);
		d.dfs_mat(0);
	}
	
}

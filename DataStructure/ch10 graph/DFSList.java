package chapter10;

/*
 * 10.2 인접 리스트로 표현된 그래프에 대한 깊이 우선 탐색 프로그램
 */
public class DFSList extends AdjacencyList {

	int[] visited;
	
	public DFSList() {
		visited = new int[MAX_VERTICES];
	}
	
	// 인접 리스트로 표현된 그래프에 대한 깊이 우선 탐색
	void dfs_list(int v) {
		visited[v] = 1;					// 정점 v의 방문 표시
		System.out.println(v);			// 방문한 정점 출력
		for (GraphNode w = g.adj_list[v]; w != null; w = w.link) { // 인접 정점 탐색
			if(visited[w.vertex] != 1)
				dfs_list(w.vertex);		// 정점 w에서 DFS 새로 시작
		}
	}
	
	public static void main(String[] args) {
		DFSList d = new DFSList();
		
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
		
		d.dfs_list(0);
	}
	
}

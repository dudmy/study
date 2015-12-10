package chapter10;

/*
 * 인접 행렬을 이용한 그래프 추상 데이터 타입의 구현
 */
public class AdjacencyMatrix implements GraphADT {

	final static int MAX_VERTICES = 5;
	GraphType g;
	
	public AdjacencyMatrix() {
		g = new GraphType();
	}
	
	class GraphType {
		
		int n; // 정점의 개수
		int[][] adj_mat;
		
		public GraphType() {
			n = 0;
			adj_mat = new int[MAX_VERTICES][MAX_VERTICES];
		}
		
	}
	
	@Override
	public void insert_vertex(int v) {
		if (g.n + 1 > MAX_VERTICES) {
			System.out.println("그래프 정점의 개수 초과");
			return;
		}
		g.n++;
	}

	@Override
	public void insert_edge(int u, int v) {
		if (u >= g.n || v >= g.n) {
			System.out.println("그래프 정점 번호 오류");
			return;
		}
		g.adj_mat[u][v] = 1;
		g.adj_mat[v][u] = 1;
	}

	@Override
	public void delete_vertex(int v) {
		if (g.n - 1 < 0) {
			System.out.println("그래프 정점의 개수 미만");
			return;
		}
		g.n--;
	}

	@Override
	public void delete_edge(int u, int v) {
		if (g.adj_mat[u][v] != 1 || g.adj_mat[v][u] != 1) {
			System.out.println("그래프 정점 번호 오류");
			return;
		}
		g.adj_mat[u][v] = 0;
		g.adj_mat[v][u] = 0;
	}

	@Override
	public void display() {
		for (int i = 0; i < MAX_VERTICES; i++) {
			for (int j = 0; j < MAX_VERTICES; j++)
				System.out.print(g.adj_mat[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		AdjacencyMatrix a = new AdjacencyMatrix();
		
		a.insert_vertex(1);
		a.insert_vertex(2);
		a.insert_vertex(3);
		a.insert_vertex(4);
		System.out.println("정점의 개수 : " + a.g.n);
		
		a.insert_edge(1, 2);
		a.display();
		System.out.println();
		
		a.delete_edge(2, 1);
		a.display();
	}

}

package chapter10;

/*
 * 인접 리스트를 이용한 그래프 추상 데이터 타입의 구현
 */
public class AdjacencyList implements GraphADT {

	final static int MAX_VERTICES = 5;
	GraphType g;
	
	public AdjacencyList() {
		g = new GraphType();
	}
	
	class GraphNode {
		
		int vertex;
		GraphNode link;
		
		public GraphNode(int vertex, GraphNode link) {
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	
	class GraphType {
		
		int n; // 정점의 개수
		GraphNode[] adj_list;
		
		public GraphType() {
			n = 0;
			adj_list = new GraphNode[MAX_VERTICES];
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
		GraphNode node = new GraphNode(v, g.adj_list[u]);
		g.adj_list[u] = node;
	}

	@Override
	public void delete_vertex(int v) {
		if (g.n - 1 < 0) {
			System.out.println("그래프 정점이 없음");
			return;
		}
		g.n--;
	}

	@Override
	public void delete_edge(int u, int v) {
		if (u >= g.n || v >= g.n) {
			System.out.println("그래프 정점 번호 오류");
			return;
		}
		g.adj_list[u] = null;
		g.adj_list[v] = null;
	}

	@Override
	public boolean is_empty() {
		return g.n == 0;
	}

	@Override
	public void display() {
		for(int i = 0; i < MAX_VERTICES; i++)
			System.out.print(g.adj_list[i] + " ");
	}
	
	public static void main(String[] args) {
		AdjacencyList a = new AdjacencyList();
		
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

package chapter10;

import chapter06.QueueADT;

/*
 * 10.3 인접 행렬로 표현된 그래프에 대한 너비 우선 탐색 프로그램
 */
public class BFSMatrix extends AdjacencyMatrix implements QueueADT<Integer> {

	int[] visited;
	QueueType q;
	
	public BFSMatrix() {
		visited = new int[MAX_VERTICES];
		q = new QueueType();
	}
	
	// 인접 행렬로 표현된 그래프의 너비 우선 탐색
	void bfs_mat(int v) {
		visited[v] = 1;								// 정점 v 방문 표시
		System.out.println(v);						// 정점 출력
		enqueue(v);									// 시작 정점을 큐에 저장
		while(!is_empty()) {
			v = dequeue();							// 큐에서 정점 추출
			for (int w = 0 ; w < g.n; w++) {		// 인접 정점 탐색 
				if (g.adj_mat[v][w] == 1 && visited[w] != 1) {
					visited[w] = 1;					// 방문 표시
					System.out.println(w);			// 정점 출력
					enqueue(w);						// 방문한 정점을 큐에 저장
				}
			}
		}
	}

	// 선형 배열로 된 큐
	class QueueType {
		
		int[] data;
		int size;
		
		public QueueType() {
			data = new int[MAX_VERTICES];
			size = 0;
		}
		
	}
	
	@Override
	public void error(String msg) {
		System.out.println(msg);
		System.exit(1);
	}

	@Override
	public boolean is_empty() {
		return q.size == 0;
	}
	
	@Override
	public boolean is_full() {
		return q.size == MAX_VERTICES;
	}

	@Override
	public void enqueue(Integer item) {
		if (is_full())
			error("큐가 꽉 찼습니다.");
		q.data[q.size++] = item;
	}

	@Override
	public Integer dequeue() {
		if (is_empty())
			error("큐에 값이 없습니다.");
		int item = q.data[0];
		for (int i = 0; i < q.size - 1; i++) {
			q.data[i] = q.data[i+1];
		}
		q.size--;
		return item;
	}

	@Override
	public Integer peek() {
		return q.data[0];
	}
	
	public static void main(String[] args) {
		BFSMatrix b = new BFSMatrix();
		
		for (int i = 0; i < 4; i++)
			b.insert_vertex(i);
		b.insert_edge(0, 1);
		b.insert_edge(1, 0);
		b.insert_edge(0, 3);
		b.insert_edge(3, 0);
		b.insert_edge(1, 2);
		b.insert_edge(2, 1);
		b.insert_edge(1, 3);
		b.insert_edge(3, 1);
		b.insert_edge(2, 3);
		b.insert_edge(3, 2);
		b.bfs_mat(0);
	}
	
}

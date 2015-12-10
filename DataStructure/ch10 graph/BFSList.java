package chapter10;

import chapter06.QueueADT;

/*
 * 10.4 인접 리스트로 표현된 그래프에 대한 너비 우선 탐색 프로그램
 */
public class BFSList extends AdjacencyList implements QueueADT<Integer> {

	int[] visited;
	QueueType q;
	
	public BFSList() {
		visited = new int[MAX_VERTICES];
		q = new QueueType();
	}
	
	// 인접 리스트로 표현된 그래프의 너비 우선 탐색
	void bfs_list(int v) {
		visited[v] = 1;								// 정점 v 방문 표시
		System.out.println(v);						// 정점 v 출력
		enqueue(v);									// 시작 정점을 큐에 저장
		while (!is_empty()) {
			v = dequeue();							// 큐에서 정점 추출
			for (GraphNode w = g.adj_list[v]; w != null; w = w.link) { // 인접 정점 탐색
				if (visited[w.vertex] != 1) {		// 미방문 정점 탐색
					visited[w.vertex] = 1;			// 방문 표시
					System.out.println(w.vertex);	// 정점 출력
					enqueue(w.vertex);				// 방문한 정점을 위해 삽입
				}
			}
		}
	}
	
	// 원형 배열로 만든 큐
	class QueueType {
		
		int[] data;
		int front;
		int rear;
		
		public QueueType() {
			data = new int[MAX_VERTICES];
			front = 0;
			rear = 0;
		}
		
	}
	
	@Override
	public void error(String msg) {
		System.out.println(msg);
		System.exit(1);
	}

	@Override
	public boolean is_empty() {
		return q.front == q.rear;
	}

	@Override
	public boolean is_full() {
		return q.front == (q.rear + 1) % MAX_VERTICES;
	}

	@Override
	public void enqueue(Integer item) {
		if (is_full())
			error("큐가 가득 찼습니다.");
		q.rear = (q.rear + 1) % MAX_VERTICES;
		q.data[q.rear] = item;
	}

	@Override
	public Integer dequeue() {
		if (is_empty())
			error("큐에 값이 없습니다.");
		q.front = (q.front + 1) % MAX_VERTICES;
		return q.data[q.front];
	}

	@Override
	public Integer peek() {
		if (is_empty())
			error("큐에 값이 없습니다.");
		return q.data[(q.front + 1) % MAX_VERTICES];
	}
	
	public static void main(String[] args) {
		BFSList b = new BFSList();
		
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
		
		b.bfs_list(0);
	}

}

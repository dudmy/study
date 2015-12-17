package chapter10;

import chapter08.PriorityQueueADT;

/*
 * 10.8 Kruskal의 최소 비용 신장 트리 프로그램
 */
class UnionFind extends AdjacencyMatrix {
	
	int[] parent = new int[7]; // 부모 노드
	int[] num = new int[7]; // 각 집합의 크기
	
	public UnionFind(int n) {
		for (int i = 0 ; i < n; i++) {
			parent[i] = -1;
			num[i] = 1;
		}
	}
	
	// vertex가 속하는 집합을 반환한다
	int set_find(int vertex) {
		int p, s, i;
		for (i = vertex; (p = parent[i]) >= 0; i = p) // 루트 노드까지 반복
			;
		s = i; // 집합의 대표 원소
		for (i = vertex; (p = parent[i]) >= 0; i = p)
			parent[i] = s; // 집합의 모든 원소들의 부모를 s로 설정
		return s;
	}
	
	// 두 개의 원소가 속한 집합을 합친다
	void set_union(int s1, int s2) {
		if (num[s1] < num[s2]) {
			parent[s1] = s2;
			num[s2] += num[s1];
		} else {
			parent[s2] = s1;
			num[s1] += num[s2];
		}
	}
	
}

// 히프의 요소 타입 정의
class Element {
	
	int key; // 간선의 가중치
	int u; // 정점 1
	int v; // 정점 2
	
	public Element(int key, int u, int v) {
		this.key = key;
		this.u = u;
		this.v = v;
	}
	
}

// 최소 히프 트리
class MinHeap implements PriorityQueueADT<Element> {

	final static int MAX_ELEMENT = 200;
	HeapType h;
	
	public MinHeap() {
		h = new HeapType();
	}
	
	class HeapType {
		
		Element[] heap;
		int size; // 히프 안에 저장된 요소의 개수
		
		public HeapType() {
			heap = new Element[MAX_ELEMENT];
			size = 0;
		}
		
	}
	
	@Override
	public boolean is_empty() {
		return h.size == 0;
	}

	@Override
	public boolean is_full() {
		return h.size == MAX_ELEMENT;
	}

	@Override
	public void insert(Element item) {
		int i = ++h.size;
		while (i != 1 && item.key < h.heap[i/2].key) {
			h.heap[i] = h.heap[i/2];
			i /= 2;
		}
		h.heap[i] = item;
	}

	@Override
	public Element delete() {
		Element item = h.heap[1];
		Element temp = h.heap[h.size--];
		int parent = 1;
		int child = 2;
		while (child <= h.size) {
			if (child < h.size && h.heap[child].key > h.heap[child + 1].key)
				child++;
			if (temp.key <= h.heap[child].key)
				break;
			h.heap[parent] = h.heap[child];
			parent = child;
			child *= 2;
		}
		h.heap[parent] = temp;
		return item;
	}

	@Override
	public Element find() {
		return h.heap[1];
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
	}
	
}

// Kruskal Algorithm
class Kruskal extends MinHeap {
	
	// 정점 u와 정점 v를 연결하는 가중치가 weight인 간선을 히프에 삽입
	void insert_heap_edge(int u, int v, int weight) {
		Element e = new Element(weight, u, v);
		insert(e);
	}
	
	// 인접 행렬이나 인접 리스트에서 간선들을 읽어서 최소 히프에 삽입
	// 현재는 예제 그래프의 간선들을 삽입한다
	void insert_all_edges() {
		insert_heap_edge(0, 1, 29);
		insert_heap_edge(1, 2, 16);
		insert_heap_edge(2, 3, 12);
		insert_heap_edge(3, 4, 22);
		insert_heap_edge(4, 5, 27);
		insert_heap_edge(5, 0, 10);
		insert_heap_edge(6, 1, 15);
		insert_heap_edge(6, 3, 18);
		insert_heap_edge(6, 4, 25);
	}

	void kruskal(int n) {
		int edge_accepted = 0;	// 현재까지 선택된 간선의 수
		int uset, vset;			// 정점 u와 정점 v의 집합 번호
		Element e;				// 히프 요소
		
		insert_all_edges();		// 히프에 간선들을 삽입
		UnionFind uf = new UnionFind(n);	// 집합 초기화
		
		while (edge_accepted < n - 1) {		// 간선의 수 < n-1
			e = delete();					// 최소 히프에서 삭제
			uset = uf.set_find(e.u);		// 정점 u의 집합번호
			vset = uf.set_find(e.v);		// 정점 v의 집합번호
			if (uset != vset) {				// 서로 속한 집합이 다르면
				System.out.println("(" + e.u + ", " + e.v + ") " + e.key);
				edge_accepted++;
				uf.set_union(uset, vset);	// 두 개의 집합을 하친다
			}
		}
	}
	
}

public class KruskalMST {

	public static void main(String[] args) {
		Kruskal k = new Kruskal();
		k.kruskal(7);
	}
	
}

package chapter10;

/*
 * 추상 자료형 그래프
 */
public interface GraphADT {

	// 그래프에 정점 v를 삽입한다
	void insert_vertex(int v);
	
	// 그래프에 간선 (u, v)를 삽입한다
	void insert_edge(int u, int v);
	
	// 그래프의 정점 v를 삭제한다
	void delete_vertex(int v);
	
	// 그래프의 간선 (u, v)를 삭제한다
	void delete_edge(int u, int v);
	
	// 그래프가 공백 상태인지 확인한다
	boolean is_empty();
	
}

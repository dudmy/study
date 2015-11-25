package chapter08;

/*
 * 추상 자료형 우선순위 큐
 */
public interface PriorityQueueADT <E> {

	// 우선순위 큐가 비어 있는지를 검사한다
	boolean is_empty();
	
	// 우선순위 큐가 가득 찼는지를 검사한다
	boolean is_full();
	
	// 우선순위 큐에 요소 item을 추가한다
	void insert(E item);
	
	// 우선순위 큐로부터 가장 우선순위가 높은 요소를 삭제하고 이를 반환한다
	E delete();
	
	// 우선순위가 가장 높은 요소를 반환한다
	E find();

	void display();
	
}

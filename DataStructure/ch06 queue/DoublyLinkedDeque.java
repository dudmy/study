package chapter06;

/*
 * 6.9 덱 프로그램
 */
class Deque<E> implements DequeADT<E> {

	DequeType dq;
	
	public Deque() {
		dq = new DequeType();
	}
	
	class DlistNode { // 노드의 타입
		
		E data;
		DlistNode llink;
		DlistNode rlink;
		
		public DlistNode(DlistNode llink, E data, DlistNode rlink) {
			this.data = data;
			this.llink = llink;
			this.rlink = rlink;
		}
		
	}
	
	class DequeType { // 덱의 타입
		
		DlistNode head;
		DlistNode tail;
		
		public DequeType() {
			head = null;
			tail = null;
		}
		
	}
	
	@Override
	public boolean is_empty() {
		if (dq.head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean is_full() {
		return false;
	}

	// 전단에서의 삽입
	@Override
	public void add_front(E item) {
		DlistNode new_node = new DlistNode(null, item, dq.head);
		
		if (is_empty()) {
			dq.tail = new_node;
		} else {
			dq.head.llink = new_node;
		}
		dq.head = new_node;
	}

	// 후단에서의 삽입
	@Override
	public void add_rear(E item) {
		DlistNode new_node = new DlistNode(dq.tail, item, null);
		
		if (is_empty()) {
			dq.head = new_node;
		} else {
			dq.tail.rlink = new_node;
		}
		dq.tail = new_node;
	}

	// 전단에서의 삭제
	@Override
	public E delete_front() {
		if (is_empty())
			error("공백 덱에서 삭제");
		
		DlistNode removed_node = dq.head;	// 삭제할 노드
		E item = removed_node.data;			// 데이터 추출
		dq.head = dq.head.rlink;			// 헤드 포인터 변경
		
		if (dq.head == null) {				// 공백 상태이면
			dq.tail = null;
		} else {							// 공백 상태가 아니면
			dq.head.llink = null;
		}
		return item;
	}

	// 후단에서의 삭제
	@Override
	public E delete_rear() {
		if (is_empty())
			error("공백 덱에서 삭제");
		
		DlistNode removed_node = dq.tail;	// 삭제할 노드
		E item = removed_node.data;			// 데이터 추출
		dq.tail = dq.tail.llink;			// 테일 포인터 변경
		
		if (dq.tail == null) {				// 공백 상태이면
			dq.head = null;
		} else {							// 공백 상태가 아니면
			dq.tail.rlink =  null;
		}
		return item;
	}

	@Override
	public E get_front() {
		if (is_empty())
			error("공백 덱");
		return dq.head.data;
	}

	@Override
	public E get_rear() {
		if (is_empty())
			error("공백 덱");
		return dq.tail.data;
	}

	@Override
	public void error(String msg) {
		System.out.println(msg);
		System.exit(1);
	}
	
	void display() {
		DlistNode p;
		for (p = dq.head; p != null; p = p.rlink) {
			System.out.print(p.data + "->");
		}
		System.out.println();
	}
	
}

public class DoublyLinkedDeque {

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<Integer>();
		
		deque.add_front(10); // 전단에 10 삽입
		deque.add_front(20); // 전단에 20 삽입
		deque.add_rear(30); // 후단에 30 삽입
		deque.display(); // 덱의 내용 출력
		
		deque.delete_front(); // 전단에서 삭제
		deque.delete_rear(); // 후단에서 삭제
		deque.display(); // 덱의 내용 출력
	}
	
}

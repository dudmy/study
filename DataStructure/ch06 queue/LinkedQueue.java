package chapter06;

/*
 * 6.4 연결된 큐 프로그램
 */
class LQueue implements QueueADT<Integer>{

	QueueType q;
	
	public LQueue() {
		q = new QueueType();
	}
	
	class QueueNode { // 큐의 노드의 타입
		
		int item;
		QueueNode link;
		
		public QueueNode(int item) {
			this.item = item;
			link = null;
		}
		
	}
	
	class QueueType { // 큐 ADT 구현
		
		QueueNode front, rear;
		
		public QueueType() {
			front = null;
			rear = null;
		}
	}
	
	@Override
	public void error(String msg) {
		System.out.println(msg);
		System.exit(1);
	}

	@Override
	public boolean is_empty() {
		return q.front == null;
	}

	@Override
	public boolean is_full() {
		return false;
	}

	@Override
	public void enqueue(Integer item) {
		QueueNode temp = new QueueNode(item);
		if (is_empty()) { // 큐가 공백이면
			q.front = temp;
			q.rear = temp;
		} else { // 큐가 공백이 아니면
			q.rear.link = temp; //순서가 중요
			q.rear = temp;
		}
	}

	@Override
	public Integer dequeue() {
		QueueNode temp = q.front;
		
		if (is_empty()) // 공백 상태
			error("큐가 비어 있습니다.");
		
		int item = temp.item; // 데이터를 꺼낸다
		q.front = q.front.link; // front를 다음 노드를 가리키도록 한다
		if (q.front == null) // 공백 상태
			q.rear = null;
		return item;
	}

	@Override
	public Integer peek() {
		if (is_empty())
			error("큐가 비어 있습니다.");
		return q.front.item; // 데이터 반환
	}
	
}

// 연결된 큐 테스트 함수
public class LinkedQueue {

	public static void main(String[] args) {
		LQueue q = new LQueue();
		
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("isEmpty?=" + q.is_empty());
	}
	
}

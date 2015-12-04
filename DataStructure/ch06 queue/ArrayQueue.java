package chapter06;

/*
 * 6.1 원형 큐 프로그램
 */
public class ArrayQueue<E> implements QueueADT<E> {
	
	final static int MAX_QUEUE_SIZE = 100;
	QueueType q;
	
	public ArrayQueue() {
		q = new QueueType();
	}
	
	private class QueueType {
		
		E[] queue;
		int front, rear;
		
		public QueueType() {
			queue = (E[]) new Object[MAX_QUEUE_SIZE];
			front = 0;
			rear = 0;
		}
		
	}

	@Override
	public void error(String msg) {
		System.out.println(msg);
		System.exit(1);
	}
	
	// 공백 상태 검출 함수
	@Override
	public boolean is_empty() {
		return q.front == q.rear;
	}

	// 포화 상태 검출 함수
	@Override
	public boolean is_full() {
		return (q.rear + 1) % MAX_QUEUE_SIZE == q.front;
	}

	// 삽입 함수
	@Override
	public void enqueue(E item) {
		if (is_full())
			error("큐가 포화상태입니다.");
		q.rear = (q.rear + 1) % MAX_QUEUE_SIZE;
		q.queue[q.rear] = item;
	}

	// 삭제 함수
	@Override
	public E dequeue() {
		if (is_empty())
			error("큐가 공백상태입니다.");
		q.front = (q.front + 1) % MAX_QUEUE_SIZE;
		return q.queue[q.front];
	}

	// 피크 함수
	@Override
	public E peek() {
		if (is_empty()) 
			error("큐가 공백상태입니다.");
		return q.queue[(q.front + 1) % MAX_QUEUE_SIZE];
	}

	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("dequeue()=" + q.dequeue());
		System.out.println("isEmpty?=" + q.is_empty());
	}
	
}

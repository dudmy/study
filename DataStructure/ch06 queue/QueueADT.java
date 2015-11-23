package chapter06;

/*
 * 추상 자료형 Queue
 */
public interface QueueADT <E> {

	void error(String msg);
	
	boolean is_empty();
	
	boolean is_full();
	
	void enqueue(E item);
	
	E dequeue();
	
	E peek();
	
}

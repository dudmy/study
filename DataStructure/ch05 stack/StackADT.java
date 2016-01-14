package chapter05;

/*
 * ADT 5.1 추상 자료형 Stack
 */
public interface StackADT <E> {

	boolean is_empty();
	
	boolean is_full();
	
	void push(E item);
	
	E pop();
	
	E peek();
	
}

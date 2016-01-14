package chapter05;

/*
 * 5.3 일반적인 배열 스택 프로그램
 */
class Stack<E> implements StackADT<E> {

	final static int MAX_STACK_SIZE = 100;
	StackType s;
	
	public Stack() {
		s = new StackType();
	}
	
	private class StackType {
		
		E[] stack;
		int top;
		
		public StackType() {
			stack = (E[]) new Object[MAX_STACK_SIZE];
			top = -1;
		}
		
	}
	
	// 공백 상태 검출 함수
	@Override
	public boolean is_empty() {
		return s.top == -1;
	}

	// 포화 상태 검출 함수
	@Override
	public boolean is_full() {
		return s.top == MAX_STACK_SIZE - 1;
	}

	// 삽입 함수
	@Override
	public void push(E item) {
		if (is_full()) {
			System.out.println("스택 포화 에러");
			return;
		} else {
			s.stack[++s.top] = item;
		}
	}

	// 삭제 함수
	@Override
	public E pop() {
		if (is_empty()) {
			System.out.println("스택 공백 에러");
			System.exit(1);
		}
		return s.stack[s.top--];
	}

	// 피크 함수
	@Override
	public E peek() {
		if (is_empty()) {
			System.out.println("스택 공백 에러");
			System.exit(1);
		}
		return s.stack[s.top];
	}
	
}

public class ArrayStack extends Stack<Integer> {
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.is_empty());
	}
	
}

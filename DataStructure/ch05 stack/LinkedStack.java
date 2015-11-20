package chapter5;

/*
 * 5.4 연결된 스택 프로그램
 */
class LStack implements StackADT<Integer> {

	LinkedStackType s;

	public LStack() {
		s = new LinkedStackType();
	}
	
	class StackNode {
		
		int item;
		StackNode link;
		
		public StackNode(int item) {
			this.item = item;
		}
		
	}
	
	private class LinkedStackType {
		
		StackNode top;
		
		public LinkedStackType() {
			top = null;
		}
		
	}
	
	// 공백 상태 검출 함수
	@Override
	public boolean is_empty() {
		return s.top == null;
	}

	// 포화 상태 검출 함수
	@Override
	public boolean is_full() {
		return false;
	}

	// 삽입 함수
	@Override
	public void push(Integer item) {
		StackNode temp = new StackNode(item);
		temp.link = s.top;
		s.top = temp;
	}

	// 삭제 함수
	@Override
	public Integer pop() {
		if (is_empty()) {
			System.out.println("스택이 비어있음");
			System.exit(1);
		}
		StackNode temp = s.top;
		int item = temp.item;
		s.top = s.top.link;
		return item;
	}

	// 피크 함수
	@Override
	public Integer peek() {
		if (is_empty()) {
			System.out.println("스택이 비어있음");
			System.exit(1);
		}
		return s.top.item;
	}
	
}

public class LinkedStack {

	public static void main(String[] args) {
		LStack s = new LStack();
		
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.is_empty());
	}
	
}

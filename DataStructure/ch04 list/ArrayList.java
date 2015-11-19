package chapter4;

/*
 * 4.4 배열을 이용한 리스트 ADT 테스트 프로그램
 */
public class ArrayList {
	
	final static int MAX_LIST_SIZE = 100; // 배열의 최대 크기
	ArrayListType L;
	
	public ArrayList() {
		L = new ArrayListType();
	}
	
	private class ArrayListType {

		int list[]; // 배열 정의
		int length; // 현재 배열에 저장된 자료들의 개수
		
		ArrayListType() {
			list = new int[MAX_LIST_SIZE];
			length = 0;
		}
		
	}
	
	// 오류 처리 함수
	void error(String msg) {
		System.out.println(msg);
		System.exit(999);
	}

	// 리스트가 비어 있으면 true
	// 그렇지 않으면 false
	boolean is_empty() {
		return L.length == 0;
	}
	
	// 리스트가 가득 차 있으면 true
	// 그렇지 않으면 false
	boolean is_full() {
		return L.length == MAX_LIST_SIZE;
	}
	
	// 리스트 출력
	void display() {
		for (int i = 0; i < L.length; i++) {
			System.out.println(L.list[i]);
		}
	}
	
	// 삽입 함수
	void add(int pos, int item) {
		if (!is_full() && (pos >= 0) && (pos <= L.length)) {
			for (int i = L.length-1; i >= pos; i--) {
				L.list[i+1] = L.list[i];
			}
			L.list[pos] = item;
			L.length++;
		} else {
			error("가득 참");
		}
	}
	
	// 삭제 함수
	int delete(int pos) {
		if (pos < 0 || pos >= L.length) {
			error("위치 오류");
		}
		int item = L.list[pos];
		for (int i = pos; i < L.length-1; i++) {
			L.list[i] = L.list[i+1];
		}
		L.length--;
		return item;
	}
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		
		list.add(0, 10);
		list.add(0, 20);
		list.add(0, 30);
		list.display();
		
		System.out.println("-----");
		
		list.delete(1);
		list.display();
	}
	
}
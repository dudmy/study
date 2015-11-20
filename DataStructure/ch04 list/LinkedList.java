package chapter4;

/*
 * 4.28 연결 리스트로 구현된 리스트 ADT 테스트 프로그램
 */
class ListNode {
	
	int data;
	ListNode link;
	
	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}
	
}

public class LinkedListADT {

	LinkedListType list;
	
	public LinkedListADT() {
		list = new LinkedListType();
	}
	
	private class LinkedListType {
	
		ListNode head;
		int length;

		public LinkedListType() {
			head = null;
			length = 0;
		}
		
	}
	
	void error(String msg) {
		System.out.println(msg);
		System.exit(999);
	}
	
	boolean is_empty() {
		if (list.head == null) 
			return true;
		else 
			return false;
	}
	
	int get_length() {
		return list.length;
	}
	
	// 리스트 안에서 pos 위치의 노드를 반환한다
	ListNode get_node_at(int pos) {
		ListNode tmp_node = list.head;
		if (pos < 0) 
			return null;
		for (int i = 0; i < pos; i++) {
			tmp_node = tmp_node.link;
		}
		return tmp_node;
	}
	
	// 주어진 위치에 데이터를 삽입한다
	void add(int pos, int data) {
		if (pos >= 0 && pos <= list.length) {
			ListNode node = new ListNode(data);
			ListNode p = get_node_at(pos - 1); // 선행노드
			insert_node(p, node);
			list.length++;
		}
	}
	
	// 리스트의 끝에 데이터를 삽입한다
	void add_last(int data) {
		add(get_length(), data);
	}
	
	// 리스트의 처음에 데이터를 삽입한다
	void add_first(int data) {
		add(0, data);
	}

	// 주어진 위치의 데이터를 삭제한다
	void delete(int pos) {
		if (!is_empty() && pos >= 0 && pos < list.length) {
			ListNode p = get_node_at(pos-1);
			remove_node(p, (p != null) ? p.link : null);
			list.length--;
		}
	}
	
	void insert_node(ListNode p, ListNode new_node) {
		if (list.head == null) { // 공백 리스트인 경우
			list.head = new_node;
		} else if (p == null) { // p가 null이면 첫 번째 노드로 삽입
			new_node.link = list.head;
			list.head = new_node;
		} else { // p 다음에 삽입
			new_node.link = p.link;
			p.link = new_node;
		}
	}
	
	void remove_node(ListNode p, ListNode removed) {
		if (p == null) { //p가 null이면 첫 번째 노드를 삭제
			list.head = list.head.link;
		} else {
			p.link = removed.link;
		}
	}
	
	// 주어진 위치에 해당하는 데이터를 반환한다
	int get_entry(int pos) {
		if (pos >= list.length) 
			error("위치 오류");
		ListNode p = get_node_at(pos);
		return p.data;
	}
	
	// 모든 노드를 삭제한다
	void clear() {
		for (int i = 0; i < list.length; i++) {
			delete(i);
		}
	}
	
	// 버퍼의 내용을 출력한다
	void display() {
		ListNode node = list.head;
		for (int i = 0; i < list.length; i++) {
			System.out.print(node.data + "->");
			node = node.link;
		}
		System.out.println();
	}
	
	// 데이터 값인 s인 노드를 찾는다
	boolean is_in_list(int item) {
		ListNode p = list.head;
		while (p != null) {
			// 노드의 데이터가 item이면
			if (p.data == item)
				break;
			p = p.link;
		}
		if (p == null)
			return false;
		else
			return true;
	}
	
	public static void main(String[] args) {
		LinkedListADT list = new LinkedListADT();
		
		list.add(0, 20);
		list.add_last(30);
		list.add_first(10);
		list.add_last(40);
		list.display();
		
		list.delete(3);
		list.display();
		
		list.delete(0);
		list.display();
		
		System.out.println(list.is_in_list(20) == true ? "성공" : "실패");
		System.out.println(list.get_entry(0));
	}
	
}
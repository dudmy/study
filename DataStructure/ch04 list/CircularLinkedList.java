package chapter4;

/*
 * 4.15 원형 연결 리스트 테스트 프로그램
 */
class ListNode {
	
	int data;
	ListNode link;
	
	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}
	
}

public class CircularLinkedList {

	ListNode head;
	
	// 처음에 삽입하는 함수
	void insert_first(ListNode new_node) {
		if (head == null) {
			head = new_node;
			new_node.link = new_node;
		} else {
			new_node.link = head.link;
			head.link = new_node;
		}
	}
	
	// 마지막에 삽입하는 함수
	void insert_last(ListNode new_node) {
		if (head == null) {
			head = new_node;
			new_node.link = new_node;
		} else {
			new_node.link = head.link;
			head.link = new_node;
			head = new_node;
		}
	}

	// 리스트의 항목 출력
	void display() {
		ListNode p;
		if (head == null) return;

		p = head.link;
		do {
			System.out.print(p.data + "->");
			p = p.link;
		} while (p != head.link);
		System.out.println();
	}
	
	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		
		list.insert_first(new ListNode(10));
		list.insert_first(new ListNode(20));
		list.insert_last(new ListNode(30));
		list.insert_last(new ListNode(40));
		list.insert_first(new ListNode(50));
		list.display();
	}
	
}
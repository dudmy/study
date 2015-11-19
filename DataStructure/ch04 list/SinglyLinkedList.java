package chapter4;

/*
 * 4.12 단순 연결 리스트 테스트 프로그램
 */
class ListNode {
	
	int data;
	ListNode link;
	
	public ListNode(int data) {
		this.data = data;
		this.link = null;
	}
	
}

public class SinglyLinkedList {
	
	ListNode head;
	
	// 삽입 함수
	void insert_node(ListNode p, ListNode new_node) {
		if (head == null) { // 공백 리스트인 경우
			head = new_node;
		} else if (p == null) { // p가 null이면 첫 번째 노드로 삽입
			new_node.link = head;
			head = new_node;
		} else { // p 다음에 삽입
			new_node.link = p.link;
			p.link = new_node;
		}
	}
	
	// 삭제 함수
	void remove_node(ListNode p, ListNode removed) {
		if (p == null) { // p가 null이면 첫 번째 노드를 삭제
			head = head.link;
		} else {
			p.link = removed.link;
		}
	}
	
	// 방문 함수
	void display() {
		ListNode p = head;
		while (p != null) {
			System.out.print(p.data + "->");
			p = p.link;
		}
		System.out.println();
	}
	
	// 값 탐색 함수
	ListNode search(int x) {
		ListNode p = head;
		while(p != null) {
			if (p.data == x) {
				return p; //탐색 성공
			}
			p = p.link;
		}
		return p; //탐색 실패일 경우 null 반환
	}
	
	// 연결 리스트 연결 함수
	ListNode concat(ListNode head1, ListNode head2) {
		ListNode p;
		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		} else {
			p = head1;
			while (p.link != null) {
				p = p.link;
			}
			p.link = head2;
			return head1;
		}
	}
	
	// 연결 리스트 역순 함수
	ListNode reverse() {
		ListNode p, q, r; // 순회 포인터로 p, q, r을 사용
		p = head; // p는 아직 처리되지 않은 노드
		q = null; // q는 역순으로 만들 노드
		while (p != null) {
			r = q; // r은 역순으로 된 노드. r은 q, q는 p를 차례로 따라간다
			q = p;
			p = p.link;
			q.link = r;
		}
		return q;
	}
	
	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insert_node(null, new ListNode(10));
		list1.insert_node(null, new ListNode(20));
		list1.insert_node(null, new ListNode(30));
		list1.display();
		
		list1.remove_node(null, null);
		list1.display();
		
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insert_node(null, new ListNode(60));
		list2.insert_node(null, new ListNode(70));
		list2.insert_node(null, new ListNode(80));
		list2.display();
		
		list1.head = list1.concat(list1.head, list2.head);
		list1.display();
		
		list1.head = list1.reverse();
		list1.display();
		
		ListNode p = list1.search(80);
		System.out.println("탐색성공: " + p.data);
		
		list1.insert_node(p, new ListNode(90));
		list1.display();
	}
	
}
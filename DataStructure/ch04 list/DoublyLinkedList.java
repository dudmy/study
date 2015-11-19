package chapter4;

/*
 * 4.18 이중 연결 리스트 테스트 프로그램
 */
class DlistNode {
	
	int data;
	DlistNode llink;
	DlistNode rlink;
	
	public DlistNode() {
		this.llink = this;
		this.rlink = this;
	}
	
	public DlistNode(int data) {
		this.data = data;
		this.llink = null;
		this.rlink = null;
	}
	
}

public class DoublyLinkedList {

	DlistNode head;
	
	public DoublyLinkedList() {
		head = new DlistNode();
	}
	
	// head 노드 오른쪽에 삽입 함수
	void dinsert_node(DlistNode new_node) {
		new_node.llink = head;
		new_node.rlink = head.rlink;
		head.rlink.llink = new_node;
		head.rlink = new_node;
	}
	
	// 삭제 함수
	void dremove_node(DlistNode removed) {
		if (removed == head) return;
		removed.llink.rlink = removed.rlink;
		removed.rlink.llink = removed.llink;
	}
	
	// 리스트의 노드를 출력
	void display() {
		DlistNode p;
		for (p = head.rlink; p != head; p = p.rlink) {
			System.out.println(p.llink +  " | " + p.data + " | " + p.rlink);
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		DlistNode p[] = new DlistNode[10];
		
		for (int i = 0; i < 5; i++) {
			p[i] = new DlistNode(i);
			list.dinsert_node(p[i]);
		}
		list.dremove_node(p[3]);
		list.display();
	}
	
}
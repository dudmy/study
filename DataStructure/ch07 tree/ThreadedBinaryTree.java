package chapter07;

/*
 * 7.7 스레드 이진 트리 순회 프로그램 (inorder successor)
 */
class TTreeNode {
	
	char data;
	TTreeNode left, right;
	boolean is_thread; // 만약 오른쪽 링크가 스레드이면 TRUE
	
	public TTreeNode(char data, TTreeNode left, TTreeNode right, 
			boolean is_thread) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.is_thread = is_thread;
	}
	
}

class ThreadTraversal {
	
	// 중위 후속자 반환 함수
	TTreeNode find_successor(TTreeNode p) {
		// q는 p의 오른쪽 링크
		TTreeNode q = p.right;
		
		// 만약 오른쪽 링크가 null 이거나 스레드이면 오른쪽 링크를 반환
		if (q == null || p.is_thread == true)
			return q;
		
		// 만약 오른쪽 자식이면 다시 가장 왼쪽 노드로 이동
		while(q.left != null) 
			q = q.left;
		return q;
	}
	
	// 중위 순회 함수
	void thread_inorder(TTreeNode t) {
		TTreeNode q = t;
		while(q.left != null) // 가장 왼쪽 노드로 간다
			q = q.left;
		do {
			System.out.print(q.data + " "); // 데이터 출력
			q = find_successor(q); // 후속자 함수 호출
		} while(q != null);
	}
	
}

public class ThreadedBinaryTree {

	//			G
	//		C		F
	//	A	B		D	E
	public static void main(String[] args) {
		TTreeNode n1 = new TTreeNode('A', null, null, true);
		TTreeNode n2 = new TTreeNode('B', null, null, true);
		TTreeNode n3 = new TTreeNode('C', n1, n2, false);
		TTreeNode n4 = new TTreeNode('D', null, null, true);
		TTreeNode n5 = new TTreeNode('E', null, null, false);
		TTreeNode n6 = new TTreeNode('F', n4, n5, false);
		TTreeNode n7 = new TTreeNode('G', n3, n6, false);
		TTreeNode exp = n7;
		
		// 스레드 설정
		n1.right = n3;
		n2.right = n7;
		n4.right = n6;
		
		// 중위 순회
		ThreadTraversal t = new ThreadTraversal();
		t.thread_inorder(exp);
	}
	
}

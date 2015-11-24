package chapter07;

/*
 * 7.11 이진 탐색 트리 프로그램
 */
public class BinarySearchTree {
	
	// LinkedBinaryTree 파일의 TreeNode 클래스 사용
	
	// 반복적인 탐색 함수
	TreeNode search(TreeNode node, int key) {
		while(node != null) {
			if (key == node.data)		// 탐색 키와 루트 키가 같으면
				return node;
			else if (key < node.data)	// 탐색 키가 루트 키보다 작으면
				node = node.left;
			else						// 탐색 키가 루트 키보다 크면
				node = node.right;
		}
		return null; // 탐색에 실패했을 경우 null 반환
	}

	// 이진 탐색 트리에서의 삽입 함수
	void insert_node(TreeNode root, int key) { // key를 이진 탐색 트리 root에 삽입한다
											   // key가 이미 root 안에 있으면 삽입되지 않는다
		TreeNode p = null; // p는 부모 노드
		TreeNode t = root; // t는 현재 노드
		
		// 탐색을 먼저 수행
		while(t != null) {
			if (key == t.data) // 이미 존재
				return;
			p = t;
			if (key < t.data)
				t = t.left;
			else
				t = t.right;
		}
		
		// key가 트리 안에 없으므로 삽입 가능
		TreeNode n = new TreeNode(key, null, null); // n은 새로운 노드
		
		// 부모 노드와 연결
		if (p != null) {
			if (key < p.data)
				p.left = n;
			else
				p.right = n;
		} else {
			root = n;
		}
	}
	
	// 이진 탐색 트리에서의 삭제 함수
	void delete_node(TreeNode root, int key) {
		TreeNode p = null; // p는 t의 부모 노드
		TreeNode t = root;
		
		// key를 갖는 노드 t를 탐색
		while(t != null && t.data != key) {
			p = t;
			t = (key < t.data) ? t.left : t.right;
		}
		
		// 탐색이 종료된 시점에서 t가 null이면 트리 안에 key가 없음
		if (t == null) { // 탐색 트리에 없는 키
			System.out.println("key is not in the tree");
			return;
		}
		
		// 첫 번째: 단말 노드인 경우
		if (t.left == null && t.right == null) {
			if (p != null) {
				// 부모 노드의 자식 필드를 null로 만든다
				if (p.left == t)
					p.left = null;
				else
					p.right = null;
			} else { // 만약 부모 노드가 null이면 삭제되는 노드가 루트
				root = null;
			}
		} 
		
		// 두 번째: 하나의 자식만 가지는 경우
		else if (t.left == null || t.right == null){
			TreeNode child = (t.left != null) ? t.left : t.right;
			if (p != null) {
				if (p.left == t) // 부모를 자식과 연결
					p.left = child;
				else
					p.right = child;
			} else { // 만약 부모 노드가 null이면 삭제되는 노드가 루트
				root = child;
			}
		}
		
		// 세 번째: 두 개의 자식을 가지는 경우
		else {
			// 오른쪽 서브 트리에서 후계자를 찾는다
			TreeNode succ_p = t;
			TreeNode succ = t.right;
			// 후계자를 찾아서 계속 왼쪽으로 이동한다
			while(succ.left != null) {
				succ_p = succ;
				succ = succ.left;
			}
			// 후속자의 부모와 자식을 연결
			if (succ_p.left == succ)
				succ_p.left = succ.right;
			else
				succ_p.right = succ.right;
			// 후속자가 가진 키 값을 현재 노드에 복사
			t.data = succ.data;
			// 원래의 후속자 삭제
			t = succ;
		}
	}
	
	// 이진 탐색 트리 출력 함수
	void display(TreeNode node) {
		if (node != null) {
			System.out.print("(");
			display(node.left);
			System.out.print(node.data);
			display(node.right);
			System.out.print(")");
		}
	}
	
	//			17
	//		14		66
	//	02		  24	80
	//				34
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2, null, null);
		TreeNode n2 = new TreeNode(14, n1, null);
		TreeNode n3 = new TreeNode(34, null, null);
		TreeNode n4 = new TreeNode(28, null, n3);
		TreeNode n5 = new TreeNode(80, null, null);
		TreeNode n6 = new TreeNode(66, n4, n5);
		TreeNode n7 = new TreeNode(17, n2, n6);
		TreeNode root = n7;
		
		BinarySearchTree s = new BinarySearchTree();
		s.display(root);
		System.out.println();
		
		System.out.println(s.search(root, 28));
		
		s.delete_node(root, 17);
		s.display(root);
		System.out.println();

		s.insert_node(root, 15);
		s.display(root);
		System.out.println();
	}
	
}

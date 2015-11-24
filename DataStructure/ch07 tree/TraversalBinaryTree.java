package chapter07;

/*
 * 7.3 이진 트리의 3가지 순회 방법
 */
class Traversal {
	
	// LinkedBinaryTree 파일의 TreeNode 클래스 사용
	
	// 중위 순회
	void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);					// 왼쪽 서브 트리 순회
			System.out.print(root.data + " ");	// 노드 방문
			inorder(root.right);				// 오른쪽 서브 트리 순회
		}
	}
	
	// 전위 순회
	void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");	// 노드 방문
			preorder(root.left);				// 왼쪽 서브 트리 순회
			preorder(root.right);				// 오른쪽 서브 트리 순회
		}
	}
	
	// 후위 순회
	void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);				// 왼쪽 서브 트리 순회
			postorder(root.right);				// 오른쪽 서브 트리 순회
			System.out.print(root.data + " ");	// 노드 방문
		}
	}
	
}

public class TraversalBinaryTree {

	//		15
	//	  4		20
	//	1	   16  25
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1, null, null);
		TreeNode n2 = new TreeNode(4, n1, null);
		TreeNode n3 = new TreeNode(16, null, null);
		TreeNode n4 = new TreeNode(25, null, null);
		TreeNode n5 = new TreeNode(20, n3, n4);
		TreeNode n6 = new TreeNode(15, n2, n5);
		TreeNode root = n6;
		
		Traversal t = new Traversal();
		t.inorder(root);
		System.out.println();
		t.preorder(root);
		System.out.println();
		t.postorder(root);
	}
	
}

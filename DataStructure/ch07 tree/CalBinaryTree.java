package chapter07;

/*
 * 이진 트리와 관련된 여러 연산들
 */
class CalFunc {
	
	// LinkedBinaryTree 파일의 TreeNode 클래스 사용
	
	// 노드의 개수
	int get_node_count(TreeNode node) {
		int count = 0;
		if (node != null)
			count = 1 + get_node_count(node.left) + get_node_count(node.right);
		return count;
	}
	
	// 단말 노드의 개수
	int get_leaf_count(TreeNode node) {
		int count = 0;
		if (node != null) {
			if (node.left == null && node.right == null)
				return 1;
			else
				count = get_leaf_count(node.left) + get_leaf_count(node.right);
		}
		return count;
	}
	
	// 이진 트리의 높이
	int get_height(TreeNode node) {
		int height = 0;
		if (node != null)
			height = 1 + Math.max(get_height(node.left), get_height(node.right));
		return height;
	}
	
}

public class CalBinaryTree {

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
		
		CalFunc c = new CalFunc();
		System.out.println("노드 개수=" + c.get_node_count(root));
		System.out.println("단말 노드 개수=" + c.get_leaf_count(root));
		System.out.println("트리 높이=" + c.get_height(root));
	}
	
}

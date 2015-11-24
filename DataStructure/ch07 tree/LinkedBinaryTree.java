package chapter07;

/*
 * 7.1 링크법으로 생성된 이진 트리
 */
class TreeNode {

	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data, TreeNode left, TreeNode right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
}

public class LinkedBinaryTree {

	//		n1
	//	  n2  n3
	public static void main(String[] args) {
		TreeNode n3 = new TreeNode(30, null, null); // 세 번째 노드를 설정한다
		TreeNode n2 = new TreeNode(20, null, null); // 두 번째 노드를 설정한다
		TreeNode n1 = new TreeNode(10, n2, n3); // 첫 번째 노드를 설정한다
	}
	
}

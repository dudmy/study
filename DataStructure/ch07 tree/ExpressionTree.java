package chapter07;

/*
 * 7.5 수식 트리 계산 프로그램
 */
class ExpressionCal {

	// LinkedBinaryTree 파일의 TreeNode 클래스 사용
	
	// 수식 계산 함수
	int evaluate(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.data;
		} else {
			int op1 = evaluate(root.left);
			int op2 = evaluate(root.right);
			switch(root.data) {
				case '+':
					return op1 + op2;
				case '-':
					return op1 - op2;
				case '*':
					return op1 * op2;
				case '/':
					return op1 / op2;
			}
		}
		return 0;
	}
	
}

public class ExpressionTree {
	
	//			+
	//		*		+
	//	1	4		16	25
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1, null, null);
		TreeNode n2 = new TreeNode(4, null, null);
		TreeNode n3 = new TreeNode('*', n1, n2);
		TreeNode n4 = new TreeNode(16, null, null);
		TreeNode n5 = new TreeNode(25, null, null);
		TreeNode n6 = new TreeNode('+', n4, n5);
		TreeNode n7 = new TreeNode('+', n3, n6);
		TreeNode exp = n7;
		
		ExpressionCal e = new ExpressionCal();
		System.out.println(e.evaluate(exp));
	}
	
}

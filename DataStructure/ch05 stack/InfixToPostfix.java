package chapter5;

/*
 * 중위 표기 수식을 후위 표기 수식으로 변환하는 프로그램
 */
class IStack extends Stack<Character> {

	// ArrayStack.java 파일 내의 
	// Stack 클래스 상속하여 기본적인 Stack 기능 대체
	
	// 연산자의 우선순위를 반환한다
	int prec(char op) {
		switch(op) {
			case '(': case ')': return 0;
			case '+': case '-': return 1;
			case '*': case '/': return 2;
		}
		return -1;
	}
	
	// 중위 표기 수식 -> 후위 표기 수식
	void infix_to_postfix(String exp) {
		char[] ch_exp = exp.toCharArray();
		char ch, top_op;
		
		for (int i = 0; i < ch_exp.length; i++) {
			ch = ch_exp[i];
			switch(ch) {
				case '+': case '-': case '*': case '/': // 연산자
					// 스택에 있는 연산자의 우선순위가 더 크거나 같으면 출력
					while(!is_empty() && prec(ch) <= prec(peek())) 
						System.out.print(pop());
					push(ch);
					break;
				case '(': // 왼쪽 괄호
					push(ch);
					break;
				case ')': // 오른쪽 괄호
					top_op = pop();
					// 왼쪽 괄호를 만날 때까지 출력
					while(top_op != '(') {
						System.out.print(top_op);
						top_op = pop();
					}
					break;
				default: // 피연산자
					System.out.print(ch);
					break;
			}
		}
		while(!is_empty()) // 스택에 저장된 연산자들 출력
			System.out.print(pop());
	}
	
}

public class InfixToPostfix {
	
	public static void main(String[] args) {
		IStack s = new IStack();
		s.infix_to_postfix("(2+3)*4+9");
	}
	
}

package chapter5;

/*
 * 5.6 후위 표기식 계산
 */
class PStack extends Stack<Integer> {
	
	// ArrayStack.java 파일 내의 
	// Stack 클래스 상속하여 기본적인 Stack 기능 대체
	
	// 후위 표기 수식 계산 함수
	int eval(String exp) {
		char[] exp_ch = exp.toCharArray();
		int op1, op2, value;
		char ch;
		
		for (int i = 0; i < exp_ch.length; i++) {
			ch = exp_ch[i];
			
			if (ch != '+' && ch != '-' && ch != '*' && ch != '/') {
				value = ch - '0'; // 입력이 피연산자이면
				push(value);
				
			} else { // 연산자이면 피연산자를 스택에서 제거
				op2 = pop();
				op1 = pop();
				switch(ch) { // 연산을 수행하고 스택에 저장
					case '+': 
						push(op1 + op2);
						break;
					case '-': 
						push(op1 - op2);
						break;
					case '*': 
						push(op1 * op2);
						break;
					case '/': 
						push(op1 / op2);
						break;
				}
			}
		}
		return pop();
	}
	
}

public class PostfixCal {

	public static void main(String[] args) {
		PStack s = new PStack();
		
		int result = s.eval("82/3-32*+");
		System.out.println("후위표기식은 82/3-32*+");
		System.out.println("결과값은 " + result);
	}
	
}

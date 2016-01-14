package chapter05;

/*
 * 5.5 괄호 검사 프로그램
 */
class MStack extends Stack<Character> {
	
	// ArrayStack.java 파일 내의 
	// Stack 클래스 상속하여 기본적인 Stack 기능 대체
	
	// 괄호 검사 함수
	boolean check_matching(String in) {
		char[] ch_in = in.toCharArray();
		char ch, open_ch;
		
		for (int i = 0; i < ch_in.length; i++) {
			ch = ch_in[i]; // 다음 문자
			
			switch(ch) {
				case '(': case '[': case '{':
					push(ch);
					break;
				case ')': case ']': case '}':
					if (is_empty()) {
						return false;
					} else {
						open_ch = pop();
						if (open_ch == '(' && ch != ')' || 
								open_ch == '[' && ch != ']' || 
								open_ch == '{' && ch != '}')
							return false;
					} 
					break;
			}
		}
		if (!is_empty()) // 스택에 남아 있으면 오류
			return false;
		return true;
	}
	
}

public class MatchBracket {
	
	public static void main(String[] args) {
		MStack s = new MStack();
		
		if (s.check_matching("{ A[(i+1)]=0; }")) {
			System.out.println("괄호검사성공");
		} else {
			System.out.println("괄호검사실패");
		}
	}

}

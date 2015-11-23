package chapter5;

/*
 * 5.8 미로 탐색 프로그램
 */
class Elem {
	
	int r;
	int c;
	
	public Elem(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
}

class MazeStack extends Stack<Elem> {
	
	// ArrayStack.java 파일 내의 
	// Stack 클래스 상속하여 기본적인 Stack 기능 대체
	
	// 위치를 스택에 삽입
	void push_loc(int r, int c) {
		if (r < 0 || c < 0)
			return;
		if (Maze.maze[r][c] != '1' && Maze.maze[r][c] != '.') { // 벽이 아니고 방문되지 않았으면
			Elem tmp = new Elem(r, c);
			push(tmp);
		}
	}
	
}

public class Maze {
	
	static char[][] maze = {
			{'1', '1', '1', '1', '1', '1'},
			{'e', '0', '1', '0', '0', '1'},
			{'1', '0', '0', '0', '1', '1'},
			{'1', '0', '1', '0', '1', '1'},
			{'1', '0', '1', '0', '0', 'x'},
			{'1', '1', '1', '1', '1', '1'},
	};
	
	public static void main(String[] args) {
		Elem here = new Elem(1, 0);
		MazeStack s = new MazeStack();
		int r, c;
		
		while(maze[here.r][here.c] != 'x') {
			r = here.r;
			c = here.c;
			maze[r][c] = '.'; // 방문한 점 표시
			
			s.push_loc(r-1, c);
			s.push_loc(r+1, c);
			s.push_loc(r, c-1);
			s.push_loc(r, c+1);
			
			if (s.is_empty()) {
				System.out.println("실패");
				return;
			} else {
				here = s.pop();
			}
		}
		System.out.println("성공");
	}
	
}

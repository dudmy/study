package chapter02;

/*
 * 2.8 하노이탑 문제 프로그램
 */
public class HanoiTower {

	void hanoi_tower(int n, char from, char tmp, char to) {
		if (n == 1) {
			System.out.println("원판 1을 " + from + "에서 " + to + "으로 옮긴다.");
		} else {
			hanoi_tower(n-1, from, to, tmp);
			System.out.println("원판 " + n + "을 " + from + "에서 " + to + "으로 옮긴다.");
			hanoi_tower(n-1, tmp, from, to);
		}
	}
	
	public static void main(String[] args) {
		HanoiTower ht = new HanoiTower();
		ht.hanoi_tower(3, 'A', 'B', 'C');
	}
}
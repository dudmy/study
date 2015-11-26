package chapter09;

/*
 * 9.4 버블 정렬 프로그램
 */
public class BubbleSort {
	
	void bubble_sort(int[] list, int n) {
		int temp;
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < i; j++) { // 앞뒤의 레코드를 비교한 후 교체
				if (list[j] > list[j+1]) {
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 100;
		int[] list = new int[100];
		
		for (int i = 0; i < n; i++)
			list[i] = (int) (Math.random() * n);
		
		BubbleSort s = new BubbleSort();
		s.bubble_sort(list, n);
		
		for (int i = 0; i < n; i++)
			System.out.print(list[i] + " ");
	}
	
}

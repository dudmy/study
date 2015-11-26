package chapter09;

/*
 * 9.3 삽입 정렬 프로그램
 */
public class InsertionSort {

	// 삽입 정렬
	void insertion_sort(int[] list, int n) {
		int key, j;
		for (int i = 1; i < n; i++) {
			key = list[i];
			for (j = i - 1; j >= 0 && list[j] > key; j--)
				list[j+1] = list[j]; // 레코드의 오른쪽으로 이동
			list[j+1] = key;
		}
	}
	
	public static void main(String[] args) {
		int n = 100;
		int[] list = new int[100];
		
		for (int i = 0; i < n; i++)
			list[i] = (int) (Math.random() * n);
		
		InsertionSort s = new InsertionSort();
		s.insertion_sort(list, n);
		
		for (int i = 0; i < n; i++)
			System.out.print(list[i] + " ");
	}
	
}

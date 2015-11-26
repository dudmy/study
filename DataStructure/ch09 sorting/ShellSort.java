package chapter09;

/*
 * 9.5 셀 정렬 프로그램
 */
public class ShellSort {

	// gap만큼 떨어진 요소들을 삽입 정렬
	// 정렬의 범위는 first에서 last
	void inc_insertion_sort(int[] list, int first, int last, int gap) {
		int j, key;
		for (int i = first+gap; i <= last; i+=gap ) {
			key = list[i];
			for (j = i-gap; j >= first && key < list[j]; j-=gap)
				list[j+gap] = list[j];
			list[j+gap] = key;
		}
	}
	
	void shell_sort(int[] list, int n) { // n = size
		for (int gap = n/2; gap > 0; gap/=2) {
			if (gap % 2 == 0)
				gap++;
			for (int i = 0; i < gap; i++) // 부분 리스트의 개수는 gap
				inc_insertion_sort(list, i, n-1, gap);
		}
	}
	
	public static void main(String[] args) {
		int n = 11;
		int[] list = {10, 8, 6, 20, 4, 3, 22, 1, 0, 15, 16};
		
		ShellSort s = new ShellSort();
		s.shell_sort(list, n);
		
		for (int i = 0; i < n; i++)
			System.out.print(list[i] + " ");
	}
	
}

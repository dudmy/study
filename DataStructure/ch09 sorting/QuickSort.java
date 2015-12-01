package chapter09;

/*
 * 9.9 퀵 정렬 프로그램
 */
public class QuickSort {

	void quick_sort(int[] list, int left, int right) {
		if (left < right) {							// 정렬할 범위가 2개 이상의 데이터면
			int q = partition(list, left, right);	// 피벗을 기준으로 2개의 리스트로 분할
			quick_sort(list, left, q - 1);
			quick_sort(list, q + 1, right);
		}
	}
	
	int partition(int[] list, int left, int right) {
		int pivot = list[left];
		
		int low = left;
		int high = right + 1;
		int temp;
		
		do {
			do {
				low++;
			} while (low <= right && list[low] < pivot);
			
			do {
				high--;
			} while (high >= left && list[high] > pivot);
			
			if (low < high) {
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		} while (low < high);
		
		temp = list[left];
		list[left] = list[high];
		list[high] = temp;
		
		return high;
	}
	
	void display(int[] list) {
		for (int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	
	public static void main(String[] args) {
		int[] list = {5, 3, 8, 4, 9, 1, 6, 2, 7};
		
		QuickSort s = new QuickSort();
		s.quick_sort(list, 0, list.length - 1);
		s.display(list);
	}
	
}

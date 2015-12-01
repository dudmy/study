package chapter09;

/*
 * 9.6 합병 정렬 프로그램
 */
public class MergeSort {

	final static int MAX_SIZE = 10;
	int[] sorted;
	
	public MergeSort() {
		sorted = new int[MAX_SIZE];
	}
	
	void merge(int[] list, int left, int mid, int right) {
		int i = left;		// i는 정렬된 왼쪽 리스트에 대한 인덱스
		int j = mid + 1;	// j는 정렬된 오른쪽 리스트에 대한 인덱스
		int k = left;		// k는 정렬될 리스트에 대한 인덱스
		
		// 분할 정렬된 list의 합병
		while (i <= mid && j <= right) {
			if (list[i] <= list[j])
				sorted[k++] = list[i++];
			else
				sorted[k++] = list[j++];
		}
		
		if (i > mid) {						// 남아 있는 레코드의 일괄 복사
			for (int l = j; l <= right; l++)
				sorted[k++] = list[l];
		} else {							// 남아 있는 레코드의 일괄 복사
			for (int l = i; l <= mid; l++)
				sorted[k++] = list[l];
		}
		
		// 배열 sorted[]의 리스트를 배열 list로 복사
		for(int l = left; l <= right; l++)
			list[l] = sorted[l];
	}
	
	void merge_sort(int[] list, int left, int right) {
		int mid;
		if (left < right) {
			mid = (left + right) / 2;			// 리스트의 균등 분할
			merge_sort(list, left, mid);		// 부분 리스트 정렬
			merge_sort(list, mid + 1, right);	// 부분 리스트 정렬
			merge(list, left, mid, right);		// 합벙
		}
	}
	
	void display(int[] list) {
		for(int i = 0; i < list.length; i++)
			System.out.print(list[i] + " ");
	}
	
	public static void main(String[] args) {
		int[] list = {27, 10, 12, 20, 25, 13, 15, 22};
		
		MergeSort s = new MergeSort();
		s.merge_sort(list, 0, list.length - 1);
		s.display(list);
	}
	
}

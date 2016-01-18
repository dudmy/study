package chapter12;

/*
 * 12.1 순차 탐색 & 12.3 정렬된 배열에서의 순차 탐색
 */
public class SequentialSearch {
	
	int[] list = {5, 3, 8, 4, 9, 1, 6, 2, 7};
	int[] list2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	
	int seq_search(int key, int low, int high) {
		for (int i = low; i <= high; i++)
			if (list[i] == key)
				return i;	// 탐색에 성공하면 키 값의 인덱스 반환
		return -1;			// 탐색에 실패하면 -1 반환
	}
	
	// 오름차순으로 정렬된 배열 리스트의 순차 탐색
	int sorted_seq_search(int key, int low, int high) {
		for (int i = low; i <= high; i++) {
			if (list2[i] > key) return -1;
			if (list2[i] == key) return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		SequentialSearch s = new SequentialSearch();
		
		int result = s.seq_search(1, 0, s.list.length);
		System.out.println(result);
		
		int result2 = s.sorted_seq_search(5, 0, s.list2.length);
		System.out.println(result2);
	}
	
}
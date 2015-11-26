package chapter09;

/*
 * 9.2 선택 정렬 프로그램
 */
public class SelectionSort {
	
	// 선택 정렬 함수
	void selection_sort(int[] list, int n) {
		int least, temp;
		for (int i = 0; i < n-1; i++) {
			least = i;
			for (int j = i + 1; j < n; j++) // 최소값 탐색
				if (list[j] < list[least])
					least = j;
			if (i != least) {  // 자료가 정렬되지 않은 경우
				temp = list[i];
				list[i] = list[least];
				list[least] = temp;
			}
		}
	}
	
	public static void main(String[] args) {	
		int n = 100;
		int[] list = new int[100];

		for (int i = 0; i < n; i++)					// 난수 생성 및 출력
			list[i] = (int) (Math.random() * n);	// 난수 발생 범위 0~n

		SelectionSort s = new SelectionSort();
		s.selection_sort(list, n);					// 선택 정렬 호출
		
		for (int i = 0; i < n; i++)					// 정렬 결과 호출
			System.out.print(list[i] + " ");
	}
	
}
